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
public class TD_EnumDeserializer<E extends Enum<E>> extends JsonDeserializer<E> {

	private Class<E> enumClazz = null;

	public TD_EnumDeserializer( Class<E> enumClazz ) {
		this.enumClazz = enumClazz;
	}

	@Override
	public E deserialize( JsonParser jp, DeserializationContext dc ) throws IOException, JsonProcessingException {
		return( enumClazz.getEnumConstants()[ Integer.parseInt( jp.getText() ) ] );
	}

}
