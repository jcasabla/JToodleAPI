/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import jtoodle.api.auth.AuthCache;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author justo
 */
abstract class AbstractAPIWebRequest extends AbstractWebRequest {

	public AbstractAPIWebRequest( String uri ) {
		super( uri );
		setParameter( PARAM_NAME_KEY, AuthCache.getApiKey() );
	}
}
