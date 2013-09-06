/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test.other;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jtoodle.api.bean.core.Folder;
import jtoodle.api.json.bean.ObjectMapperFactory;

/**
 *
 * @author Justo_Casablanca
 */
public final class FolderTreeNodeTest {

	private FolderTreeNodeTest() {
	}

	private static final Logger logger = Logger.getLogger( FolderTreeNodeTest.class.getName() );

	public static void main( String[] args ) {
		Folder f = new Folder();
		f.setName( "My Folder Name" );
		f.setPrivate( Boolean.TRUE );
		f.setArchived( Boolean.FALSE );

		ObjectMapper mapper = ObjectMapperFactory.getInstance();
		JsonNode rootNode = mapper.valueToTree( f );

		Iterator<String> fieldNames = rootNode.fieldNames();
		for(int i=0; fieldNames.hasNext(); i++) {
			String fName = fieldNames.next();
			JsonNode fValue = rootNode.findValue( fName );

			logger.log(  Level.INFO, "fieldNames[{0}] = [{1}], value = [{2}]",
						 new Object[] { i, fName, fValue.asText() } );
		}
	}
}
