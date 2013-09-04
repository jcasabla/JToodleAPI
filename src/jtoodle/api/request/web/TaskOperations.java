/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.io.IOException;
import java.util.List;
import jtoodle.api.bean.core.Task;
import jtoodle.api.bean.core.TaskQueryResult;
import jtoodle.api.bean.util.JToodleException;
import jtoodle.api.http.AbstractWebRequest;
import jtoodle.api.http.WebRequestFactory;
import jtoodle.api.json.bean.BeanParser;
import jtoodle.api.request.web.WebBeanOperations.OperationType;

/**
 *
 * @author Justo_Casablanca
 */
public class TaskOperations extends WebBeanOperations<Task> {

	public TaskOperations() {
		super();

		registerURI( OperationType.ADD, "/tasks/add.php" );
		registerURI( OperationType.RETRIEVE, "/tasks/get.php" );
		registerURI( OperationType.EDIT, "/tasks/edit.php" );
		registerURI( OperationType.DELETE, "/tasks/delete.php" );
	}

	@Override
	protected Class<Task> getBeanClass() {
		return( Task.class );
	}

	@Override
	public List<Task> search() throws IOException, JToodleException {
		AbstractWebRequest wr = WebRequestFactory.
				createWebRequest( getURI( OperationType.RETRIEVE ) );
		setRequestParameters( OperationType.RETRIEVE, wr );

		String json = wr.doRequestResponse();
		TaskQueryResult result = BeanParser.parseTaskQueryResults( json );

		return( result.getTasks() );
	}

}
