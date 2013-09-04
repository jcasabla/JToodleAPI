/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jtoodle.api.bean.auth.UserId;
import jtoodle.api.intf.AuthenticationConstants;
import jtoodle.api.util.Hasher;

/**
 *
 * @author Justo_Casablanca
 */
public class UserIdSearchCriteria extends TaskOperations.OperationCriteria<UserId> {

	public UserIdSearchCriteria() {
		super( UserId.class, TaskOperations.OperationType.RETRIEVE );
	}

	public void setEmail( String email ) {
		setOption( PARAM_NAME_EMAIL, email );

		try {
			setOption(
				AuthenticationConstants.PARAM_NAME_SIGNATURE,
				Hasher.md5Hash( email + AuthenticationConstants.APP_TOKEN ) );
		} catch( NoSuchAlgorithmException ex ) {
			Logger.getLogger( UserIdSearchCriteria.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}

	public void setPassword( String password ) {
		setOption( PARAM_NAME_PASSWORD, password );
	}

	private static final String PARAM_NAME_EMAIL = "email";
	private static final String PARAM_NAME_PASSWORD = "pass";

}
