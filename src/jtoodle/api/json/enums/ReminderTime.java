/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.enums;

/**
 *
 * @author justo
 */
public enum ReminderTime {
	/*
	 * Task Datatypes (http://api.toodledo.com/2/tasks/index.php)
	 *
	 * remind : An integer that represents the number of minutes prior to the
	 * duedate/time that a reminder will be sent. Set it to 0 for no reminder.
	 * Values will be constrained to this list of valid numbers:
	 *
	 *		(0, 1, 15, 30, 45, 60, 90, 120, 180, 240, 1440, 2880, 4320, 5760, 7200, 8640, 10080, 20160, 43200)
	 *
	 * Additionally, if the user does not have a Pro account, the only valid
	 * numbers are:
	 *
	 *		(0,60)
	 *
	 * If you submit an invalid number, it will be rounded up or down to a valid
	 * non zero value.
	 */

	 No_Reminder,

	 Reminder_1_Minute,
	 Reminder_15_Minutes,
	 Reminder_30_Minutes,
	 Reminder_45_Minutes,
	 Reminder_90_Minutes,

	 Reminder_1_Hour,
	 Reminder_2_Hours,
	 Reminder_3_Hours,
	 Reminder_4_Hours,

	 Reminder_1_Day,
	 Reminder_2_Days,
	 Reminder_3_Days,
	 Reminder_4_Days,
	 Reminder_5_Days,
	 Reminder_6_Days,
	 Reminder_30_Days,

	 Reminder_1_Week,
	 Reminder_2_Weeks;

	 public boolean isNonProOption() {
		 return(
			( ( this == No_Reminder ) || ( this == Reminder_1_Hour ) )
		);
	 }

	 private static final int MINS_PER_HOUR = 60;
	 private static final int MINS_PER_DAY = MINS_PER_HOUR * 24;
	 private static final int MINS_PER_WEEK = MINS_PER_DAY * 7;

	 public Long toMinutes() {
		 Long mins = 0l;

		 if( this != No_Reminder ) {
			 String[] s1 = toString().split( "_" );
			 String s2 = s1[1];
			 mins = Long.parseLong( s2 );

			String timeUnit = s1[2];
			switch( timeUnit ) {
				case "Hour":
				case "Hours": {
					mins *= MINS_PER_HOUR;
					break;
				}
				case "Day":
				case "Days": {
					mins *= MINS_PER_DAY;
					break;
				}
				case "Week":
				case "Weeks": {
					mins *= MINS_PER_WEEK;
					break;
				}
			}
		 }

		 return( mins );
	 }

	 public static ReminderTime toReminderTime( Long minutes ) {
		 ReminderTime rt = null;

		 for( ReminderTime o : ReminderTime.values() ) {
			 if( o.toMinutes() == minutes ) {
				 rt = o;
				 break;
			 }
		 }

		 return( rt );
	 }

}
