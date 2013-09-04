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

/**
 *
 * @author justo
 */
public class TD_BooleanDeserializer extends JsonDeserializer<Boolean> {

	@Override
	public Boolean deserialize( JsonParser jp, DeserializationContext dc )
			throws IOException, JsonProcessingException {
		String boolS = jp.getText();
		return( "1".equals( boolS ) ? Boolean.TRUE : Boolean.FALSE );
	}

}
