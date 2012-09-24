/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request;

import jtoodle.api.beans.AccountInfo;
import jtoodle.api.intf.AccountInfoConstants;

/**
 *
 * @author justo
 */
public class GetAccountInfo extends AbstractAPIWebRequest<AccountInfo>
implements AccountInfoConstants {

	public GetAccountInfo() {
		super( AccountInfoConstants.URI_GET_ACCOUNT_INFO, AccountInfo.class );
	}
}
