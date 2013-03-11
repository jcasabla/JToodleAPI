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
import jtoodle.api.beans.AbstractJToodleBean;
import jtoodle.api.beans.BeanParser;
import jtoodle.api.beans.JToodleException;
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
public abstract class AbstractWebRequest<T extends AbstractJToodleBean> {

	@SuppressWarnings( "NonConstantLogger" )
	private final Logger logger = Logger.getLogger( getClass().getName() );

	private String uri = null;

	private Class<T> clazz = null;

	private List<NameValuePair> formparams = null;

	public AbstractWebRequest( String uri, Class<T> clazz ) {
		this.uri = uri;
		this.clazz = clazz;
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

	protected final String doRequestResponse() throws IOException, JToodleException {
		logger.entering( getClass().getName(), "requestStringResponse()" );

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

		byte[] byteResponse = client.execute( request, handler );
		String stringResponse = new String( byteResponse );

		logger.exiting( getClass().getName(), "requestStringResponse()", stringResponse );

		return ( stringResponse );
	}

	public T singleRequestResponse() throws IOException, JToodleException {
		logger.entering( getClass().getName(), "requestBean()" );
		T bean = BeanParser.parseBean( doRequestResponse(), clazz );

		logger.exiting( getClass().getName(), "requestBean()", bean );
		return ( bean );
	}

	public List<T> multiRequestResponse() throws IOException, JToodleException {
		logger.entering( getClass().getName(), "requestBeanList()" );
		List<T> beanList = BeanParser.parseBeanList( doRequestResponse(), clazz );

		logger.exiting( getClass().getName(), "requestBeanList()", beanList );
		return ( beanList );
	}

}
