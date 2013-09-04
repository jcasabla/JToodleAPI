/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.util.ArrayList;
import java.util.List;
import jtoodle.api.bean.core.CoreBean;
import jtoodle.api.bean.core.Task;
import jtoodle.api.json.bean.BeanWriter;

/**
 *
 * @author Justo_Casablanca
 */
public class TaskDeletionCriteria extends TaskOperations.OperationCriteria<Task> {

	public TaskDeletionCriteria() {
		super( Task.class, TaskOperations.OperationType.DELETE );
	}

	public void setTasks( List<Task> tasksToDelete ) {
		List<CoreBean> tmp = new ArrayList<>( tasksToDelete.size() );
		tmp.addAll( tasksToDelete );

		setOption( PARAM_DEL_TASKS_TASK_ID_LIST, BeanWriter.writeIdList( tmp ) );
	}

	private static final String PARAM_DEL_TASKS_TASK_ID_LIST = "tasks";

}
