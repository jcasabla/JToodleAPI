/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtoodle.api.test.util;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
//import org.jmc.common.ui.Selecting;

/**
 *
 * @author localadmin
 */
public final class JTableUtil {

	private static final Logger logger = Logger.getLogger( JTableUtil.class.getName() );

	private JTableUtil() {
	}

	private static void logEntry( String methodName ) {
		logger.logp( Level.FINEST, JTableUtil.class.getName(), methodName, "[method entry]" );
	}

	public static void configureTable( final JTable table, DefaultTableModel model ) {
		logEntry( "void configureTable( JTable, DefaultTableModel )" );

		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

		if( model != null ) {
			table.setModel( model );
		}

		//table.setDefaultRenderer( Date.class, new DateTableCellRenderer() );

		// performance hint from: http://www.chka.de/swing/table/faq.html
		//ToolTipManager.sharedInstance().unregisterComponent( table );
		//ToolTipManager.sharedInstance().unregisterComponent( table.getTableHeader() );
	}

	private static int[] calculateColumnWidths( JTable table ) {
		logEntry( "int[] calculateColumnWidths( JTable )" );

		int[] colWidths = new int[table.getColumnCount()];

		for(int colIdx=0; colIdx < table.getColumnCount(); colIdx++) {
			// get the next column
			TableColumn col = table.getColumnModel().getColumn( colIdx );

			// figurer out what is the current header preferred colWidth
			TableCellRenderer colRenderer = col.getHeaderRenderer();
			if (colRenderer == null) {
				colRenderer = table.getTableHeader().getDefaultRenderer();
			}

			Component colRendererComp = colRenderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0 );
			int colWidth = colRendererComp.getPreferredSize().width;

			// find the preferred colWidth for the new rows/cells that were added
			for(int rowIdx=0; rowIdx < table.getModel().getRowCount(); rowIdx++) {
				TableCellRenderer cellRenderer = table.getCellRenderer( rowIdx, colIdx );
				Component cellRendererComp = cellRenderer.getTableCellRendererComponent(
					table, table.getValueAt(rowIdx,colIdx), false, false, rowIdx, colIdx );

				// compare those preferred widths to the header preferred colWidth
				colWidth = Math.max( colWidth, cellRendererComp.getPreferredSize().width );
			}

			// add in the margins
			colWidth += 2 * JTABLE_CELL_MARGIN;

			// set the preferred width for the entire column
			colWidths[colIdx] = colWidth;
		}

		return colWidths;
	}

	public static void resizeTableColumnsToFit( JTable table ) {
		logEntry( "void resizeTableColumnsToFit( JTable )" );

		int[] colWidths = calculateColumnWidths( table );

		for(int colIdx=0; colIdx < table.getColumnCount(); colIdx++) {
			// get the next column
			TableColumn col = table.getColumnModel().getColumn( colIdx );

			// set the preferred width for the entire column
			col.setPreferredWidth( colWidths[colIdx] );
		}
	}

	public static void resizeTableColumnsToFit( JTable table1, JTable table2 ) {
		logEntry( "void resizeTableColumnsToFit( JTable, JTable )" );

		int[] colWidths1 = calculateColumnWidths( table1 );
		int[] colWidths2 = calculateColumnWidths( table2 );
		int colCount = Math.max( colWidths1.length, colWidths2.length );

		for(int colIdx=0; colIdx < colCount; colIdx++) {
			int width = Math.max(
				( ( colIdx < colWidths1.length ) ? colWidths1[colIdx] : 0 ),
				( ( colIdx < colWidths2.length ) ? colWidths2[colIdx] : 0 )
			);

			if( colIdx < table1.getColumnCount() ) {
				TableColumn col = table1.getColumnModel().getColumn( colIdx );
				col.setPreferredWidth( width );
			}
			if( colIdx < table2.getColumnCount() ) {
				TableColumn col = table2.getColumnModel().getColumn( colIdx );
				col.setPreferredWidth( width );
			}
		}
	}

	/*public static void configureTableRowHeaders( JScrollPane scrollPane, JTable rowHeaderTable ) {
		scrollPane.setRowHeaderView( rowHeaderTable );

		int rowHeaderWidth = 0;
		for(int i=0; i < rowHeaderTable.getColumnCount(); i++) {
			int colWidth = rowHeaderTable.getColumnModel().getColumn( i ).getPreferredWidth();
			rowHeaderWidth += colWidth;
		}

		int rowHeaderHeight = (int) scrollPane.getPreferredSize().getHeight();

		scrollPane.getRowHeader().setPreferredSize(
			new Dimension( rowHeaderWidth, rowHeaderHeight )
		);

		JComponent jc = (JComponent) scrollPane.getViewport().getView();

		if( ( jc != null ) && ( jc instanceof JTable ) ) {
			JTable dataTable = (JTable) jc;
			Selecting.syncSelection( dataTable, rowHeaderTable );
		}
	}*/

	private static final int JTABLE_CELL_MARGIN = 5;

}
