/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import jtoodle.api.json.enums.Priority;

/**
 *
 * @author justo
 */
public class TD_PriorityDeserializer extends JsonDeserializer<Priority> {

	@Override
	public Priority deserialize( JsonParser jp, DeserializationContext dc ) throws IOException, JsonProcessingException {
		return( Priority.values()[ Integer.parseInt( jp.getText() ) ] );
	}

}
