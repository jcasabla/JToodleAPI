/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jtoodle.api.bean.core.TaskQueryResult;

/**
 *
 * @author justo
 */
public abstract class TaskQueryResultMixIn {

	@JsonCreator
	public static TaskQueryResult createTaskQueryResult(
		  @JsonProperty( "num" ) Integer queryTaskCount
		, @JsonProperty( "total" ) Integer totalTaskCount
	)
	{
		return( null );
	}

}
