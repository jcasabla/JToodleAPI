/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test.util;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author justo
 */
public class ClassPropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		Class c = (Class) getValue();
		if( c == null ) {
			return null;
		}
		return c.getName();
	}

	@Override
	public void setAsText( String s ) {
		throw new UnsupportedOperationException();
	}
}
