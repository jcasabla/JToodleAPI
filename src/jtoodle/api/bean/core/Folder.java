/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.core;

/**
 *
 * @author justo
 */
public class Folder extends AbstractCoreBean {
	/*
	 * JSON:[
	 * {
	 *		"id":"123",
	 *		"name":"Shopping",
	 *		"private":"0",
	 *		"archived":"0",
	 *		"ord":"1"
	 * },
	 * {
	 *		"id":"456",
	 *		"name":"Home Repairs",
	 *		"private":"0",
	 *		"archived":"0",
	 *		"ord":"2"
	 * },
	 * {
	 *		"id":"789",
	 *		"name":"Vacation PLanning",
	 *		"private":"0",
	 *		"archived":"0",
	 *		"ord":"3"
	 * }
	 * ]
	 */

	private String name = null;

	private Boolean isPrivate = null;

	private Boolean archived = null;

	private Integer order = null;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Boolean getPrivate() {
		return isPrivate;
	}

	public void setPrivate( Boolean _private ) {
		this.isPrivate = _private;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived( Boolean archived ) {
		this.archived = archived;
	}

	public Integer getOrder() {
		return order;
	}

}
