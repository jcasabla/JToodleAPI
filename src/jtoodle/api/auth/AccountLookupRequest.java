/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import java.security.NoSuchAlgorithmException;
import jtoodle.api.beans.UserId;
import jtoodle.api.intf.AuthenticationConstants;
import jtoodle.api.util.WebRequestUtils;

/**
 *
 * @author justo
 */
public class AccountLookupRequest extends AbstractAuthWebRequest<UserId> {

	public AccountLookupRequest() {
		super( AuthenticationConstants.URI_ACCOUNT_LOOKUP, UserId.class );
	}

	public void setEmail( String email ) throws NoSuchAlgorithmException {
		setParameter( AuthenticationConstants.PARAM_NAME_EMAIL, email );
		setParameter( AuthenticationConstants.PARAM_NAME_SIGNATURE,
					  WebRequestUtils.md5Hash(
						email + AuthenticationConstants.APP_TOKEN ) );
	}

	public void setPassword( String password ) {
		setParameter( AuthenticationConstants.PARAM_NAME_PASSWORD, password );
	}

}
