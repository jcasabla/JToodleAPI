/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author justo
 */
public final class NullSafe {

	private NullSafe() {
	}

	public static boolean equals( Object obj1, Object obj2 ) {
		boolean retVal;

		if( ( obj1 == null ) && ( obj2 == null ) ) {
			// obvious
			retVal = true;
		} else if( obj1 == null ) {
			// obj2 != null, so the two can never be equal
			retVal = false;
		} else {
			// since obj1 != null, the call to .equals() should never
			// throw NPE
			retVal = obj1.equals( obj2 );
		}

		return retVal;
	}

	public static boolean isNullOrEmpty( String aString ) {
		return ( aString == null ) || aString.trim().isEmpty();
	}

	public static boolean isNullOrEmpty( Collection aCollection ) {
		return ( aCollection == null ) || aCollection.isEmpty();
	}

	public static Date clone( Date aDate ) {
		return aDate == null ? null :  (Date) aDate.clone();
	}
}
