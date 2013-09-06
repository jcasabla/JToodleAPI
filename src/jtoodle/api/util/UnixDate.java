/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.util.Date;

/**
 *
 * @author justo_casablanca
 */
public final class UnixDate {

	private UnixDate() {
	}

	public static long fromJavaDate( Date javaDate ) {
		return javaDate == null ? 0L : javaDate.getTime() / 1000L;
	}

	public static Date toJavaDate( long unixDate ) {
		return unixDate == 0 ? null : new Date( unixDate * 1000L );
	}
}
