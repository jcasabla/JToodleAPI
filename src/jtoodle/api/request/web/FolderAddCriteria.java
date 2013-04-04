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
public class FolderAddCriteria extends FolderOperations.OperationCriteria<Folder> {

	public FolderAddCriteria() {
		super( Folder.class, TaskOperations.OperationType.ADD );
	}

	public void setFolder( Folder folderToAdd ) {
		ObjectMapper mapper = ObjectMapperFactory.getInstance();
		JsonNode rootNode = mapper.valueToTree( folderToAdd );
		Iterator<String> fieldNames = rootNode.fieldNames();

		while( fieldNames.hasNext() ) {
			String fName = fieldNames.next();

			switch( fName ) {
				case "archived":
				case "id":
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
