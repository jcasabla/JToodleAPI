/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.enums;

/**
 *
 * @author justo
 */
public enum DueDateModifier {
	/*
	 * Task Datatypes (http://api.toodledo.com/2/tasks/index.php)
	 *
	 * duedatemod : An integer representing the due date modifier.
	 *		0 = Due By
	 *		1 = Due On (=)
	 *		2 = Due After (>)
	 *		3 = Optionally (?)
	 */

	Due_By,
	Due_On,
	Due_After,
	Optionally
}
