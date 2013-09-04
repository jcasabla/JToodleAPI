/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import jtoodle.api.bean.core.Task;
import jtoodle.api.bean.core.TaskQueryResult;
import jtoodle.api.bean.util.AbstractJToodleBean;
import jtoodle.api.bean.util.JToodleException;

/**
 *
 * @author justo
 */
public class BeanParser {

	private BeanParser() {
	}

	public static <T extends AbstractJToodleBean> T parseBean( String js,
															   Class<T> clazz )
			throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		return ObjectMapperFactory.getInstance().readValue( js, clazz );
	}

	public static <T extends AbstractJToodleBean> List<T> parseBeanList(
			String js, Class<T> clazz )
			throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );
		ObjectMapper om = ObjectMapperFactory.getInstance();
		return om.readValue(
				js,
				om.getTypeFactory().constructCollectionType(
					List.class,
					clazz ) );
	}

	private static void throwJToodleExceptionIfError( String js )
			throws IOException, JToodleException {
		if( js.contains( "errorCode" ) ) {
			JToodleException jte = ObjectMapperFactory.getInstance()
					.readValue( js, JToodleException.class );
			throw ( jte );
		}
	}

	public static TaskQueryResult parseTaskQueryResults( String js )
			throws IOException, JToodleException {
		throwJToodleExceptionIfError( js );

		TaskQueryResult results = null;
		List<Task> tasks = new ArrayList<>();

		ObjectMapper om = ObjectMapperFactory.getInstance();
		List<LinkedHashMap> values = om.readValue(
				js,
				om.getTypeFactory().constructCollectionType(
					List.class,
					LinkedHashMap.class ) );

		for( LinkedHashMap map : values ) {
			if( map.containsKey( "num" ) ) {
				results = om.convertValue( map, TaskQueryResult.class );
			} else if( map.containsKey( "id" ) ) {
				tasks.add( om.convertValue( map, Task.class ) );
			}
		}

		if( results != null ) {
			results.setTasks( tasks );
		}

		return results;
	}

}
