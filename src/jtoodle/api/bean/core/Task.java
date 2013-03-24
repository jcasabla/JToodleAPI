/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.core;

import java.util.Date;
import jtoodle.api.json.enums.DueDateModifier;
import jtoodle.api.json.enums.Priority;
import jtoodle.api.json.enums.ReminderTime;
import jtoodle.api.json.enums.Status;
import jtoodle.api.json.enums.TaskRepeatsFrom;

/**
 *
 * @author justo
 */
public class Task extends AbstractCoreBean {
/*
 * Task Datatypes (http://api.toodledo.com/2/tasks/index.php)
 *
 * There are a number of fields that can be set or retrieved when working with tasks. Here is a description of these fields.
 *
 * id : The server id number for this task. It is guaranteed to be unique per account, but two different accounts may have two different tasks with the same id number.
 * title : A string for the name of the task. Up to 255 characters. When setting, please encode the & character as %26 and the ; character as %3B.
 * tag : A comma separated string listing the tags assigned to this task. Up to 64 characters. When setting, please encode the & character as %26 and the ; character as %3B.
 * folder : The id number of the folder. Omit this field or set it to 0 to leave the task unassigned to a folder.
 * context : The id number of the context. Omit this field or set it to 0 to leave the task unassigned to a context.
 * goal : The id number of the goal. Omit this field or set it to 0 to leave the task unassigned to a goal.
 * location : The id number of the location. Omit this field or set it to 0 to leave the task unassigned to a location.
 * parent : This is used on Pro accounts that have access to subtasks. To create a subtask, set this to the id number of the parent task. The default is 0, which creates a normal task.
 * children : This is used on Pro accounts that have access to subtasks. This will indicate the number of child tasks that this task has. This will be 0 for subtasks or for regular tasks without subtasks.
 * order : This is used on Pro accounts that have access to subtasks. This is an integer that indicates the manual order of subtasks within the parent task. Currently this is read-only.
 * duedate : A GMT unix timestamp for when the task is due. The time component of this timestamp doesn't matter. When fetching from the server, it will always be noon.
 * duedatemod : An integer representing the due date modifier.
 *		0 = Due By
 *		1 = Due On (=)
 *		2 = Due After (>)
 *		3 = Optionally (?)
 * startdate : A GMT unix timestamp for when the task starts. The time component of this timestamp will always be noon.
 * duetime : A GMT unix timestamp for when the task is due. If the task does not have a time set, then this will be 0. If the task has a duetime without a duedate set, then the date component of this timestamp will be Jan 1, 1970. Times are stored as floating times. In other words, 10am is always 10am, regardless of your timezone. You can convert this timestamp to a GMT string and display the time component without worrying about timezones.
 * starttime : A GMT unix timestamp for when the task starts. If the task does not have a time set, then this will be 0. If the task has a starttime without a startdate set, then the date component of this timestamp will be Jan 1, 1970. Times are stored as floating times. In other words, 10am is always 10am, regardless of your timezone. You can convert this timestamp to a GMT string and display the time component without worrying about timezones.
 * remind : An integer that represents the number of minutes prior to the duedate/time that a reminder will be sent. Set it to 0 for no reminder. Values will be constrained to this list of valid numbers (0, 1, 15, 30, 45, 60, 90, 120, 180, 240, 1440, 2880, 4320, 5760, 7200, 8640, 10080, 20160, 43200). Additionally, if the user does not have a Pro account, the only valid numbers are 0,60. If you submit an invalid number, it will be rounded up or down to a valid non zero value.
 * repeat : A string indicating how the task repeats. For example: "Every 1 Week" or "On the 2nd Friday". Please read our repeat format faq for details about valid values. When a task is rescheduled, it is moved forward to the new date. For record keeping purposes, a completed copy of this task will be added to the user's list. It will have a new ID number and will be already completed. To unset this value, set it to an empty string.
 * repeatfrom : Indicates how tasks repeat. It will be 0 to repeat from the due-date or 1 to repeat from the completion date.
 * status : An integer that represents the status of the task.
 *		0 = None
 *		1 = Next Action
 *		2 = Active
 *		3 = Planning
 *		4 = Delegated
 *		5 = Waiting
 *		6 = Hold
 *		7 = Postponed
 *		8 = Someday
 *		9 = Canceled
 *		10 = Reference
 * length : An integer representing the number of minutes that the task will take to complete.
 * priority : An integer that represents the priority.
 *		-1 = Negative
 *		0 = Low
 *		1 = Medium
 *		2 = High
 *		3 = Top
 * star : A boolean (0 or 1) that indicates if the task has a star or not.
 * modified : A GMT unix timestamp for when the task was last modified.
 * completed : A GMT unix timestamp for when the task was completed. If the task is not completed, the value will be 0. Toodledo does not track the time that a task was completed, so tasks will always appear to be completed at noon.
 * added : A GMT unix timestamp for when the task was added. Toodledo does not track the time that a task was added, so tasks will always appear to be added at noon.
 * timer : The value in the timer field indicates the number of seconds that have elapsed for the timer not including the current session.
 * timeron : If the timer is currently on, this will contain a unix timestamp indicating the last time that the timer was started. Therefore, if the timer is currently on, you will need to calculate the elapsed time when you present it to the user. This calculation is: Total Time=timer+(now-timeron). Where "now" is a unix timestamp for the current time.
 * note : A text string up to 32,000 bytes long. When setting, please encode the & character as %26 and the ; character as %3B.
 * meta : A text string up to 255 bytes long for storing metadata about the task. This is useful for syncing data that cannot otherwise be synced to Toodledo. This data is unique per task ID. This data is private to your App ID. Neither the user, nor other App IDs can see the data that you put in here. Because of an implementation detail, using the meta field introduces extra latency to each API call, so you should only use this field when necessary.
 */

