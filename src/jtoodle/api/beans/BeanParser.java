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
import jtoodle.api.json.mixin.AccountInfoMixIn;
import jtoodle.api.json.mixin.TokenMixIn;
import jtoodle.api.json.mixin.UserIdMixIn;
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
public class BeanParser {

	private BeanParser() {}

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.addMixInAnnotations( UserId.class, UserIdMixIn.class );
		mapper.addMixInAnnotations( Token.class, TokenMixIn.class );
		mapper.addMixInAnnotations( AccountInfo.class, AccountInfoMixIn.class );

		mapper.registerModule(
			new SimpleModule( "TD_DeserializationModule", Version.unknownVersion() )
				.addDeserializer( Boolean.class, new TD_BooleanDeserializer() )
				.addDeserializer( Date.class, new TD_DateDeserializer() )
				.addDeserializer( DateFormat.class, new TD_DateFormatDeserializer() )
				.addDeserializer( Priority.class, new TD_PriorityDeserializer() )
		);

	}

	public static UserId parseUserId( String js ) throws IOException {
		return( mapper.readValue( js, UserId.class ) );
	}

	public static Token parseToken( String js ) throws IOException {
		return( mapper.readValue( js, Token.class ) );
	}

	public static AccountInfo parseAccountInfo( String js ) throws IOException {
		return( mapper.readValue( js, AccountInfo.class ) );
	}
}
