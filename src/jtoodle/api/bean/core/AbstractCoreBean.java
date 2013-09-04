/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.core;

import jtoodle.api.bean.util.AbstractJToodleBean;

/**
 *
 * @author Justo_Casablanca
 */
public abstract class AbstractCoreBean extends AbstractJToodleBean
		implements CoreBean {

	private Integer id = null;

	@Override
	public Integer getId() {
		return( id );
	}

}
