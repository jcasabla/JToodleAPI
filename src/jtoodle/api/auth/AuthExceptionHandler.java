/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.auth;

import java.awt.Component;
import javax.swing.JOptionPane;
import jtoodle.api.bean.util.JToodleException;

/**
 *
 * @author Justo_Casablanca
 */
public class AuthExceptionHandler {

	public static boolean handledInvalidKey( Component c, Exception ex ) {
		boolean val = false;

		if( ex instanceof JToodleException ) {
			JToodleException jte = (JToodleException) ex;

			if( jte.getErrorCode() == 2 ) {
				// Error Code 2 = Invalid Key
				AuthCache.logout();
				JOptionPane.showMessageDialog( c, jte );
				//loginMenuItemActionPerformed( null );
				val = true;
			}
		}

		return val;
	}

}
