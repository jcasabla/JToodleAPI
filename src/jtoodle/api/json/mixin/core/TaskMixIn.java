/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import jtoodle.api.json.enums.DueDateModifier;
import jtoodle.api.json.enums.ReminderTime;
import jtoodle.api.json.enums.TaskRepeatsFrom;

/**
 *
 * @author justo
 */
public abstract class TaskMixIn extends CoreBeanMixIn {

	//@JsonProperty( "id" )
	//public abstract Integer getId();
	//public abstract void setId( Integer id );

	//@JsonProperty( "title" )
	//public abstract String getTitle();
	//public abstract void setTitle( String title );

	//@JsonProperty( "tag" )
	//public abstract String getTag();
	//public abstract void setTag( String tag );

	@JsonProperty( "folder" )
	public abstract Integer getFolderId();
	public abstract void setFolderId( Integer folderId );

	@JsonProperty( "context" )
	public abstract Integer getContextId();
	public abstract void setContextId( Integer contextId );

	@JsonProperty( "goal" )
	public abstract Integer getGoalId();
	public abstract void setGoalId( Integer goalId );

	@JsonProperty( "location" )
	public abstract Integer getLocationId();
	public abstract void setLocationId( Integer locationId );

	@JsonProperty( "parent" )
	public abstract Integer getParentTaskId();
	public abstract void setParentTaskId( Integer parentTaskId );

	@JsonProperty( "children" )
	public abstract Integer getChildTaskCount();
	public abstract void setChildTaskCount( Integer childTaskCount );

	@JsonProperty( "order" )
	public abstract Integer getChildTaskOrder();
	public abstract void setChildTaskOrder( Integer childTaskOrder );

	@JsonProperty( "duedate" )
	public abstract Date getDueDate();
	public abstract void setDueDate( Date dueDate );

	@JsonProperty( "duedatemod" )
	public abstract DueDateModifier getDueDateModifier();
	public abstract void setDueDateModifier( DueDateModifier dueDateModifier );

	@JsonProperty( "startdate" )
	public abstract Date getStartDate();
	public abstract void setStartDate( Date startDate );

	@JsonProperty( "duetime" )
	public abstract Date getDueTime();
	public abstract void setDueTime( Date dueTime );

	@JsonProperty( "starttime" )
	public abstract Date getStartTime();
	public abstract void setStartTime( Date startTime );

	@JsonProperty( "remind" )
	public abstract ReminderTime getReminderMinutes();
	public abstract void setReminderMinutes( ReminderTime reminderMinutes );

	@JsonProperty( "repeat" )
	public abstract String getRepeatPattern();
	public abstract void setRepeatPattern( String repeatPattern );

	@JsonProperty( "repeatfrom" )
	public abstract TaskRepeatsFrom getRepeatsFrom();
	public abstract void setRepeatsFrom( TaskRepeatsFrom repeatsFrom );

	//@JsonProperty( "status" )
	//public abstract Integer getStatus();
	//public abstract void setStatus( Integer status );

	@JsonProperty( "length" )
	public abstract Long getMinutesToComplete();
	public abstract void setMinutesToComplete( Long minutesToComplete );

	//@JsonProperty( "priority" )
	//public abstract Integer getPriority();
	//public abstract void setPriority( Integer priority );

	@JsonProperty( "star" )
	public abstract Boolean getStarred();
	public abstract void setStarred( Boolean starred );

	@JsonProperty( "modified" )
	public abstract Date getModifiedOn();
	public abstract void setModifiedOn( Date modifiedOn );

	@JsonProperty( "completed" )
	public abstract Date getCompletedOn();
	public abstract void setCompletedOn( Date completedOn );

	@JsonProperty( "added" )
	public abstract Date getAddedOn();
	public abstract void setAddedOn( Date addedOn );

	@JsonProperty( "timer" )
	public abstract Long getTimerSecondsElapsed();
	public abstract void setTimerSecondsElapsed( Long timerSecondsElapsed );

	@JsonProperty( "timeron" )
	public abstract Date getTimerStartedOn();
	public abstract void setTimerStartedOn( Date timerStartedOn );

	//@JsonProperty( "note" )
	//public abstract String getNote();
	//public abstract void setNote( String note );

	//@JsonProperty( "meta" )
	//public abstract String getMeta();
	//public abstract void setMeta( String meta );

}
