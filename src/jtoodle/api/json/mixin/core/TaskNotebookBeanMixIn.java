/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author justo
 */
public abstract class TaskNotebookBeanMixIn extends CoreBeanMixIn {

	@JsonProperty( "modified" )
	private Date modifiedOn = null;

	@JsonProperty( "added" )
	private Date addedOn = null;

	//@JsonProperty( "title" )
	//public abstract String getTitle();
	//public abstract void setTitle( String title );

	@JsonProperty( "folder" )
	public abstract Integer getFolderId();
	public abstract void setFolderId( Integer folderId );

	@JsonIgnore public abstract Date getModifiedOn();
	@JsonIgnore public abstract Date getAddedOn();

}
