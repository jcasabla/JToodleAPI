/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.bean;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Date;
import jtoodle.api.bean.auth.Token;
import jtoodle.api.bean.auth.UserId;
import jtoodle.api.bean.core.AccountInfo;
import jtoodle.api.bean.core.DeletionResult;
import jtoodle.api.bean.core.Folder;
import jtoodle.api.bean.core.Task;
import jtoodle.api.bean.core.TaskQueryResult;
import jtoodle.api.bean.util.JToodleException;
import jtoodle.api.json.deser.TD_BooleanDeserializer;
import jtoodle.api.json.deser.TD_EnumDeserializer;
import jtoodle.api.json.deser.TD_ReminderTimeDeserializer;
import jtoodle.api.json.deser.TD_UnixDateDeserializer;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.DueDateModifier;
import jtoodle.api.json.enums.Priority;
import jtoodle.api.json.enums.ReminderTime;
import jtoodle.api.json.enums.Status;
import jtoodle.api.json.mixin.auth.TokenMixIn;
import jtoodle.api.json.mixin.auth.UserIdMixIn;
import jtoodle.api.json.mixin.core.AccountInfoMixIn;
import jtoodle.api.json.mixin.core.DeletionResultMixIn;
import jtoodle.api.json.mixin.core.FolderMixIn;
import jtoodle.api.json.mixin.core.TaskMixIn;
import jtoodle.api.json.mixin.core.TaskQueryResultMixIn;
import jtoodle.api.json.mixin.util.JToodleExceptionMixIn;
import jtoodle.api.json.ser.TD_BooleanSerializer;

/**
 *
 * @author Justo_Casablanca
 */
public final class ObjectMapperFactory {

	private ObjectMapperFactory() {
	}

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.addMixInAnnotations( JToodleException.class, JToodleExceptionMixIn.class );
		mapper.addMixInAnnotations( UserId.class, UserIdMixIn.class );
		mapper.addMixInAnnotations( Token.class, TokenMixIn.class );
		mapper.addMixInAnnotations( AccountInfo.class, AccountInfoMixIn.class );
		mapper.addMixInAnnotations( Folder.class, FolderMixIn.class );
		mapper.addMixInAnnotations( TaskQueryResult.class, TaskQueryResultMixIn.class );
		mapper.addMixInAnnotations( Task.class, TaskMixIn.class );
		mapper.addMixInAnnotations( DeletionResult.class, DeletionResultMixIn.class );

		mapper.registerModule(
			new SimpleModule( "TD_DeserializationModule", Version.unknownVersion() )
				.addDeserializer( Boolean.class, new TD_BooleanDeserializer() )
				.addDeserializer( Date.class, new TD_UnixDateDeserializer() )
				.addDeserializer( DateFormat.class, new TD_EnumDeserializer<>( DateFormat.class ) )
				.addDeserializer( Priority.class, new TD_EnumDeserializer<>( Priority.class ) )
				.addDeserializer( Status.class, new TD_EnumDeserializer<>( Status.class ) )
				.addDeserializer( DueDateModifier.class, new TD_EnumDeserializer<>( DueDateModifier.class ) )
				.addDeserializer( ReminderTime.class, new TD_ReminderTimeDeserializer() )
		);

		mapper.registerModule(
			new SimpleModule( "TD_SerializationModule", Version.unknownVersion() )
				.addSerializer( Boolean.class, new TD_BooleanSerializer() )
				//.addDeserializer( Date.class, new TD_UnixDateDeserializer() )
				//.addDeserializer( DateFormat.class, new TD_EnumDeserializer<>( DateFormat.class ) )
				//.addDeserializer( Priority.class, new TD_EnumDeserializer<>( Priority.class ) )
				//.addDeserializer( Status.class, new TD_EnumDeserializer<>( Status.class ) )
				//.addDeserializer( DueDateModifier.class, new TD_EnumDeserializer<>( DueDateModifier.class ) )
				//.addDeserializer( ReminderTime.class, new TD_ReminderTimeDeserializer() )
				);

	}

	public static ObjectMapper getInstance() {
		return mapper;
	}

}
