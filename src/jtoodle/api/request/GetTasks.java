/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import java.io.IOException;
import java.util.List;
import jtoodle.api.beans.AbstractJToodleBean;
import jtoodle.api.beans.BeanParser;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.beans.Task;
import jtoodle.api.request.GetTasks.TaskResponseWrapper;

/**
 *
 * @author justo
 */
public class GetTasks extends AbstractAPIWebRequest<Task> {

	public GetTasks() {
		super( URI_GET_TASKS, Task.class );
	}

	@Override
	public List<Task> requestBeanList() throws IOException, JToodleException {
		List<Task> beanList = BeanParser.parseTaskList( requestStringResponse() );

		return ( beanList );
	}

	class TaskResponseHeader extends AbstractJToodleBean {
		private Integer num = null;
		private Integer total = null;

		public TaskResponseHeader() {}

		public Integer getNum() {
			return num;
		}

		public void setNum( Integer num ) {
			this.num = num;
		}

		public Integer getTotal() {
			return total;
		}

		public void setTotal( Integer total ) {
			this.total = total;
		}
	}

	class TaskResponseWrapper extends AbstractJToodleBean {
		public TaskResponseHeader header = null;
		public Task task = null;

		public TaskResponseWrapper() {}

		public TaskResponseHeader getHeader() {
			return header;
		}

		public void setHeader( TaskResponseHeader header ) {
			this.header = header;
		}

		public Task getTask() {
			return task;
		}

		public void setTask( Task task ) {
			this.task = task;
		}
	}
}
