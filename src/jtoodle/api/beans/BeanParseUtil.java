/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.Date;
import jtoodle.api.json.AccountInfoBeanMixIn;
import jtoodle.api.json.TokenBeanMixIn;
import jtoodle.api.json.UserIdBeanMixIn;
import jtoodle.api.json.deser.TD_BooleanDeserializer;
import jtoodle.api.json.deser.TD_DateDeserializer;
import jtoodle.api.json.deser.TD_DateFormatDeserializer;
import jtoodle.api.json.deser.TD_PriorityDeserializer;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.Priority;

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

		mapper.registerModule(
			new SimpleModule( "TD_DeserializationModule", Version.unknownVersion() )
				.addDeserializer( Boolean.class, new TD_BooleanDeserializer() )
				.addDeserializer( Date.class, new TD_DateDeserializer() )
				.addDeserializer( DateFormat.class, new TD_DateFormatDeserializer() )
				.addDeserializer( Priority.class, new TD_PriorityDeserializer() )
		);

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
