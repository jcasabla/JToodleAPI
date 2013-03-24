/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.bean.util;

/**
 *
 * @author Justo_Casablanca
 */
public class DeletionResult extends AbstractJToodleBean implements IdBean {

	private Integer id = null;
	private Integer deleted = null;

	@Override
	public Integer getId() {
		return( ( id == null ) ? deleted : id );
	}

}
