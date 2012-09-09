/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

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
	}

	public static UserIdBean toUserIdBean( String js ) throws IOException {
		return( mapper.readValue( js, UserIdBean.class ) );
	}

	public static TokenBean toTokenBean( String js ) throws IOException {
		return( mapper.readValue( js, TokenBean.class ) );
	}
}
