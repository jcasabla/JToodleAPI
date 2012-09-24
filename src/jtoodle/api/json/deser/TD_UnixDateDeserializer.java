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
import java.util.Date;
//import java.util.logging.Logger;

/**
 *
 * @author justo
 */
public class TD_UnixDateDeserializer extends JsonDeserializer<Date> {

	//private static final Logger logger = Logger.getLogger( TD_UnixDateDeserializer.class.getName() );

	@Override
	public Date deserialize( JsonParser jp, DeserializationContext dc ) throws IOException, JsonProcessingException {
		//logger.entering( getClass().getName(), "deserialize", new Object[]{ jp, dc } );

		String timestampAsText = jp.getText();
		long dateAsLong = Long.parseLong( timestampAsText );

		//logger.info( getClass().getName() + " / deserialize / dateAsLong=" +
		//			 dateAsLong + ", date=" + new Date( dateAsLong ) );

		return( ( dateAsLong == 0 ) ? null : new Date( dateAsLong * 1000L ) );
	}

}
