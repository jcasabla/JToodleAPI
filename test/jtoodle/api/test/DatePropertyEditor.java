/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author justo
 */
public class DatePropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		Date d = (Date) getValue();
		if( d == null ) {
			//return "No Date Set";
			return null;
		}
		return new SimpleDateFormat( "MM/dd/yy HH:mm:ss" ).format( d );
	}

	@Override
	public void setAsText( String s ) {
		try {
			setValue( new SimpleDateFormat( "MM/dd/yy HH:mm:ss" ).parse( s ) );
		} catch( ParseException pe ) {
			IllegalArgumentException iae = new IllegalArgumentException( "Could not parse date" );
			throw iae;
		}
	}
}
