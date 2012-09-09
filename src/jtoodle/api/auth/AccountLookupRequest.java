/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import java.security.NoSuchAlgorithmException;
import jtoodle.api.util.WebRequestUtils;

/**
 *
 * @author justo
 */
public class AccountLookupRequest extends AbstractAuthWebRequest {

	public AccountLookupRequest() {
		super( URI_ACCOUNT_LOOKUP );
	}

	public void setEmail( String email ) throws NoSuchAlgorithmException {
		setParameter( PARAM_NAME_EMAIL, email );
		setParameter( PARAM_NAME_SIGNATURE,
					  WebRequestUtils.md5Hash( email + APP_TOKEN ) );
	}

	public void setPassword( String password ) {
		setParameter( PARAM_NAME_PASSWORD, password );
	}

}
