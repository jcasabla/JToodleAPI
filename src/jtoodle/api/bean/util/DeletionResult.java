/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.util;

import jtoodle.api.bean.util.IdBean;
import jtoodle.api.bean.util.AbstractJToodleBean;

/**
 *
 * @author Justo_Casablanca
 */
public class DeletionResult extends AbstractJToodleBean implements IdBean {

	private Integer id = null;

	@Override
	public Integer getId() {
		return( id );
	}

}
