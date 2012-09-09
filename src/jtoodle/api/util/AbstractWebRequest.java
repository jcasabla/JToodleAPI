/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author justo
 */
public abstract class AbstractWebRequest implements WebRequestConstants {

	@SuppressWarnings( "NonConstantLogger" )
	private final Logger logger = Logger.getLogger( getClass().getName() );

	private String uri = null;

	private List<NameValuePair> formparams = null;

	public AbstractWebRequest( String uri ) {
		this.uri = uri;
		//setParameter( PARAM_NAME_FORMAT, "xml" );
	}

	public final void setParameter( String parameterName, String parameterValue ) {
		if( formparams == null ) {
			formparams = new ArrayList<>();
		}

		logger.log( Level.FINE,
					"setParameter(parameterName={0},parameterValue={1}",
					new String[] { parameterName, parameterValue } );

		formparams.add( new BasicNameValuePair( parameterName, parameterValue ) );
	}

	public String request() {
		logger.entering( getClass().getName(), "request()" );

		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost( uri );

		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity( formparams, "UTF-8" );
			request.setEntity( entity );
		} catch( UnsupportedEncodingException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}

		ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
			@Override
			public byte[] handleResponse( HttpResponse response ) throws ClientProtocolException, IOException {
				byte[] retVal = null;
				HttpEntity entity = response.getEntity();

				if( entity != null ) {
					retVal = EntityUtils.toByteArray( entity );
				}

				return( retVal );
			}
		};

		String stringResponse = null;

		try {
			byte[] byteResponse = client.execute( request, handler );
			stringResponse = new String( byteResponse );
		} catch( IOException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}

		logger.exiting( getClass().getName(), "request()", stringResponse );

		return ( stringResponse );
	}
}
