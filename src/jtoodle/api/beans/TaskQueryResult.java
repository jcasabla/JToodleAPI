/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author justo
 */
public class TaskQueryResult extends AbstractJToodleBean {

	private Integer queryTaskCount = null;
	private Integer totalTaskCount = null;
	private List<Task> tasks = null;

	private TaskQueryResult( Integer queryTaskCount, Integer totalTaskCount ) {
		this.queryTaskCount = queryTaskCount;
		this.totalTaskCount = totalTaskCount;
	}

	public static TaskQueryResult createTaskQueryResult(
		  Integer queryTaskCount
		, Integer totalTaskCount
	)
	{
		return( new TaskQueryResult( queryTaskCount, totalTaskCount ) );
	}

	public Integer getQueryTaskCount() {
		return queryTaskCount;
	}

	//public void setQueryTaskCount( Integer queryTaskCount ) {
	//	this.queryTaskCount = queryTaskCount;
	//}

	public Integer getTotalTaskCount() {
		return totalTaskCount;
	}

	//public void setTotalTaskCount( Integer totalTaskCount ) {
	//	this.totalTaskCount = totalTaskCount;
	//}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks( List<Task> tasks ) {
		this.tasks = tasks;
	}

}
