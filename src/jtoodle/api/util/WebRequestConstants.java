/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

/**
 *
 * @author justo
 */
public interface WebRequestConstants {

	public static final String BASE_URI = "https://api.toodledo.com/2";

	public static final String URI_ACCOUNT_LOOKUP = new StringBuilder()
			.append( BASE_URI )
			.append( "/account/lookup.php" )
			.toString();

	public static final String URI_GET_TOKEN = new StringBuilder()
			.append( BASE_URI )
			.append( "/account/token.php" )
			.toString();

	public static final String URI_GET_ACCOUNT_INFO = new StringBuilder()
			.append( BASE_URI )
			.append( "/account/get.php" )
			.toString();

	public static final String URI_GET_FOLDERS = new StringBuilder()
			.append( BASE_URI )
			.append( "/folders/get.php" )
			.toString();

	public static final String URI_GET_TASKS = new StringBuilder()
			.append( BASE_URI )
			.append( "/tasks/get.php" )
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
	public static final String PARAM_NAME_FORMAT = "f";
	public static final String PARAM_NAME_KEY = "key";
}
