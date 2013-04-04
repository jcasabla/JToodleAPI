/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.http.WebRequestFactory;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jtoodle.api.bean.util.AbstractJToodleBean;
import jtoodle.api.json.bean.BeanParser;
import jtoodle.api.bean.core.DeletionResult;
import jtoodle.api.bean.util.JToodleException;
import static jtoodle.api.request.web.WebOperations.BASE_URI;
import jtoodle.api.http.AbstractWebRequest;
import jtoodle.api.util.NullSafe;

/**
 *
 * @author Justo_Casablanca
 */
public abstract class WebBeanOperations <T extends AbstractJToodleBean> {
//implements WebOperations<T> {

	private final String[] URIs = new String[OperationType.values().length];

	protected String getURI( OperationType op ) {
		return ( URIs[op.ordinal()] );
	}

	protected void registerURI( OperationType op, String uri ) {
		URIs[op.ordinal()] = NullSafe.isNullOrEmpty( uri ) ?
			null : new StringBuilder().append( BASE_URI ).append( uri ).toString();
	}

	private final OperationCriteria[] CRITERIA = new OperationCriteria[OperationType.values().length];

	protected OperationCriteria getOperationCriteria( OperationType op ) {
		return( CRITERIA[op.ordinal()] );
	}

	public void setOperationCriteria( OperationCriteria criteria ) {
		CRITERIA[criteria.getOperationType().ordinal()] = criteria;
	}

	protected abstract Class<T> getBeanClass();

	protected void setRequestParameters( OperationType op, AbstractWebRequest wr ) {
		OperationCriteria criteria = getOperationCriteria( op );

		if( criteria != null ) {
			Map<String,String> options = criteria.getOptions();
			Set<String> keySet = options.keySet();

			for( String key : keySet ) {
				String value = options.get( key );

				if( !NullSafe.isNullOrEmpty( value ) ) {
					wr.setParameter( key, value );
				}
			}
		}
	}

	public T searchSingle() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( getURI( OperationType.RETRIEVE ) );
		setRequestParameters( OperationType.RETRIEVE, wr );

		String json = wr.doRequestResponse();
		T singleBean = BeanParser.parseBean( json, getBeanClass() );

		return( singleBean );
	}

	//@Override
	public List<T> search() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( getURI( OperationType.RETRIEVE ) );
		setRequestParameters( OperationType.RETRIEVE, wr );

		String json = wr.doRequestResponse();
		List<T> beans = BeanParser.parseBeanList( json, getBeanClass() );

		return( beans );
	}

	/*@Override
	public List<DeleteableJToodleBean> delete() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( URIs[CRUD.Delete.ordinal()] );
		setRequestParameters( CRUD.Delete, wr );

		String json = wr.doRequestResponse();
		List<DeleteableJToodleBean> beansOut = BeanParser.parseBeanList( json, DeleteableJToodleBean.class );

		return( beansOut );
	}*/

	//@Override
	public DeletionResult deleteSingle() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( URIs[OperationType.DELETE.ordinal()] );
		setRequestParameters( OperationType.DELETE, wr );

		String json = wr.doRequestResponse();
		DeletionResult beanOut = BeanParser.parseBean( json, DeletionResult.class );

		return( beanOut );
	}

	public List<DeletionResult> delete() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( URIs[OperationType.DELETE.ordinal()] );
		setRequestParameters( OperationType.DELETE, wr );

		String json = wr.doRequestResponse();
		List<DeletionResult> beanOut = BeanParser.parseBeanList( json, DeletionResult.class );

		return( beanOut );
	}

	//@Override
	public List<T> create() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( URIs[OperationType.ADD.ordinal()] );
		setRequestParameters( OperationType.ADD, wr );

		String json = wr.doRequestResponse();
		List<T> beanOut = BeanParser.parseBeanList( json, getBeanClass() );

		return( beanOut );
	}

	//@Override
	public List<T> update() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( URIs[OperationType.EDIT.ordinal()] );
		setRequestParameters( OperationType.EDIT, wr );

		String json = wr.doRequestResponse();
		List<T> beanOut = BeanParser.parseBeanList( json, getBeanClass() );

		return( beanOut );
	}

	public static enum OperationType {
		ADD,
		RETRIEVE,
		EDIT,
		DELETE
	}

	public static class OperationCriteria<T> {

		public OperationCriteria( Class<T> clazz, OperationType operationType ) {
			this.operationForType = clazz;
			this.operationType = operationType;
		}

		private Class<T> operationForType = null;

		private OperationType operationType = null;

		// note: HashMap allows Java null as keys and values
		private HashMap<String, String> paramValues = new HashMap<>();

		public Map<String, String> getOptions() {
			return ( paramValues );
		}

		public void setOption( String optionName, String optionValue ) {
			paramValues.put( optionName, optionValue );
		}

		public void setOption( String optionName, Date optionValue ) {
			if( optionValue != null ) {
				paramValues.put( optionName, ""+optionValue.getTime() );
			}
		}

		public Class<T> getOperationForType() {
			return operationForType;
		}

		public OperationType getOperationType() {
			return operationType;
		}

	}
}
