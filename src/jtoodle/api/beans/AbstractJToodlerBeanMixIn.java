/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
abstract class AbstractJToodlerBeanMixIn {

	@JsonProperty( "errorDesc" )
	abstract String getErrorDescription();
	abstract void setErrorDescription( String s );
}
