/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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

	private static final File PROPERTIES_FILE = new File( new StringBuilder()
		.append( System.getProperty( "user.home" ) )
		.append( System.getProperty( "file.separator" ) )
		.append( "." )
		.append( AuthCache.class.getName() )
		.append( ".properties" )
		.toString()
	);

	private static final long MAX_TOKEN_AGE =
		4 // hours
		* 60 // minutes/hour
		* 60 // seconds/minute
		* 1000 // millis/second
		;

	private static final String KEY_EMAIL = "auth.email";
	//private static final String KEY_PASSWORD = "auth.password";
	private static final String KEY_USER_ID = "auth.userId";
	private static final String KEY_TOKEN = "auth.token";
	private static final String KEY_TOKEN_TIMESTAMP_MILLIS = "auth.tokenTimestampMillis";
	private static final String KEY_TOKEN_TIMESTAMP_LONG = "info.tokenTimestampLong";

	private static final Properties _cache = new Properties();

	private static void save() {
		logger.entering( AuthCache.class.getName(), "save()" );

		try {
			_cache.store( new BufferedWriter( new FileWriter( PROPERTIES_FILE ) ), null );
		} catch( IOException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}

		logger.exiting( AuthCache.class.getName(), "save()" );
	}

	private static void load() {
		logger.entering( AuthCache.class.getName(), "load()" );

		if( _cache.isEmpty() ) {
			if( !PROPERTIES_FILE.exists() ) {
				save();
			}

			try {
				_cache.load( new BufferedReader( new FileReader( PROPERTIES_FILE ) ) );
			} catch( IOException ex ) {
				logger.log( Level.SEVERE, null, ex );
			}
		}

		logger.exiting( AuthCache.class.getName(), "load()" );
	}

	public static void setEmail( String email ) {
		if( ! NullSafe.equals(  getEmail(), email ) ) {
			_cache.setProperty( KEY_EMAIL, email );
			setUserId( null );
		}
	}
	public static String getEmail() {
		load();
		return( _cache.getProperty( KEY_EMAIL ) );
	}

	private static String _password = null;

	public static void setPassword( String password ) {
		_password = password;
	}

	private static void setUserId( String userId ) {
		if( NullSafe.isNullOrEmpty( userId ) ) {
			_cache.remove( KEY_USER_ID );
		} else {
			_cache.setProperty( KEY_USER_ID, userId );
		}
		save();
	}
	public static String getUserId() {
		load();
		String userId = _cache.getProperty( KEY_USER_ID );

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
			_cache.remove( KEY_TOKEN );
		} else {
			_cache.setProperty( KEY_TOKEN, token );
		}

		markTokenTimestampMillis();
		save();
	}
	public static String getToken() {
		load();
		String token = _cache.getProperty( KEY_TOKEN );

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
		_cache.setProperty( KEY_TOKEN_TIMESTAMP_MILLIS, "" + ts );
		_cache.setProperty( KEY_TOKEN_TIMESTAMP_LONG, new Date ( ts ).toString() );
	}
	private static long getTokenTimestampMillis() {
		load();
		return( Long.parseLong( _cache.getProperty( KEY_TOKEN_TIMESTAMP_MILLIS ) ) );
	}

	private static boolean tokenIsStale() {
		long tokenAge = System.currentTimeMillis() - getTokenTimestampMillis();
		return( tokenAge >= MAX_TOKEN_AGE );
	}
}
