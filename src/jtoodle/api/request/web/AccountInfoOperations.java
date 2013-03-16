/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.bean.core.AccountInfo;

/**
 *
 * @author Justo_Casablanca
 */
public class AccountInfoOperations extends WebBeanOperations<AccountInfo> {

	public AccountInfoOperations() {
		super();

		//registerURI( CRUD.Create, null );
		registerURI( OperationType.RETRIEVE, "/account/get.php" );
		//registerURI( CRUD.Update, null );
		//registerURI( CRUD.Delete, null );
	}

	@Override
	protected Class<AccountInfo> getBeanClass() {
		return( AccountInfo.class );
	}

}
