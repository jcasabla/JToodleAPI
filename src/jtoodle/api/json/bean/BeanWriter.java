/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import jtoodle.api.bean.core.CoreBean;
import jtoodle.api.bean.util.AbstractJToodleBean;

/**
 *
 * @author justo
 */
public class BeanWriter {

	private BeanWriter() {}

	public static <T extends AbstractJToodleBean> String jsonString( List<T> beans )
	throws JsonProcessingException {
		return( ObjectMapperFactory.getInstance().writeValueAsString( beans ) );
	}

	public static <T extends AbstractJToodleBean> String jsonString( T bean )
	throws JsonProcessingException {
		return( ObjectMapperFactory.getInstance().writeValueAsString( bean ) );
	}

	public static String writeIdList( List<CoreBean> idBeans ) {
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
