/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.intf;

/**
 *
 * @author justo
 */
public interface AccountInfoConstants extends NonAuthConstants {

	public static final String URI_GET_ACCOUNT_INFO = new StringBuilder()
			.append( JToodleConstants.BASE_URI )
			.append( "/account/get.php" )
			.toString();

}
