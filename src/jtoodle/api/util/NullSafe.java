/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.util.Collection;

/**
 *
 * @author justo
 */
public final class NullSafe {

	public NullSafe() {
	}

	public static boolean equals( Object o1, Object o2 ) {
		if( o1 == o2 ) {
			// scenario 1: both are not null and are the same instance
			// scenario 2: both are null
			return true;
		} else if( o1 == null ) {
			// scenario 3: o1 is null, o2 is not null
			return false;
		} else if( o2 == null ) {
			// scenario 4: o1 is not null, o2 is null
			return false;
		}

		// scenario 5: both o1 and o2 are not null
		return o1.equals( o2 );
	}

	public static boolean isNullOrEmpty( String s ) {
		return ( s == null ) || ( s.trim().length() == 0 );
	}

	public static boolean isNullOrEmpty( Collection c ) {
		return ( c == null ) || c.isEmpty();
	}

}
