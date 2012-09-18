/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import jtoodle.api.beans.AccountInfo;

/**
 *
 * @author justo
 */
public class GetAccountInfo extends AbstractAPIWebRequest<AccountInfo> {

	public GetAccountInfo() {
		super( URI_GET_ACCOUNT_INFO, AccountInfo.class );
	}
}
