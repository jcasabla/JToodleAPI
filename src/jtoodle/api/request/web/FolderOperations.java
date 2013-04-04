/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.bean.core.Folder;
import static jtoodle.api.request.web.WebBeanOperations.OperationType;

/**
 *
 * @author Justo_Casablanca
 */
public class FolderOperations extends WebBeanOperations<Folder> {

	public FolderOperations() {
		super();

		registerURI( OperationType.ADD, "/folders/add.php" );
		registerURI( OperationType.RETRIEVE, "/folders/get.php" );
		registerURI( OperationType.EDIT, "/folders/edit.php" );
		registerURI( OperationType.DELETE, "/folders/delete.php" );
	}

	@Override
	protected Class<Folder> getBeanClass() {
		return( Folder.class );
	}

}
