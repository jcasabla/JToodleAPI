/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author justo
 */
public final class WebRequestUtils {

	private WebRequestUtils() {}

	public static String md5Hash( String in ) throws NoSuchAlgorithmException {
		return( md5Hash( in, 32 ) );
	}

	private static String md5Hash( String in, int padToLen ) throws NoSuchAlgorithmException {
		// create the MD5 digest and feed it in the input string
		MessageDigest md = MessageDigest.getInstance( "MD5" );
		md.reset();
		md.update( in.getBytes() );

		// get the results of the digest and convert it to a hex string
		byte[] digest = md.digest();
		BigInteger bigInt = new BigInteger( 1, digest );
		String hashText = bigInt.toString( 16 );

		// zero-pad it up to the desired length
		if( hashText.length() < padToLen ) {
			StringBuilder padding = new StringBuilder();
			padding.append( hashText );

			while( padding.length() < padToLen ) {
				padding.insert( 0, "0" );
			}

			hashText = padding.toString();
		}

		return ( hashText );
	}
}
