/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.enums;

/**
 *
 * @author justo
 */
public enum Status {
	/*
	 * Task Datatypes (http://api.toodledo.com/2/tasks/index.php)
	 *
	 * status : An integer that represents the status of the task.
	 *
	 *  0 = None
	 *  1 = Next Action
	 *  2 = Active
	 *  3 = Planning
	 *  4 = Delegated
	 *  5 = Waiting
	 *  6 = Hold
	 *  7 = Postponed
	 *  8 = Someday
	 *  9 = Canceled
	 * 10 = Reference
	 */

	None,
	Next_Action,
	Active,
	Planning,
	Delegated,
	Waiting,
	Hold,
	Postponed,
	Someday,
	Canceled,
	Reference

}
