/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.beans.Folder;

/**
 *
 * @author Justo_Casablanca
 */
public class FolderDeletionCriteria extends TaskOperations.OperationCriteria<Folder> {

	public FolderDeletionCriteria() {
		super( Folder.class, TaskOperations.OperationType.DELETE );
	}

	public void setFolder( Folder folderToDelete ) {
		setOption( PARAM_DEL_FOLDER_FOLDER_ID, folderToDelete.getId().toString() );
	}

	private static final String PARAM_DEL_FOLDER_FOLDER_ID = "id";

}
