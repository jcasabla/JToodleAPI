/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.auth;

import jtoodle.api.json.mixin.util.AbstractJToodleBeanMixIn;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public interface UserIdMixIn extends AbstractJToodleBeanMixIn {

	@JsonProperty( "userid" )
	public abstract String getUserId();
	public abstract void setUserId( String userId );

}
