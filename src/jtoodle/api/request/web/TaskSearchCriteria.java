/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.util.Date;
import jtoodle.api.beans.Task;

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
		setOption( PARAM_GET_TASKS_COMPLETED, ""+completionCriteria.toodledoValue() );
	}

	public void setTaskId( Integer taskId ) {
		setOption( PARAM_GET_TASKS_ID, ""+taskId );
	}

	public void setPaginationRowStart( Integer rowStart ) {
		setOption( PARAM_GET_TASKS_PAGINATE_ROW_START, ""+rowStart );
	}

	public void setPaginationNumTasks( Integer numTasks ) {
		setOption( PARAM_GET_TASKS_PAGINATE_NUM_TASKS, ""+numTasks );
	}

	public enum CompletionCriteria {
		  Uncompleted_Tasks_Only
		, Completed_Tasks_Only
		, All_Tasks;

		public int toodledoValue() {
			int val;
			switch( this ) {
				case All_Tasks : {
					val = PARAM_VALUE_COMPLETED_AND_UNCOMPLETED_TASKS;
					break;
				}
				default : {
					val = ordinal();
				}
			}
			return( val );
		}
	}

	private static final String PARAM_GET_TASKS_END_DATE = "modbefore";
	private static final String PARAM_GET_TASKS_START_DATE = "modafter";
	private static final String PARAM_GET_TASKS_COMPLETED = "comp";
	private static final String PARAM_GET_TASKS_ID = "id";
	private static final String PARAM_GET_TASKS_PAGINATE_ROW_START = "start";
	private static final String PARAM_GET_TASKS_PAGINATE_NUM_TASKS = "num";
	private static final String PARAM_GET_TASKS_FIELD_LIST = "fields";

	private static final Integer PARAM_VALUE_COMPLETED_AND_UNCOMPLETED_TASKS = -1;
	//private static final Integer PARAM_VALUE_ONLY_UNCOMPLETED_TASKS = 0;
	//private static final Integer PARAM_VALUE_ONLY_COMPLETED_TASKS = 1;

	private static final String PARAM_VALUE_ALL_OPTIONAL_FIELDS =
		new StringBuilder()
		.append( "folder, context, goal, location, tag, startdate, duedate, " )
		.append( "duedatemod, starttime, duetime, remind, repeat, status, " )
		.append( "note, star, priority, length, timer, added, note, parent, " )
		.append( "meta, children, order, meta" )
		.toString()
		.replace( " " , "" );

	//private static final String PARAM_DEL_TASKS_TASK_ID_LIST = "tasks";

}
