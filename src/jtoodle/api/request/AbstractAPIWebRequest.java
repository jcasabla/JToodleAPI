/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import java.util.logging.Level;
import java.util.logging.Logger;
import jtoodle.api.auth.AuthCache;
import jtoodle.api.beans.AbstractJToodleBean;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.intf.NonAuthConstants;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
abstract class AbstractAPIWebRequest<V extends AbstractJToodleBean>
extends AbstractWebRequest<V>
implements NonAuthConstants {

	public AbstractAPIWebRequest( String uri, Class<V> clazz ) {
		super( uri, clazz );

		try {
			setParameter( NonAuthConstants.PARAM_NAME_KEY, AuthCache.getApiKey() );
		} catch( JToodleException ex ) {
			Logger.getLogger( AbstractAPIWebRequest.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}
}
