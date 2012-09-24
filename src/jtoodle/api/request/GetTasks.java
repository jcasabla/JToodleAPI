/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import jtoodle.api.beans.BeanParser;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.beans.TaskQueryResult;

/**
 *
 * @author justo
 */
public class GetTasks extends AbstractAPIWebRequest<TaskQueryResult>
implements IGetTasksConstants {

	public GetTasks() {
		super( URI_GET_TASKS, TaskQueryResult.class );
		setParameter( IGetTasksConstants.PARAM_GET_TASKS_FIELD_LIST,
					  IGetTasksConstants.PARAM_VALUE_ALL_OPTIONAL_FIELDS );
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

	/*
	 * http://api.toodledo.com/2/tasks/index.php
	 *
	 * Retrieving Tasks
	 *
	 * The "tasks/get.php" API call will return a list of the tasks that match
	 * your search parameters. You can access this via GET or POST. The following
	 * search parameters may be used to limit the returned tasks. To make sync go
	 * as efficiently as possible you should request the minimum amount of data
	 * that you need. Usually, this means keeping track of the "lastedit_task"
	 * field from the account/get.php API call and using this in combination with
	 * the "modafter" field in this call to request only those tasks that have
	 * changed since your last synctaskQueryResult1.
	 *
	 * modbefore : A GMT unix timestamp. Used to find tasks with a modified date and time before this date and time.
	 * modafter : A GMT unix timestamp. Used to find tasks with a modified date and time after this date and time.
	 * comp : Boolean (0 or 1). Set to 0 to find only uncompleted tasks. Set to 1 to find only completed tasks. Omit variable, or set to -1 to retrieve both completed and uncompleted tasks.
	 * id : The id number of the task that you want to fetch. This is useful if you already know the id number and only need to fetch the one task.
	 * start : The number of records that you want to skip before printing results. Use this in combination with "num" if you want to paginate your results. The default value is 0.
	 * num : The number of records to go through until output is stopped. Use this in combination with "start" if you want to paginate your results. The default value is 1000.
	 * fields : A comma separated list of optional fields that you want returned. For efficiency, you should omit fields that you don't use. This will make downloading, parsing and syncing go much faster.
	 *
	 * Always returned (do not list in the fields paramater or you will get an error):
	 * id, title, modified, completed
	 *
	 * Optional:
	 * folder, context, goal, location, tag, startdate, duedate, duedatemod, starttime, duetime, remind, repeat, status, star, priority, length, timer, added, note, parent, children, order, meta
	 */

	public void setStartDate( Date startDate ) {
		if( startDate != null ) {
			setParameter( IGetTasksConstants.PARAM_GET_TASKS_START_DATE,
						  ""+startDate.getTime() );
		}
	}

	public void setEndDate( Date endDate ) {
		if( endDate != null ) {
			setParameter( IGetTasksConstants.PARAM_GET_TASKS_END_DATE,
						  ""+endDate.getTime() );
		}
	}

	public void setCompletionCriteria( CompletionCriteria completionCriteria ) {
		setParameter( IGetTasksConstants.PARAM_GET_TASKS_COMPLETED,
					  ""+completionCriteria.toodledoValue() );
	}

	public void setTaskId( Integer taskId ) {
		setParameter( IGetTasksConstants.PARAM_GET_TASKS_ID, ""+taskId );
	}

	public void setPaginationRowStart( Integer rowStart ) {
		setParameter( IGetTasksConstants.PARAM_GET_TASKS_PAGINATE_ROW_START,
					  ""+rowStart );
	}

	public void setPaginationNumTasks( Integer numTasks ) {
		setParameter( IGetTasksConstants.PARAM_GET_TASKS_PAGINATE_NUM_TASKS,
					  ""+numTasks );
	}

	public enum CompletionCriteria {
		  Uncompleted_Tasks_Only
		, Completed_Tasks_Only
		, All_Tasks;

		public int toodledoValue() {
			int val;
			switch( this ) {
				case All_Tasks : {
					val = IGetTasksConstants.PARAM_VALUE_COMPLETED_AND_UNCOMPLETED_TASKS;
					break;
				}
				default : {
					val = ordinal();
				}
			}
			return( val );
		}
	};
}
