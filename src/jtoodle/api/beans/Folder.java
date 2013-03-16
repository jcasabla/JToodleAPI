/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

/**
 *
 * @author justo
 */
public class Folder extends AbstractJToodleBean {
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

	private Integer id = null;
	private String name = null;
	private Boolean _private = null;
	private Boolean archived = null;
	private Integer order = null;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Boolean getPrivate() {
		return _private;
	}

	public void setPrivate( Boolean _private ) {
		this._private = _private;
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

	public void setOrder( Integer order ) {
		this.order = order;
	}

}
