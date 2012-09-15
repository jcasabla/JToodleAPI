/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import java.util.logging.Level;
import java.util.logging.Logger;
import jtoodle.api.auth.AuthCache;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
abstract class AbstractAPIWebRequest extends AbstractWebRequest {

	public AbstractAPIWebRequest( String uri ) {
		super( uri );

		try {
			setParameter( PARAM_NAME_KEY, AuthCache.getApiKey() );
		} catch( JToodleException ex ) {
			Logger.getLogger( AbstractAPIWebRequest.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}
}
