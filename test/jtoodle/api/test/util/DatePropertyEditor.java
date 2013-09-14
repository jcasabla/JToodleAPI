/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author justo
 */
public class DatePropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		String s = null;
		Date d = (Date) getValue();
		if( d != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"MM/dd/yy HH:mm:ss", Locale.getDefault() );
			s = sdf.format( d );
		}
		return s;
	}

	@Override
	public void setAsText( String s ) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"MM/dd/yy HH:mm:ss", Locale.getDefault() );
			setValue( sdf.parse( s ) );
		} catch( ParseException pe ) {
			IllegalArgumentException iae = new IllegalArgumentException( "Could not parse date" );
			throw iae;
		}
	}
}
