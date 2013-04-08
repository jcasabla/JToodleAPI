/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.http;

import java.util.logging.Level;
import java.util.logging.Logger;
import jtoodle.api.auth.AuthCache;
import jtoodle.api.bean.util.JToodleException;

/**
 *
 * @author justo
 */
public class APIWebRequest extends AbstractWebRequest {

	public APIWebRequest( String uri ) {
		super( uri );

		try {
			setParameter( PARAM_NAME_KEY, AuthCache.getApiKey() );
		} catch( JToodleException ex ) {
			Logger.getLogger( APIWebRequest.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}

	private static final String PARAM_NAME_KEY = "key";
}
