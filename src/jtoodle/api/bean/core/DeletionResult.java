/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.core;

/**
 *
 * @author Justo_Casablanca
 */
public class DeletionResult extends AbstractCoreBean {

	private Integer deleted = null;

	@Override
	public Integer getId() {
		return ( deleted == null ) ? super.getId() : deleted;
	}

}
