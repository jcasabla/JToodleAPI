/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.http.WebRequestFactory;
import java.io.IOException;
import java.util.List;
import jtoodle.api.json.deser.BeanParser;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.beans.Task;
import jtoodle.api.beans.TaskQueryResult;
import static jtoodle.api.request.web.WebBeanOperations.OperationType;
import jtoodle.api.http.AbstractWebRequest;

/**
 *
 * @author Justo_Casablanca
 */
public class TaskOperations extends WebBeanOperations<Task> {

	public TaskOperations() {
		super();

		//registerURI( CRUD.Create, null );
		registerURI( OperationType.RETRIEVE, "/tasks/get.php" );
		//registerURI( CRUD.Update, null );
		registerURI( OperationType.DELETE, "/tasks/delete.php" );
	}

	@Override
	protected Class<Task> getBeanClass() {
		return( Task.class );
	}

	@Override
	public List<Task> search() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.createWebRequest( getURI( OperationType.RETRIEVE ) );
		setRequestParameters( OperationType.RETRIEVE, wr );

		String json = wr.doRequestResponse();
		TaskQueryResult result = BeanParser.parseTaskQueryResults( json );

		return( result.getTasks() );
	}

}