	private String title = null;					// title
	private String tag = null;						// tag
	private Integer folderId = null;				// folder
	private Integer contextId = null;				// context
	private Integer goalId = null;					// goal
	private Integer locationId = null;				// location
	private Integer parentTaskId = null;			// parent
	private Integer childTaskCount = null;			// children
	private Integer childTaskOrder = null;			// order
	private Date dueDate = null;					// duedate
	private DueDateModifier dueDateModifier = null;	// duedatemod
	private Date startDate = null;					// startdate
	private Date dueTime = null;					// duetime
	private Date startTime = null;					// starttime
	private ReminderTime reminderMinutes = null;	// remind
	private String repeatPattern = null;			// repeat
	private TaskRepeatsFrom repeatsFrom = null;		// repeatfrom
	private Status status = null;					// status
	private Long minutesToComplete = null;			// length
	private Priority priority = null;				// priority
	private Boolean starred = null;					// star
	private Date modifiedOn = null;					// modified
	private Date completedOn = null;				// completed
	private Date addedOn = null;					// added
	private Long timerSecondsElapsed = null;		// timer
	private Date timerStartedOn = null;				// timeron
	private String note = null;						// note
	private String meta = null;						// meta

	public String getTitle() {
		return title;
	}

	public void setTitle( String title ) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag( String tag ) {
		this.tag = tag;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId( Integer folderId ) {
		this.folderId = folderId;
	}

	public Integer getContextId() {
		return contextId;
	}

	public void setContextId( Integer contextId ) {
		this.contextId = contextId;
	}

	public Integer getGoalId() {
		return goalId;
	}

	public void setGoalId( Integer goalId ) {
		this.goalId = goalId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId( Integer locationId ) {
		this.locationId = locationId;
	}

	public Integer getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId( Integer parentTaskId ) {
		this.parentTaskId = parentTaskId;
	}

	public Integer getChildTaskCount() {
		return childTaskCount;
	}

	public void setChildTaskCount( Integer childTaskCount ) {
		this.childTaskCount = childTaskCount;
	}

	public Integer getChildTaskOrder() {
		return childTaskOrder;
	}

	public void setChildTaskOrder( Integer childTaskOrder ) {
		this.childTaskOrder = childTaskOrder;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate( Date dueDate ) {
		this.dueDate = dueDate;
	}

	public DueDateModifier getDueDateModifier() {
		return dueDateModifier;
	}

	public void setDueDateModifier( DueDateModifier dueDateModifier ) {
		this.dueDateModifier = dueDateModifier;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate( Date startDate ) {
		this.startDate = startDate;
	}

	public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime( Date dueTime ) {
		this.dueTime = dueTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime( Date startTime ) {
		this.startTime = startTime;
	}

	public ReminderTime getReminderMinutes() {
		return reminderMinutes;
	}

	public void setReminderMinutes( ReminderTime reminderMinutes ) {
		this.reminderMinutes = reminderMinutes;
	}

	public String getRepeatPattern() {
		return repeatPattern;
	}

	public void setRepeatPattern( String repeatPattern ) {
		this.repeatPattern = repeatPattern;
	}

	public TaskRepeatsFrom getRepeatsFrom() {
		return repeatsFrom;
	}

	public void setRepeatsFrom( TaskRepeatsFrom repeatsFrom ) {
		this.repeatsFrom = repeatsFrom;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus( Status status ) {
		this.status = status;
	}

	public Long getMinutesToComplete() {
		return minutesToComplete;
	}

	public void setMinutesToComplete( Long minutesToComplete ) {
		this.minutesToComplete = minutesToComplete;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority( Priority priority ) {
		this.priority = priority;
	}

	public Boolean getStarred() {
		return starred;
	}

	public void setStarred( Boolean starred ) {
		this.starred = starred;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn( Date modifiedOn ) {
		this.modifiedOn = modifiedOn;
	}

	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn( Date completedOn ) {
		this.completedOn = completedOn;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn( Date addedOn ) {
		this.addedOn = addedOn;
	}

	public Long getTimerSecondsElapsed() {
		return timerSecondsElapsed;
	}

	public void setTimerSecondsElapsed( Long timerSecondsElapsed ) {
		this.timerSecondsElapsed = timerSecondsElapsed;
	}

	public Date getTimerStartedOn() {
		return timerStartedOn;
	}

	public void setTimerStartedOn( Date timerStartedOn ) {
		this.timerStartedOn = timerStartedOn;
	}

	public String getNote() {
		return note;
	}

	public void setNote( String note ) {
		this.note = note;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta( String meta ) {
		this.meta = meta;
	}

}
