/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.deser;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import jtoodle.api.bean.util.AbstractJToodleBean;
import jtoodle.api.bean.core.AccountInfo;
import jtoodle.api.bean.core.DeletionResult;
import jtoodle.api.bean.core.Folder;
import jtoodle.api.bean.util.JToodleException;
import jtoodle.api.bean.core.Task;
import jtoodle.api.bean.core.TaskQueryResult;
import jtoodle.api.bean.auth.Token;
import jtoodle.api.bean.auth.UserId;
import jtoodle.api.json.enums.DateFormat;
import jtoodle.api.json.enums.DueDateModifier;
import jtoodle.api.json.enums.Priority;
import jtoodle.api.json.enums.ReminderTime;
import jtoodle.api.json.enums.Status;
import jtoodle.api.json.mixin.core.AccountInfoMixIn;
import jtoodle.api.json.mixin.core.DeletionResultMixIn;
import jtoodle.api.json.mixin.core.FolderMixIn;
import jtoodle.api.json.mixin.util.JToodleExceptionMixIn;
import jtoodle.api.json.mixin.core.TaskMixIn;
import jtoodle.api.json.mixin.core.TaskQueryResultMixIn;
import jtoodle.api.json.mixin.auth.TokenMixIn;
import jtoodle.api.json.mixin.auth.UserIdMixIn;

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

	}

	public static <T extends AbstractJToodleBean> T parseBean( String js, Class<T> clazz )
	throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return( mapper.readValue( js, clazz ) );
	}

	public static <T extends AbstractJToodleBean> List<T> parseBeanList( String js, Class<T> clazz )
	throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return( mapper.readValue( js, mapper.getTypeFactory().constructCollectionType( List.class, clazz ) ) );
	}

	private static void throwJToodleExceptionIfError( String js ) throws IOException, JToodleException {
		if( js.contains( "errorCode" ) ) {
			JToodleException jte = mapper.readValue( js, JToodleException.class );
			throw( jte );
		}
	}

	public static TaskQueryResult parseTaskQueryResults( String js )
	throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );

		TaskQueryResult results = null;
		List<Task> tasks = new ArrayList<>();

		List<LinkedHashMap> values = mapper.readValue(
			js, mapper.getTypeFactory().constructCollectionType(
				List.class, LinkedHashMap.class ) );

		for( LinkedHashMap map : values ) {
			if( map.containsKey( "num" ) ) {
				results = mapper.convertValue( map, TaskQueryResult.class );
			} else if( map.containsKey( "id" ) ) {
				tasks.add( mapper.convertValue( map, Task.class ) );
			}
		}

		if( results != null ) {
			results.setTasks( tasks );
		}

		return( results );
	}
}
