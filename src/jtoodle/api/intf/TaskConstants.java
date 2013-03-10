/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.intf;

/**
 *
 * @author justo
 */
public interface TaskConstants extends NonAuthConstants {

	public static final String URI_GET_TASKS = new StringBuilder()
			.append( BASE_URI )
			.append( "/tasks/get.php" )
			.toString();

	public static final String URI_DELETE_TASKS = new StringBuilder()
			.append( BASE_URI )
			.append( "/tasks/delete.php" )
			.toString();

	/*
	 * These search parameters are described at: http://api.toodledo.com/2/tasks/index.php
	 */

	public static final String PARAM_GET_TASKS_END_DATE = "modbefore";
	public static final String PARAM_GET_TASKS_START_DATE = "modafter";
	public static final String PARAM_GET_TASKS_COMPLETED = "comp";
	public static final String PARAM_GET_TASKS_ID = "id";
	public static final String PARAM_GET_TASKS_PAGINATE_ROW_START = "start";
	public static final String PARAM_GET_TASKS_PAGINATE_NUM_TASKS = "num";
	public static final String PARAM_GET_TASKS_FIELD_LIST = "fields";

	public static final Integer PARAM_VALUE_COMPLETED_AND_UNCOMPLETED_TASKS = -1;
	public static final Integer PARAM_VALUE_ONLY_UNCOMPLETED_TASKS = 0;
	public static final Integer PARAM_VALUE_ONLY_COMPLETED_TASKS = 1;

	public static final String PARAM_VALUE_ALL_OPTIONAL_FIELDS =
		new StringBuilder()
		.append( "folder, context, goal, location, tag, startdate, duedate, " )
		.append( "duedatemod, starttime, duetime, remind, repeat, status, " )
		.append( "note, star, priority, length, timer, added, note, parent, " )
		.append( "meta, children, order, meta" )
		.toString()
		.replace( " " , "" );

	public static final String PARAM_DEL_TASKS_TASK_ID_LIST = "tasks";
}
