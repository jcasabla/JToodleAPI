/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.ser;

import java.util.List;
import jtoodle.api.beans.IdBean;

/**
 *
 * @author justo
 */
public class BeanWriter {

	private BeanWriter() {}

	public static String writeIdList( List<IdBean> idBeans ) {
		StringBuilder idSB = new StringBuilder();
		idSB.append( "[" );

		for( int i=0; i < idBeans.size(); i++ ) {
			if( i > 0 ) {
				idSB.append( "," );
			}
			idSB.append( "\"" );
			idSB.append( idBeans.get( i).getId() );
			idSB.append( "\"" );
		}

		idSB.append( "]" );

		return( idSB.toString() );
	}
}
