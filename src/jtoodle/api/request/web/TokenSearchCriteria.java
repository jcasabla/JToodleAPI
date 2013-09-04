/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jtoodle.api.bean.auth.Token;
import jtoodle.api.intf.AuthenticationConstants;
import jtoodle.api.util.Hasher;

/**
 *
 * @author Justo_Casablanca
 */
public class TokenSearchCriteria extends TaskOperations.OperationCriteria<Token> {

	public TokenSearchCriteria() {
		super( Token.class, TaskOperations.OperationType.RETRIEVE );

		setOption( PARAM_NAME_VERSION, "1" );
		setOption( PARAM_NAME_DEVICE, "laptop" );
		setOption( PARAM_NAME_OS, System.getProperty( "os.name" ) );
	}

	public void setUserId( String userId ) {
		setOption( PARAM_NAME_USER_ID, userId );

		try {
			setOption(
				AuthenticationConstants.PARAM_NAME_SIGNATURE,
				Hasher.md5Hash( userId + AuthenticationConstants.APP_TOKEN ) );
		} catch( NoSuchAlgorithmException ex ) {
			Logger.getLogger( TokenSearchCriteria.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}

	private static final String PARAM_NAME_VERSION = "vers";
	private static final String PARAM_NAME_DEVICE = "device";
	private static final String PARAM_NAME_OS = "os";

	public static final String PARAM_NAME_USER_ID = "userid";

}
