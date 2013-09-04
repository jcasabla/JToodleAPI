/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jtoodle.api.json.mixin.util.AbstractJToodleBeanMixIn;

/**
 *
 * @author justo
 */
public interface UserIdMixIn extends AbstractJToodleBeanMixIn {

	@JsonProperty( "userid" )
	public abstract String getUserId();

	public abstract void setUserId( String userId );

}
