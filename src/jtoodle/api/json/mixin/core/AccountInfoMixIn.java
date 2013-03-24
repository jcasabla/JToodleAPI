/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.Priority;
import jtoodle.api.json.mixin.util.AbstractJToodleBeanMixIn;

/**
 *
 * @author justo
 */
public abstract class AccountInfoMixIn implements AbstractJToodleBeanMixIn {

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

	@JsonProperty( "userid" )
	private String userId = null;
	@JsonProperty( "alias" )
	private String alias = null;
	@JsonProperty( "pro" )
	private Boolean pro = null;
	@JsonProperty( "dateformat" )
	private DateFormat dateFormat = null;
	@JsonProperty( "timezone" )
	private Integer timeZone = null;
	@JsonProperty( "hidemonths" )
	private Integer hiddenTasksMinDueMonths = null;
	@JsonProperty( "hotlistpriority" )
	private Priority hotListMinTaskPriority = null;
	@JsonProperty( "hotlistduedate" )
	private Integer hotListMaxDueDays = null;
	@JsonProperty( "hotliststar" )
	private Boolean hotListIncludesStarredTasks = null;
	@JsonProperty( "hotliststatus" )
	private Boolean hotListIncludesNextActionStatus = null;
	@JsonProperty( "showtabnums" )
	private Boolean showSectionTaskCounts = null;
	@JsonProperty( "lastedit_task" )
	private Date lastTaskEditedOn = null;
	@JsonProperty( "lastdelete_task" )
	private Date lastTaskDeletedOn = null;
	@JsonProperty( "lastedit_folder" )
	private Date lastFolderEditedOn = null;
	@JsonProperty( "lastedit_context" )
	private Date lastContextEditedOn = null;
	@JsonProperty( "lastedit_goal" )
	private Date lastGoalEditedOn = null;
	@JsonProperty( "lastedit_location" )
	private Date lastLocationEditedOn = null;
	@JsonProperty( "lastedit_notebook" )
	private Date lastNotebookEditedOn = null;
	@JsonProperty( "lastdelete_notebook" )
	private Date lastNotebookDeletedOn = null;

	@JsonIgnore	public abstract String getUserId();
	@JsonIgnore	public abstract String getAlias();
	@JsonIgnore	public abstract Boolean getPro();
	@JsonIgnore	public abstract Boolean isPro();
	@JsonIgnore	public abstract DateFormat getDateFormat();
	@JsonIgnore	public abstract Integer getTimeZone();
	@JsonIgnore	public abstract Integer getHiddenTasksMinDueMonths();
	@JsonIgnore	public abstract Priority getHotListMinTaskPriority();
	@JsonIgnore	public abstract Integer getHotListMaxDueDays();
	@JsonIgnore	public abstract Boolean getHotListIncludesStarredTasks();
	@JsonIgnore	public abstract Boolean getHotListIncludesNextActionStatus();
	@JsonIgnore	public abstract Boolean getShowSectionTaskCounts();
	@JsonIgnore	public abstract Date getLastTaskEditedOn();
	@JsonIgnore	public abstract Date getLastTaskDeletedOn();
	@JsonIgnore	public abstract Date getLastFolderEditedOn();
	@JsonIgnore	public abstract Date getLastContextEditedOn();
	@JsonIgnore	public abstract Date getLastGoalEditedOn();
	@JsonIgnore	public abstract Date getLastLocationEditedOn();
	@JsonIgnore	public abstract Date getLastNotebookEditedOn();
	@JsonIgnore	public abstract Date getLastNotebookDeletedOn();

}
