/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import java.util.Date;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.Priority;

/**
 *
 * @author justo
 */
public class AccountInfo extends UserId {

	/*
	 * JSON sample from https://api.toodledo.com/2/account/doc_info.php
	 *
	 * {
	 *	 "userid":"a1b2c3d4e5f6"
	 *	,"alias":"John"
	 *	,"pro":"0"
	 *	,"dateformat":"0"
	 *	,"timezone":"-6"
	 *	,"hidemonths":"2"
	 *	,"hotlistpriority":"3"
	 *	,"hotlistduedate":"2"
	 *	,"showtabnums":"1"
	 *	,"lastedit_folder":"1281457337"
	 *	,"lastedit_context":"1281457997"
	 *	,"lastedit_goal":"1280441959"
	 *	,"lastedit_location":"1280441959"
	 *	,"lastedit_task":"1281458832"
	 *	,"lastdelete_task":"1280898329"
	 *	,"lastedit_notebook":"1280894728"
	 *	,"lastdelete_notebook":"1280898329"
	 * }
	 */

	/*
	 * JSON field defintions from https://api.toodledo.com/2/account/doc_info.php
	 *
	 * pro : Whether or not the user is a Pro member. You need to know this if you want to use subtasks.
	 * dateformat : The user's prefered format for representing dates. (0=M D, Y, 1=M/D/Y, 2=D/M/Y, 3=Y-M-D)
	 * timezone : The number of half hours that the user's timezone is offset from the server's timezone. A value of -4 means that the user's timezone is 2 hours earlier than the server's timezone.
	 * hidemonths : If the task is due this many months into the future, the user wants them to be hidden.
	 * hotlistpriority : The priority value above which tasks should appear on the hotlist.
	 * hotlistduedate : The due date lead-time by which tasks should will appear on the hotlist.
	 * hotliststar : 0 or 1 if the star contributes to the hotlist.
	 * hotliststatus : 0 or 1 if the status contributes to the hotlist.
	 * showtabnums : The user's preference for viewing counters showing the number of tasks in each section.
	 * lastedit_task : A timestamp that indicates the last time that any task was added or edited on this account. You can quickly check this field to determine if you need to download updates.
	 * lastdelete_task : A timestamp that indicates the last time that any task was deleted from this account. You can quickly check this field to determine if you need to identify and remove tasks from your application.
	 * lastedit_folder : A timestamp that indicates the last time that a folder was added, edited or deleted. You can quickly check this field to determine if you need to refresh your cached folder list.
	 * lastedit_context : A timestamp that indicates the last time that a context was added, edited or deleted. You can quickly check this field to determine if you need to refresh your cached context list.
	 * lastedit_goal : A timestamp that indicates the last time that a goal was added, edited or deleted. You can quickly check this field to determine if you need to refresh your cached goal list.
	 * lastedit_location : A timestamp that indicates the last time that a location was added, edited or deleted. You can quickly check this field to determine if you need to refresh your cached location list.
	 * lastedit_notebook : A timestamp that indicates the last time that any notebook was added or edited on this account. You can quickly check this field to determine if you need to download updates.
	 * lastdelete_notebook : A timestamp that indicates the last time that any notebook was deleted from this account. You can quickly check this field to determine if you need to identify and remove notebooks from your application.
	 */

	private String alias = null;
	private Boolean pro = null;
	private DateFormat dateFormat = null;
	private Integer timeZone = null;
	private Integer hideMonths = null;
	private Priority hotListMinTaskPriority = null;
	private Integer hotListMaxDueDays = null;
	private Boolean hotListIncludesStarredTasks = null;
	private Boolean hotListIncludesNextActionStatus = null;
	private Boolean showSectionTaskCounts = null;
	private Date lastTaskEditedOn = null;
	private Date lastTaskDeletedOn = null;
	private Date lastFolderEditedOn = null;
	private Date lastContextEditedOn = null;
	private Date lastGoalEditedOn = null;
	private Date lastLocationEditedOn = null;
	private Date lastNotebookEditedOn = null;
	private Date lastNotebookDeletedOn = null;

	public String getAlias() {
		return alias;
	}

	public void setAlias( String alias ) {
		this.alias = alias;
	}

