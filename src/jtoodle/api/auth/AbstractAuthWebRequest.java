/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import jtoodle.api.beans.AbstractJToodleBean;
import jtoodle.api.intf.AuthenticationConstants;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
public class AbstractAuthWebRequest<V extends AbstractJToodleBean>
extends AbstractWebRequest<V>
implements AuthenticationConstants {

	public AbstractAuthWebRequest( String uri, Class<V> clazz ) {
		super( uri, clazz );
		setParameter( AuthenticationConstants.PARAM_NAME_APP_ID,
					  AuthenticationConstants.APP_ID );
	}

}
