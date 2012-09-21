/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import java.io.IOException;
import java.util.List;
import jtoodle.api.beans.BeanParser;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.beans.TaskQueryResult;

/**
 *
 * @author justo
 */
public class GetTasks extends AbstractAPIWebRequest<TaskQueryResult> {

	public GetTasks() {
		super( URI_GET_TASKS, TaskQueryResult.class );
	}

	@Override
	public TaskQueryResult requestBean() throws IOException, JToodleException {
		return( BeanParser.parseTaskQueryResults( requestStringResponse() ) );
	}

	@Override
	public List<TaskQueryResult> requestBeanList() throws IOException, JToodleException {
		throw( new UnsupportedOperationException(
			"This class only supports the public TaskQueryResult requestBean() method"
		));
	}

}
