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
interface AbstractJToodlerBeanMixIn {

	@JsonProperty( "errorDesc" )
	abstract String getErrorDescription();
	abstract void setErrorDescription( String s );
}
