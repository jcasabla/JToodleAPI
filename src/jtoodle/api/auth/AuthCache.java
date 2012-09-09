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
import jtoodle.api.util.WebRequestConstants;
import jtoodle.api.util.WebRequestUtils;
import org.openide.util.Exceptions;

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
	private static final String KEY_PASSWORD = "hashedPassword";
	private static final String KEY_USER_ID = "userId";
	private static final String KEY_TOKEN = "token";
	private static final String KEY_API_KEY = "apiKey";
	private static final String KEY_TOKEN_TIMESTAMP_MILLIS = "tokenTimestamp(millis)";
	private static final String KEY_TOKEN_TIMESTAMP_TEXT = "tokenTimestamp(text)";

	private static final Preferences _prefs = Preferences.userRoot().node( "/jtoodle/api/auth" );

	private static String _password = null;

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

	public static void setPassword( String password ) {
		_password = password;
	}

	private static String getHashedPassword() {
		return( _prefs.get( KEY_PASSWORD, null ) );
	}

	private static void storeHashedPassword() {
		if( NullSafe.isNullOrEmpty( _password ) ) {
			_prefs.remove( KEY_PASSWORD );
		} else {
			try {
				_prefs.put( KEY_PASSWORD, WebRequestUtils.md5Hash( _password ) );
			} catch( NoSuchAlgorithmException ex ) {
				logger.log( Level.SEVERE, null, ex );
			}
		}
		save();
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

		if( NullSafe.isNullOrEmpty( userId ) ) {
			try {
				AccountLookupRequest alr = new AccountLookupRequest();
				alr.setEmail( getEmail() );
				alr.setPassword( _password );

				UserIdBean bean = BeanParseUtil.toUserIdBean( alr.request() );

				if( bean.hasError() ) {
					bean.throwException();
				} else {
					setUserId( bean.getUserId() );
					storeHashedPassword();
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

		if( NullSafe.isNullOrEmpty( token ) || tokenIsStale() ) {
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

	private static void setApiKey( String key ) {
		if( NullSafe.isNullOrEmpty( key ) ) {
			_prefs.remove( KEY_API_KEY );
		} else {
			_prefs.put( KEY_API_KEY, key );
		}
		save();
	}

	public static String getApiKey() {
		getToken();
		String apiKey = _prefs.get( KEY_API_KEY, null );

		if( NullSafe.isNullOrEmpty( apiKey ) ) {
			try {
				apiKey = WebRequestUtils.md5Hash( new StringBuilder()
					.append( getHashedPassword() )
					.append( WebRequestConstants.APP_TOKEN )
					.append( getToken() )
					.toString() );
				setApiKey( apiKey );
			} catch( NoSuchAlgorithmException ex ) {
				Exceptions.printStackTrace( ex );
			}
		}

		return( apiKey );
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
