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
public class TaskAddCriteria extends TaskOperations.OperationCriteria<Task> {

	public TaskAddCriteria() {
		super( Task.class, TaskOperations.OperationType.ADD );
	}

	public void setTasks( List<Task> tasksToAdd ) throws JsonProcessingException {
		setOption( PARAM_ADD_TASKS_TASK_LIST, BeanWriter.jsonString( tasksToAdd ) );
	}

	private static final String PARAM_ADD_TASKS_TASK_LIST = "tasks";
}
