/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.intf;

/**
 *
 * @author justo
 */
public interface AccountLookupConstants extends JToodleConstants {

	public static final String URI_ACCOUNT_LOOKUP = new StringBuilder()
			.append( BASE_URI )
			.append( "/account/lookup.php" )
			.toString();

}
