/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.json.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 * 
 * @author justo
 */
public class TD_BooleanSerializer extends JsonSerializer<Boolean> {

	/*
	@Override
	public Boolean deserialize( JsonParser jp, DeserializationContext dc ) throws IOException, JsonProcessingException {
		String boolS = jp.getText();
		return( "1".equals(  boolS ) ? Boolean.TRUE : Boolean.FALSE );
	}
	*/

	@Override
	public void serialize( Boolean value, JsonGenerator jgen, SerializerProvider provider ) throws IOException, JsonProcessingException {
		jgen.writeNumber( value ? 1 : 0 );
	}

}
