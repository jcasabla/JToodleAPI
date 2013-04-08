/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.core;

import java.util.Date;

/**
 *
 * @author Justo_Casablanca
 */
public abstract class TaskNotebookBean extends AbstractCoreBean {

	private String title = null;					// title
	private Integer folderId = null;				// folder
	private Date modifiedOn = null;					// modified
	private Date addedOn = null;					// added

	public String getTitle() {
		return title;
	}

	public void setTitle( String title ) {
		this.title = title;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId( Integer folderId ) {
		this.folderId = folderId;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public Date getAddedOn() {
		return addedOn;
	}

}
