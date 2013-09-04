/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.bean.auth.UserId;

/**
 *
 * @author Justo_Casablanca
 */
public class UserIdOperations extends WebBeanOperations<UserId> {

	public UserIdOperations() {
		super();

		//registerURI( CRUD.Create, null );
		registerURI( OperationType.RETRIEVE, "/account/lookup.php" );
		//registerURI( CRUD.Update, null );
		//registerURI( CRUD.Delete, null );
	}

	@Override
	protected Class<UserId> getBeanClass() {
		return UserId.class;
	}

}
