/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.intf;

/**
 *
 * @author justo
 */
public interface FolderConstants extends NonAuthConstants {

	public static final String URI_GET_FOLDERS = new StringBuilder()
			.append( BASE_URI )
			.append( "/folders/get.php" )
			.toString();

}