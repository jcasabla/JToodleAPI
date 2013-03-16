/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.auth.AbstractAuthWebRequest;
import jtoodle.api.auth.AuthCache;
import jtoodle.api.request.AbstractAPIWebRequest;
import jtoodle.api.util.AbstractWebRequest;

/**
 *
 * @author Justo_Casablanca
 */
public class WebRequestFactory {

	public static AbstractWebRequest createWebRequest( String uri ) {
		return(
			AuthCache.isAuthenticated() ?
				new AbstractAPIWebRequest( uri ) :
				new AbstractAuthWebRequest( uri )
		);
	}
}
