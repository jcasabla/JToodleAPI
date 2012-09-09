/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import jtoodle.api.json.AccountInfoBeanMixIn;
import jtoodle.api.json.TokenBeanMixIn;
import jtoodle.api.json.UserIdBeanMixIn;

/**
 *
 * @author justo
 */
public class BeanParseUtil {

	private BeanParseUtil() {}

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.addMixInAnnotations( UserIdBean.class, UserIdBeanMixIn.class );
		mapper.addMixInAnnotations( TokenBean.class, TokenBeanMixIn.class );
		mapper.addMixInAnnotations( AccountInfoBean.class, AccountInfoBeanMixIn.class );
	}

	public static UserIdBean toUserIdBean( String js ) throws IOException {
		return( mapper.readValue( js, UserIdBean.class ) );
	}

	public static TokenBean toTokenBean( String js ) throws IOException {
		return( mapper.readValue( js, TokenBean.class ) );
	}

	public static AccountInfoBean toAccountInfoBean( String js ) throws IOException {
		return( mapper.readValue( js, AccountInfoBean.class ) );
	}
}
