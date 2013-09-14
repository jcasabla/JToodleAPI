/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public abstract class FolderMixIn extends CoreBeanMixIn {

	@JsonProperty( "ord" )
	private Integer order = null;

	@JsonIgnore
	public abstract Integer getOrder();

}
