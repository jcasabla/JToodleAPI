/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import jtoodle.api.bean.Token;

/**
 *
 * @author Justo_Casablanca
 */
public class TokenOperations extends WebBeanOperations<Token> {

	public TokenOperations() {
		super();

		//registerURI( CRUD.Create, null );
		registerURI( OperationType.RETRIEVE, "/account/token.php" );
		//registerURI( CRUD.Update, null );
		//registerURI( CRUD.Delete, null );
	}

	@Override
	protected Class<Token> getBeanClass() {
		return( Token.class );
	}

}
