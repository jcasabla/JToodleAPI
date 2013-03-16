/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean;

import java.util.List;

/**
 *
 * @author justo
 */
public class TaskQueryResult extends AbstractJToodleBean {

	private Integer queryTaskCount = null;
	private Integer totalTaskCount = null;
	private List<Task> tasks = null;

	protected TaskQueryResult( Integer queryTaskCount, Integer totalTaskCount ) {
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

	protected void setQueryTaskCount( Integer queryTaskCount ) {
		this.queryTaskCount = queryTaskCount;
	}

	public Integer getTotalTaskCount() {
		return totalTaskCount;
	}

	protected void setTotalTaskCount( Integer totalTaskCount ) {
		this.totalTaskCount = totalTaskCount;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks( List<Task> tasks ) {
		this.tasks = tasks;
	}

}
