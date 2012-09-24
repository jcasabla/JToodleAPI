/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.intf;

/**
 *
 * @author justo
 */
public interface AuthenticationConstants extends JToodleConstants {

	public static final String URI_ACCOUNT_LOOKUP = new StringBuilder()
			.append( JToodleConstants.BASE_URI )
			.append( "/account/lookup.php" )
			.toString();

	public static final String URI_GET_TOKEN = new StringBuilder()
			.append( JToodleConstants.BASE_URI )
			.append( "/account/token.php" )
			.toString();

	////////////////////////////////////////////////////////////////////////////

	public static final String APP_ID = "JToodler";
	public static final String APP_TOKEN = "api501b4480108f7";

	////////////////////////////////////////////////////////////////////////////

	public static final String PARAM_NAME_EMAIL = "email";
	public static final String PARAM_NAME_PASSWORD = "pass";

	public static final String PARAM_NAME_SIGNATURE = "sig";

	public static final String PARAM_NAME_USER_ID = "userid";
	public static final String PARAM_NAME_APP_ID = "appid";
	public static final String PARAM_NAME_VERSION = "vers";
	public static final String PARAM_NAME_DEVICE = "device";
	public static final String PARAM_NAME_OS = "os";

}
