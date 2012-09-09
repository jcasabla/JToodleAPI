/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import jtoodle.api.beans.BeanParseUtil;
import jtoodle.api.beans.TokenBean;
import jtoodle.api.beans.UserIdBean;
import jtoodle.api.util.NullSafe;

/**
 *
 * @author justo
 */
public class AuthCache {

	private static final Logger logger = Logger.getLogger( AuthCache.class.getName() );

	private static final long MAX_TOKEN_AGE =
		4 // hours
		* 60 // minutes/hour
		* 60 // seconds/minute
		* 1000 // millis/second
		;

	private static final String KEY_EMAIL = "email";
	private static final String KEY_USER_ID = "userId";
	private static final String KEY_TOKEN = "token";
	private static final String KEY_TOKEN_TIMESTAMP_MILLIS = "tokenTimestamp(millis)";
	private static final String KEY_TOKEN_TIMESTAMP_TEXT = "tokenTimestamp(text)";

	private static final Preferences _prefs = Preferences.userRoot().node( "/jtoodle/api/auth" );

	private static void save() {
		logger.entering( AuthCache.class.getName(), "save()" );

		try {
			_prefs.flush();
		} catch( BackingStoreException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}

		logger.exiting( AuthCache.class.getName(), "save()" );
	}

	public static void setEmail( String email ) {
		if( !NullSafe.equals( getEmail(), email ) ) {
			_prefs.put( KEY_EMAIL, email );
			setUserId( null );
		}
	}

	public static String getEmail() {
		return( _prefs.get( KEY_EMAIL, null ) );
	}
	private static String _password = null;

	public static void setPassword( String password ) {
		_password = password;
	}

	private static void setUserId( String userId ) {
		if( NullSafe.isNullOrEmpty( userId ) ) {
			_prefs.remove( KEY_USER_ID );
		} else {
			_prefs.put( KEY_USER_ID, userId );
		}
		save();
	}

	public static String getUserId() {
		String userId = _prefs.get( KEY_USER_ID, null );

		if( ( userId == null ) || ( userId.trim().length() == 0 ) ) {
			try {
				AccountLookupRequest alr = new AccountLookupRequest();
				alr.setEmail( getEmail() );
				alr.setPassword( _password );

				UserIdBean bean = BeanParseUtil.toUserIdBean( alr.request() );

				if( bean.hasError() ) {
					bean.throwException();
				} else {
					setUserId( bean.getUserId() );
				}
			} catch( IOException | NoSuchAlgorithmException ex ) {
				logger.log( Level.SEVERE, null, ex );
			}
		}

		return( userId );
	}

	private static void setToken( String token ) {
		if( NullSafe.isNullOrEmpty( token ) ) {
			_prefs.remove( KEY_TOKEN );
		} else {
			_prefs.put( KEY_TOKEN, token );
		}

		markTokenTimestampMillis();
		save();
	}

	public static String getToken() {
		String token = _prefs.get( KEY_TOKEN, null );

		if( ( token == null ) || ( token.trim().length() == 0 ) || tokenIsStale() ) {
			try {
				TokenRequest tr = new TokenRequest();
				tr.setUserId( getUserId() );

				TokenBean bean = BeanParseUtil.toTokenBean( tr.request() );

				if( bean.hasError() ) {
					bean.throwException();
				} else {
					setToken( bean.getToken() );
				}
			} catch( IOException | NoSuchAlgorithmException ex ) {
				logger.log( Level.SEVERE, null, ex );
			}
		}

		return( token );
	}

	private static void markTokenTimestampMillis() {
		long ts = System.currentTimeMillis();
		_prefs.putLong( KEY_TOKEN_TIMESTAMP_MILLIS, ts );
		_prefs.put( KEY_TOKEN_TIMESTAMP_TEXT, new Date( ts ).toString() );
	}

	private static long getTokenTimestampMillis() {
		return( _prefs.getLong( KEY_TOKEN_TIMESTAMP_MILLIS, System.currentTimeMillis() ) );
	}

	private static boolean tokenIsStale() {
		long tokenAge = System.currentTimeMillis() - getTokenTimestampMillis();
		return( tokenAge >= MAX_TOKEN_AGE );
	}
}
