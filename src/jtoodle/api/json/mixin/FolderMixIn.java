/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author justo
 */
public interface FolderMixIn extends AbstractJToodleBeanMixIn {

	@JsonProperty( "ord" )
	public Integer getOrder();
	public void setOrder( Integer order );

	@JsonProperty( "deleted" )
	public Integer getDeletedId();
	public void setDeletedId( Integer deletedId );
}
