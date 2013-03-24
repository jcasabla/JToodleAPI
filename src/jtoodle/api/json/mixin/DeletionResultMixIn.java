/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public abstract class DeletionResultMixIn implements AbstractJToodleBeanMixIn {

	@JsonProperty( "id" )
	private Integer id = null;

	@JsonProperty( "deleted" )
	private Integer deleted = null;

	@JsonIgnore
	public abstract Integer getId();

}
