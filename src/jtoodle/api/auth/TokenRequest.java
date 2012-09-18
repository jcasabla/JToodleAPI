/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import java.security.NoSuchAlgorithmException;
import jtoodle.api.beans.Token;
import jtoodle.api.util.WebRequestUtils;

/**
 *
 * @author justo
 */
public class TokenRequest extends AbstractAuthWebRequest<Token> {

	public TokenRequest() {
		super( URI_GET_TOKEN, Token.class );

		setParameter( PARAM_NAME_VERSION, "1" );
		setParameter( PARAM_NAME_DEVICE, "laptop" );
		setParameter( PARAM_NAME_OS, System.getProperty( "os.name" ) );
	}

	public void setUserId( String userId ) throws NoSuchAlgorithmException {
		setParameter( PARAM_NAME_USER_ID, userId );
		setParameter( PARAM_NAME_SIGNATURE,
					  WebRequestUtils.md5Hash( userId + APP_TOKEN ) );
	}

}
