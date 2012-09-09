/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public interface AccountInfoBeanMixIn extends UserIdBeanMixIn {

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

	@JsonProperty( "dateformat" )
	public Integer getDateFormat();
	public void setDateFormat( Integer dateFormat );

	@JsonProperty( "timezone" )
	public Integer getTimeZone();
	public void setTimeZone( Integer timeZone );

	@JsonProperty( "hidemonths" )
	public Integer getHideMonths();
	public void setHideMonths( Integer hideMonths );

	@JsonProperty( "hotlistpriority" )
	public Integer getHotListPriority();
	public void setHotListPriority( Integer hotListPriority );

	@JsonProperty( "hotlistduedate" )
	public Integer getHotListDueDate();
	public void setHotListDueDate( Integer hotListDueDate );

	@JsonProperty( "hotliststar" )
	public Integer getHotListStar();
	public void setHotListStar( Integer hotListStar );

	@JsonProperty( "hotliststatus" )
	public Integer getHotListStatus();
	public void setHotListStatus( Integer hotListStatus );

	@JsonProperty( "showtabnums" )
	public Integer getShowTabNums();
	public void setShowTabNums( Integer showTabNums );

	@JsonProperty( "lastedit_task" )
	public Long getLastEditTaskOn();
	public void setLastEditTaskOn( Long lastEditTaskOn );

	@JsonProperty( "lastdelete_task" )
	public Long getLastDeleteTaskOn();
	public void setLastDeleteTaskOn( Long lastDeleteTaskOn );

	@JsonProperty( "lastedit_folder" )
	public Long getLastEditFolderOn();
	public void setLastEditFolderOn( Long lastEditFolderOn );

	@JsonProperty( "lastedit_context" )
	public Long getLastEditContextOn();
	public void setLastEditContextOn( Long lastEditContextOn );

	@JsonProperty( "lastedit_goal" )
	public Long getLastEditGoalOn();
	public void setLastEditGoalOn( Long lastEditGoalOn );

	@JsonProperty( "lastedit_location" )
	public Long getLastEditLocationOn();
	public void setLastEditLocationOn( Long lastEditLocationOn );

	@JsonProperty( "lastedit_notebook" )
	public Long getLastEditNotebookOn();
	public void setLastEditNotebookOn( Long lastEditNotebookOn );

	@JsonProperty( "lastdelete_notebook" )
	public Long getLastDeleteNotebookOn();
	public void setLastDeleteNotebookOn( Long lastDeleteNotebookOn );
}
