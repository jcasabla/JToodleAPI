/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jtoodle.api.bean.util.JToodleException;

/**
 *
 * @author justo
 */
public abstract class JToodleExceptionMixIn {

	@JsonCreator
	public static JToodleException createJToodleException(
		@JsonProperty( "errorCode" ) Integer errorCode,
		@JsonProperty( "errorDesc" ) String errorDescription ) {
		return null;
	}

}
