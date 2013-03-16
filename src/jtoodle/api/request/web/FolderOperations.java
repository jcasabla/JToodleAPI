/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.bean.Folder;
import static jtoodle.api.request.web.WebBeanOperations.OperationType;

/**
 *
 * @author Justo_Casablanca
 */
public class FolderOperations extends WebBeanOperations<Folder> {

	public FolderOperations() {
		super();

		//registerURI( CRUD.Create, null );
		registerURI( OperationType.RETRIEVE, "/folders/get.php" );
		//registerURI( CRUD.Update, null );
		registerURI( OperationType.DELETE, "/folders/delete.php" );
	}

	@Override
	protected Class<Folder> getBeanClass() {
		return( Folder.class );
	}

}
