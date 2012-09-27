/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author justo
 */
public class FullDateTableCellRenderer extends DefaultTableCellRenderer {

	public FullDateTableCellRenderer() {
		super();
		setHorizontalAlignment( RIGHT );
	}

	@Override
	public Component getTableCellRendererComponent(JTable table,
										Object value,
										boolean isSelected,
										boolean hasFocus,
										int row,
										int column )
	{
		Object value2 = value;

		if( ( value != null) && ( value instanceof Date ) ) {
			value2 = sdf.format( (Date) value );
		}

		return( super.getTableCellRendererComponent(table, value2, isSelected, hasFocus, row, column));
	}

	private static final SimpleDateFormat sdf = new SimpleDateFormat( "EEE, MM/dd/yyyy 'at' HH:mm:ss:SSS zzz" );

	static {
		sdf.setTimeZone( TimeZone.getTimeZone( "GMT" ) );
	}

}
