/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.core;

import java.util.Date;
import jtoodle.api.bean.util.AbstractJToodleBean;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.Priority;
import jtoodle.api.util.NullSafe;

/**
 *
 * @author justo
 */
public class AccountInfo extends AbstractJToodleBean {

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
	private String userId = null;

	private String alias = null;

	private Boolean pro = null;

	private DateFormat dateFormat = null;

	private Integer timeZone = null;

	private Integer hiddenTasksMinDueMonths = null;

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

	public String getUserId() {
		return userId;
	}

	public String getAlias() {
		return alias;
	}

	public Boolean getPro() {
		return pro;
	}

	public Boolean isPro() {
		return pro;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public Integer getTimeZone() {
		return timeZone;
	}

	public Integer getHiddenTasksMinDueMonths() {
		return hiddenTasksMinDueMonths;
	}

	public Priority getHotListMinTaskPriority() {
		return hotListMinTaskPriority;
	}

	public Integer getHotListMaxDueDays() {
		return hotListMaxDueDays;
	}

	public Boolean getHotListIncludesStarredTasks() {
		return hotListIncludesStarredTasks;
	}

	public Boolean hotListIncludesStarredTasks() {
		return hotListIncludesStarredTasks;
	}

	public Boolean getHotListIncludesNextActionStatus() {
		return hotListIncludesNextActionStatus;
	}

	public Boolean hotListIncludesNextActionStatus() {
		return hotListIncludesNextActionStatus;
	}

	public Boolean getShowSectionTaskCounts() {
		return showSectionTaskCounts;
	}

	public Boolean showSectionTaskCounts() {
		return showSectionTaskCounts;
	}

	public Date getLastTaskEditedOn() {
		return NullSafe.clone( lastTaskEditedOn );
	}

	public Date getLastTaskDeletedOn() {
		return NullSafe.clone( lastTaskDeletedOn );
	}

	public Date getLastFolderEditedOn() {
		return NullSafe.clone( lastFolderEditedOn );
	}

	public Date getLastContextEditedOn() {
		return NullSafe.clone( lastContextEditedOn );
	}

	public Date getLastGoalEditedOn() {
		return NullSafe.clone( lastGoalEditedOn );
	}

	public Date getLastLocationEditedOn() {
		return NullSafe.clone( lastLocationEditedOn );
	}

	public Date getLastNotebookEditedOn() {
		return NullSafe.clone( lastNotebookEditedOn );
	}

	public Date getLastNotebookDeletedOn() {
		return NullSafe.clone( lastNotebookDeletedOn );
	}

}
