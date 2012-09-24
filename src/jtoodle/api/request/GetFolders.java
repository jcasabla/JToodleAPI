/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import jtoodle.api.beans.Folder;
import jtoodle.api.intf.FolderConstants;

/**
 *
 * @author justo
 */
public class GetFolders extends AbstractAPIWebRequest<Folder>
implements FolderConstants {

	public GetFolders() {
		super( FolderConstants.URI_GET_FOLDERS, Folder.class );
	}
}
