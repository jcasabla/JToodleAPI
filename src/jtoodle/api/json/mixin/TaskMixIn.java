/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import jtoodle.api.json.enums.DueDateModifier;
import jtoodle.api.json.enums.ReminderTime;
import jtoodle.api.json.enums.TaskRepeatsFrom;

/**
 *
 * @author justo
 */
public interface TaskMixIn extends AbstractJToodleBeanMixIn {

	//@JsonProperty( "id" )
	//public Integer getId();
	//public void setId( Integer id );

	//@JsonProperty( "title" )
	//public String getTitle();
	//public void setTitle( String title );

	//@JsonProperty( "tag" )
	//public String getTag();
	//public void setTag( String tag );


	@JsonProperty( "folder" )
	public Integer getFolderId();
	public void setFolderId( Integer folderId );

	@JsonProperty( "context" )
	public Integer getContextId();
	public void setContextId( Integer contextId );

	@JsonProperty( "goal" )
	public Integer getGoalId();
	public void setGoalId( Integer goalId );

	@JsonProperty( "location" )
	public Integer getLocationId();
	public void setLocationId( Integer locationId );

	@JsonProperty( "parent" )
	public Integer getParentTaskId();
	public void setParentTaskId( Integer parentTaskId );

	@JsonProperty( "children" )
	public Integer getChildTaskCount();
	public void setChildTaskCount( Integer childTaskCount );

	@JsonProperty( "order" )
	public Integer getChildTaskOrder();
	public void setChildTaskOrder( Integer childTaskOrder );

	@JsonProperty( "duedate" )
	public Date getDueDate();
	public void setDueDate( Date dueDate );

	@JsonProperty( "duedatemod" )
	public DueDateModifier getDueDateModifier();
	public void setDueDateModifier( DueDateModifier dueDateModifier );

	@JsonProperty( "startdate" )
	public Date getStartDate();
	public void setStartDate( Date startDate );

	@JsonProperty( "duetime" )
	public Date getDueTime();
	public void setDueTime( Date dueTime );

	@JsonProperty( "starttime" )
	public Date getStartTime();
	public void setStartTime( Date startTime );

	@JsonProperty( "remind" )
	public ReminderTime getReminderMinutes();
	public void setReminderMinutes( ReminderTime reminderMinutes );

	@JsonProperty( "repeat" )
	public String getRepeatPattern();
	public void setRepeatPattern( String repeatPattern );

	@JsonProperty( "repeatfrom" )
	public TaskRepeatsFrom getRepeatsFrom();
	public void setRepeatsFrom( TaskRepeatsFrom repeatsFrom );

	//@JsonProperty( "status" )
	//public Integer getStatus();
	//public void setStatus( Integer status );

	@JsonProperty( "length" )
	public Long getMinutesToComplete();
	public void setMinutesToComplete( Long minutesToComplete );

	//@JsonProperty( "priority" )
	//public Integer getPriority();
	//public void setPriority( Integer priority );

	@JsonProperty( "star" )
	public Boolean getStarred();
	public void setStarred( Boolean starred );

	@JsonProperty( "modified" )
	public Date getModifiedOn();
	public void setModifiedOn( Date modifiedOn );

	@JsonProperty( "completed" )
	public Date getCompletedOn();
	public void setCompletedOn( Date completedOn );

	@JsonProperty( "added" )
	public Date getAddedOn();
	public void setAddedOn( Date addedOn );

	@JsonProperty( "timer" )
	public Long getTimerSecondsElapsed();
	public void setTimerSecondsElapsed( Long timerSecondsElapsed );

	@JsonProperty( "timeron" )
	public Date getTimerStartedOn();
	public void setTimerStartedOn( Date timerStartedOn );

	//@JsonProperty( "note" )
	//public String getNote();
	//public void setNote( String note );

	//@JsonProperty( "meta" )
	//public String getMeta();
	//public void setMeta( String meta );

}
