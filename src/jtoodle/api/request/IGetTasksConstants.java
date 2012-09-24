/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

/**
 *
 * @author justo
 */
public interface IGetTasksConstants {

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

}
