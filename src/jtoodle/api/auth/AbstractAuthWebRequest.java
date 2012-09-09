/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
public class AbstractAuthWebRequest extends AbstractWebRequest {

	public AbstractAuthWebRequest( String uri ) {
		super( uri );
		setParameter( PARAM_NAME_APP_ID, APP_ID );
	}

}
