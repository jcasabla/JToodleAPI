/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import jtoodle.api.intf.AuthenticationConstants;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
public class AbstractAuthWebRequest extends AbstractWebRequest
implements AuthenticationConstants {

	public AbstractAuthWebRequest( String uri ) {
		super( uri );
		setParameter( AuthenticationConstants.PARAM_NAME_APP_ID,
					  AuthenticationConstants.APP_ID );
	}

}