	public Boolean getPro() {
		return pro;
	}

	public void setPro( Boolean pro ) {
		this.pro = pro;
	}

	public Boolean isPro() {
		return pro;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat( DateFormat dateFormat ) {
		this.dateFormat = dateFormat;
	}

	public Integer getTimeZone() {
		return timeZone;
	}

	public void setTimeZone( Integer timeZone ) {
		this.timeZone = timeZone;
	}

	public Integer getHideMonths() {
		return hideMonths;
	}

	public void setHideMonths( Integer hideMonths ) {
		this.hideMonths = hideMonths;
	}

	public Priority getHotListMinTaskPriority() {
		return hotListMinTaskPriority;
	}

	public void setHotListMinTaskPriority( Priority hotListMinTaskPriority ) {
		this.hotListMinTaskPriority = hotListMinTaskPriority;
	}

	public Integer getHotListMaxDueDays() {
		return hotListMaxDueDays;
	}

	public void setHotListMaxDueDays( Integer hotListMaxDueDays ) {
		this.hotListMaxDueDays = hotListMaxDueDays;
	}

	public Boolean getHotListIncludesStarredTasks() {
		return hotListIncludesStarredTasks;
	}

	public void setHotListIncludesStarredTasks( Boolean hotListIncludesStarredTasks ) {
		this.hotListIncludesStarredTasks = hotListIncludesStarredTasks;
	}

	public Boolean hotListIncludesStarredTasks() {
		return hotListIncludesStarredTasks;
	}

	public Boolean getHotListIncludesNextActionStatus() {
		return hotListIncludesNextActionStatus;
	}

	public void setHotListIncludesNextActionStatus( Boolean hotListIncludesNextActionStatus ) {
		this.hotListIncludesNextActionStatus = hotListIncludesNextActionStatus;
	}

	public Boolean hotListIncludesNextActionStatus() {
		return hotListIncludesNextActionStatus;
	}

	public Boolean getShowSectionTaskCounts() {
		return showSectionTaskCounts;
	}

	public void setShowSectionTaskCounts( Boolean showSectionTaskCounts ) {
		this.showSectionTaskCounts = showSectionTaskCounts;
	}

	public Boolean showSectionTaskCounts() {
		return showSectionTaskCounts;
	}

	public Date getLastTaskEditedOn() {
		return lastTaskEditedOn;
	}

	public void setLastTaskEditedOn( Date lastTaskEditedOn ) {
		this.lastTaskEditedOn = lastTaskEditedOn;
	}

	public Date getLastTaskDeletedOn() {
		return lastTaskDeletedOn;
	}

	public void setLastTaskDeletedOn( Date lastTaskDeletedOn ) {
		this.lastTaskDeletedOn = lastTaskDeletedOn;
	}

	public Date getLastFolderEditedOn() {
		return lastFolderEditedOn;
	}

	public void setLastFolderEditedOn( Date lastFolderEditedOn ) {
		this.lastFolderEditedOn = lastFolderEditedOn;
	}

	public Date getLastContextEditedOn() {
		return lastContextEditedOn;
	}

	public void setLastContextEditedOn( Date lastContextEditedOn ) {
		this.lastContextEditedOn = lastContextEditedOn;
	}

	public Date getLastGoalEditedOn() {
		return lastGoalEditedOn;
	}

	public void setLastGoalEditedOn( Date lastGoalEditedOn ) {
		this.lastGoalEditedOn = lastGoalEditedOn;
	}

	public Date getLastLocationEditedOn() {
		return lastLocationEditedOn;
	}

	public void setLastLocationEditedOn( Date lastLocationEditedOn ) {
		this.lastLocationEditedOn = lastLocationEditedOn;
	}

	public Date getLastNotebookEditedOn() {
		return lastNotebookEditedOn;
	}

	public void setLastNotebookEditedOn( Date lastNotebookEditedOn ) {
		this.lastNotebookEditedOn = lastNotebookEditedOn;
	}

	public Date getLastNotebookDeletedOn() {
		return lastNotebookDeletedOn;
	}

	public void setLastNotebookDeletedOn( Date lastNotebookDeletedOn ) {
		this.lastNotebookDeletedOn = lastNotebookDeletedOn;
	}

}
