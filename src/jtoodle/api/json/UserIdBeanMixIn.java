/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public interface UserIdBeanMixIn extends AbstractJToodlerBeanMixIn {

	@JsonProperty( "userid" )
	abstract String getUserId();
	abstract void setUserId( String userId );
}
