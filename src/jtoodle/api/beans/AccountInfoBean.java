/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

/**
 *
 * @author justo
 */
public class AccountInfoBean extends UserIdBean {

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
	private Integer pro = null;
	private Integer dateFormat = null;
	private Integer timeZone = null;
	private Integer hideMonths = null;
	private Integer hotListPriority = null;
	private Integer hotListDueDate = null;
	private Integer hotListStar = null;
	private Integer hotListStatus = null;
	private Integer showTabNums = null;
	private Long lastEditTaskOn = null;
	private Long lastDeleteTaskOn = null;
	private Long lastEditFolderOn = null;
	private Long lastEditContextOn = null;
	private Long lastEditGoalOn = null;
	private Long lastEditLocationOn = null;
	private Long lastEditNotebookOn = null;
	private Long lastDeleteNotebookOn = null;

	public String getAlias() {
		return alias;
	}

	public void setAlias( String alias ) {
		this.alias = alias;
	}

	public Integer getPro() {
		return pro;
	}

	public void setPro( Integer pro ) {
		this.pro = pro;
	}

	public Integer getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat( Integer dateFormat ) {
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

	public Integer getHotListPriority() {
		return hotListPriority;
	}

	public void setHotListPriority( Integer hotListPriority ) {
		this.hotListPriority = hotListPriority;
	}

	public Integer getHotListDueDate() {
		return hotListDueDate;
	}

	public void setHotListDueDate( Integer hotListDueDate ) {
		this.hotListDueDate = hotListDueDate;
	}

	public Integer getHotListStar() {
		return hotListStar;
	}

	public void setHotListStar( Integer hotListStar ) {
		this.hotListStar = hotListStar;
	}

	public Integer getHotListStatus() {
		return hotListStatus;
	}

	public void setHotListStatus( Integer hotListStatus ) {
		this.hotListStatus = hotListStatus;
	}

	public Integer getShowTabNums() {
		return showTabNums;
	}

	public void setShowTabNums( Integer showTabNums ) {
		this.showTabNums = showTabNums;
	}

	public Long getLastEditTaskOn() {
		return lastEditTaskOn;
	}

	public void setLastEditTaskOn( Long lastEditTaskOn ) {
		this.lastEditTaskOn = lastEditTaskOn;
	}

	public Long getLastDeleteTaskOn() {
		return lastDeleteTaskOn;
	}

	public void setLastDeleteTaskOn( Long lastDeleteTaskOn ) {
		this.lastDeleteTaskOn = lastDeleteTaskOn;
	}

	public Long getLastEditFolderOn() {
		return lastEditFolderOn;
	}

	public void setLastEditFolderOn( Long lastEditFolderOn ) {
		this.lastEditFolderOn = lastEditFolderOn;
	}

	public Long getLastEditContextOn() {
		return lastEditContextOn;
	}

	public void setLastEditContextOn( Long lastEditContextOn ) {
		this.lastEditContextOn = lastEditContextOn;
	}

	public Long getLastEditGoalOn() {
		return lastEditGoalOn;
	}

	public void setLastEditGoalOn( Long lastEditGoalOn ) {
		this.lastEditGoalOn = lastEditGoalOn;
	}

	public Long getLastEditLocationOn() {
		return lastEditLocationOn;
	}

	public void setLastEditLocationOn( Long lastEditLocationOn ) {
		this.lastEditLocationOn = lastEditLocationOn;
	}

	public Long getLastEditNotebookOn() {
		return lastEditNotebookOn;
	}

	public void setLastEditNotebookOn( Long lastEditNotebookOn ) {
		this.lastEditNotebookOn = lastEditNotebookOn;
	}

	public Long getLastDeleteNotebookOn() {
		return lastDeleteNotebookOn;
	}

	public void setLastDeleteNotebookOn( Long lastDeleteNotebookOn ) {
		this.lastDeleteNotebookOn = lastDeleteNotebookOn;
	}

}
