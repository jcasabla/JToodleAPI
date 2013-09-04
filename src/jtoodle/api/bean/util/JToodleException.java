/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justo
 */
public class JToodleException extends Exception {

	private static final Logger logger = Logger.getLogger( JToodleException.class.getName() );

	public JToodleException( Integer errorCode, String errorDescription ) {
		super( errorDescription );
		this.errorCode = errorCode;
	}

	private Integer errorCode;

	public Integer getErrorCode() {
		return errorCode;
	}

public static JToodleException createJToodleException(
		  @JsonProperty( "errorCode" ) Integer errorCode
		, @JsonProperty( "errorDesc" ) String errorDescription
	)
	{
		logger.logp( Level.INFO,
					 JToodleException.class.getName(),
					 "createJToodleException",
					 null,
					 new Object[] { errorCode, errorDescription } );
		return new JToodleException( errorCode, errorDescription );
	}

}
