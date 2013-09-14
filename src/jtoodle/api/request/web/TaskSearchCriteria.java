/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.util.Date;
import jtoodle.api.bean.core.Task;

/**
 *
 * @author Justo_Casablanca
 */
public class TaskSearchCriteria extends TaskOperations.OperationCriteria<Task> {

	public TaskSearchCriteria() {
		super( Task.class, TaskOperations.OperationType.RETRIEVE );
		setOption( PARAM_GET_TASKS_FIELD_LIST, PARAM_VALUE_ALL_OPTIONAL_FIELDS );
	}

	public void setStartDate( Date startDate ) {
		setOption( PARAM_GET_TASKS_START_DATE, startDate );
	}

	public void setEndDate( Date endDate ) {
		setOption( PARAM_GET_TASKS_END_DATE, endDate );
	}

	public void setCompletionCriteria( CompletionCriteria completionCriteria ) {
		setOption( PARAM_GET_TASKS_COMPLETED,
				   new StringBuilder()
						.append( completionCriteria.toodledoValue() )
						.toString() );
	}

	public void setTaskId( Integer taskId ) {
		setOption( PARAM_GET_TASKS_ID, taskId.toString() );
	}

	public void setPaginationRowStart( Integer rowStart ) {
		setOption( PARAM_GET_TASKS_PAGINATE_ROW_START, rowStart.toString() );
	}

	public void setPaginationNumTasks( Integer numTasks ) {
		setOption( PARAM_GET_TASKS_PAGINATE_NUM_TASKS, numTasks.toString() );
	}

	public enum CompletionCriteria {

		Uncompleted_Tasks_Only,
		Completed_Tasks_Only,
		All_Tasks;

		public int toodledoValue() {
			int val;
			if( this == All_Tasks ) {
				val = PARAM_VALUE_COMPLETED_AND_UNCOMPLETED_TASKS;
			} else {
				val = ordinal();
			}
			return val;
		}

	}

	private static final String PARAM_GET_TASKS_END_DATE = "modbefore";

	private static final String PARAM_GET_TASKS_START_DATE = "modafter";

	private static final String PARAM_GET_TASKS_COMPLETED = "comp";

	private static final String PARAM_GET_TASKS_ID = "id";

	private static final String PARAM_GET_TASKS_PAGINATE_ROW_START = "start";

	private static final String PARAM_GET_TASKS_PAGINATE_NUM_TASKS = "num";

	public static final String PARAM_GET_TASKS_FIELD_LIST = "fields";

	private static final Integer PARAM_VALUE_COMPLETED_AND_UNCOMPLETED_TASKS = -1;
	//private static final Integer PARAM_VALUE_ONLY_UNCOMPLETED_TASKS = 0;
	//private static final Integer PARAM_VALUE_ONLY_COMPLETED_TASKS = 1;

	public static final String PARAM_VALUE_ALL_OPTIONAL_FIELDS =
			new StringBuilder()
			.append( "folder, " )
			.append( "context, " )
			.append( "goal, " )
			.append( "location, " )
			.append( "tag, " )
			.append( "startdate, " )
			.append( "duedate, " )
			.append( "duedatemod, " )
			.append( "starttime, " )
			.append( "duetime, " )
			.append( "remind, " )
			.append( "repeat, " )
			.append( "status, " )
			.append( "note, " )
			.append( "star, " )
			.append( "priority, " )
			.append( "length, " )
			.append( "timer, " )
			.append( "added, " )
			.append( "note, " )
			.append( "parent, " )
			.append( "meta, " )
			.append( "children, " )
			.append( "order, " )
			.append( "meta" )
			.toString()
			.replace( " ", "" );

	//private static final String PARAM_DEL_TASKS_TASK_ID_LIST = "tasks";
}
