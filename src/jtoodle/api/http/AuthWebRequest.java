/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.http;

import jtoodle.api.intf.AuthenticationConstants;

/**
 *
 * @author justo
 */
public class AuthWebRequest extends AbstractWebRequest
implements AuthenticationConstants {

	public AuthWebRequest( String uri ) {
		super( uri );
		setParameter( AuthenticationConstants.PARAM_NAME_APP_ID,
					  AuthenticationConstants.APP_ID );
	}

}
