/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import jtoodle.api.json.deser.TD_BooleanDeserializer;
import jtoodle.api.json.deser.TD_DateDeserializer;
import jtoodle.api.json.deser.TD_DateFormatDeserializer;
import jtoodle.api.json.deser.TD_PriorityDeserializer;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.Priority;
import jtoodle.api.json.mixin.AccountInfoMixIn;
import jtoodle.api.json.mixin.FolderMixIn;
import jtoodle.api.json.mixin.JToodleExceptionMixIn;
import jtoodle.api.json.mixin.TokenMixIn;
import jtoodle.api.json.mixin.UserIdMixIn;

/**
 *
 * @author justo
 */
public class BeanParser {

	private BeanParser() {}

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.addMixInAnnotations( JToodleException.class, JToodleExceptionMixIn.class );
		mapper.addMixInAnnotations( UserId.class, UserIdMixIn.class );
		mapper.addMixInAnnotations( Token.class, TokenMixIn.class );
		mapper.addMixInAnnotations( AccountInfo.class, AccountInfoMixIn.class );
		mapper.addMixInAnnotations( Folder.class, FolderMixIn.class );

		mapper.registerModule(
			new SimpleModule( "TD_DeserializationModule", Version.unknownVersion() )
				.addDeserializer( Boolean.class, new TD_BooleanDeserializer() )
				.addDeserializer( Date.class, new TD_DateDeserializer() )
				.addDeserializer( DateFormat.class, new TD_DateFormatDeserializer() )
				.addDeserializer( Priority.class, new TD_PriorityDeserializer() )
		);

	}

	public static UserId parseUserId( String js ) throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return( mapper.readValue( js, UserId.class ) );
	}

	public static Token parseToken( String js ) throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return( mapper.readValue( js, Token.class ) );
	}

	public static AccountInfo parseAccountInfo( String js ) throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return( mapper.readValue( js, AccountInfo.class ) );
	}

	public static List<Folder> parseFolders( String js ) throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return( mapper.readValue( js, new TypeReference<List<Folder>>() {} ) );
	}

	private static void throwJToodleExceptionIfError( String js ) throws IOException, JToodleException {
		if( js.contains( "errorCode" ) ) {
			JToodleException jte = mapper.readValue( js, JToodleException.class );
			throw( jte );
		}
	}
}
