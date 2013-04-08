/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public abstract class DeletionResultMixIn extends CoreBeanMixIn {

	@JsonProperty( "deleted" )
	private Integer deleted = null;

}
