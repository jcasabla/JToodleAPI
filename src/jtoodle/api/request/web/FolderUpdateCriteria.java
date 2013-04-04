/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import jtoodle.api.bean.core.Folder;
import jtoodle.api.json.bean.ObjectMapperFactory;

/**
 *
 * @author Justo_Casablanca
 */
public class FolderUpdateCriteria extends FolderOperations.OperationCriteria<Folder> {

	public FolderUpdateCriteria() {
		super( Folder.class, TaskOperations.OperationType.EDIT );
	}

	public void setFolder( Folder folderToUpdate ) {
		ObjectMapper mapper = ObjectMapperFactory.getInstance();
		JsonNode rootNode = mapper.valueToTree( folderToUpdate );
		Iterator<String> fieldNames = rootNode.fieldNames();

		while( fieldNames.hasNext() ) {
			String fName = fieldNames.next();

			switch( fName ) {
				case "ord":
					break;
				default: {
					JsonNode fValue = rootNode.findValue( fName );

					if( !fValue.isNull() ) {
						setOption( fName, fValue.asText() );
					}
				}
			}
		}
	}

}
