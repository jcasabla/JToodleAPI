/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.http;

import jtoodle.api.auth.AuthCache;

/**
 *
 * @author Justo_Casablanca
 */
public final class WebRequestFactory {

	private WebRequestFactory() {
	}

	public static AbstractWebRequest createWebRequest( String uri ) {
		return AuthCache.isAuthenticated()
				? new APIWebRequest( uri )
				: new AuthWebRequest( uri );
	}

}
