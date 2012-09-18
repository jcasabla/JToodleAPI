/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import jtoodle.api.beans.Folder;

/**
 *
 * @author justo
 */
public class GetFolders extends AbstractAPIWebRequest<Folder> {

	public GetFolders() {
		super( URI_GET_FOLDERS, Folder.class );
	}
}
