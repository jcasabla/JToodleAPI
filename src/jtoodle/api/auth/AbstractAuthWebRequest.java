/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import jtoodle.api.beans.AbstractJToodleBean;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
public class AbstractAuthWebRequest<V extends AbstractJToodleBean> extends AbstractWebRequest<V> {

	public AbstractAuthWebRequest( String uri, Class<V> clazz ) {
		super( uri, clazz );
		setParameter( PARAM_NAME_APP_ID, APP_ID );
	}

}
