/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import jtoodle.api.bean.core.Task;
import jtoodle.api.json.bean.BeanWriter;

/**
 *
 * @author Justo_Casablanca
 */
public class TaskUpdateCriteria extends TaskOperations.OperationCriteria<Task> {

	public TaskUpdateCriteria() {
		super( Task.class, TaskOperations.OperationType.EDIT );
		setOption( PARAM_EDIT_RESCHEDULE, "1" );
		setOption( TaskSearchCriteria.PARAM_GET_TASKS_FIELD_LIST,
				   TaskSearchCriteria.PARAM_VALUE_ALL_OPTIONAL_FIELDS );
	}

	public void setTasks( List<Task> tasksToEdit ) throws JsonProcessingException {
		setOption( PARAM_EDIT_TASKS_TASK_LIST,
				   BeanWriter.jsonString( tasksToEdit ) );
	}

	private static final String PARAM_EDIT_TASKS_TASK_LIST = "tasks";
	private static final String PARAM_EDIT_RESCHEDULE = "reschedule";

}
