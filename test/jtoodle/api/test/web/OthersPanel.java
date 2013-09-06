/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test.web;

import java.awt.Component;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import jtoodle.api.auth.AuthExceptionHandler;
import jtoodle.api.bean.core.AbstractCoreBean;
import jtoodle.api.bean.core.DeletionResult;
import jtoodle.api.bean.core.Folder;
import jtoodle.api.bean.util.JToodleException;
import jtoodle.api.json.bean.BeanWriter;
import jtoodle.api.request.web.FolderAddCriteria;
import jtoodle.api.request.web.FolderDeletionCriteria;
import jtoodle.api.request.web.FolderOperations;
import jtoodle.api.request.web.FolderUpdateCriteria;
import jtoodle.api.util.NullSafe;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author Justo_Casablanca
 */
public class OthersPanel extends javax.swing.JPanel {

	private static final Logger logger = Logger.getLogger( OthersPanel.class.getName() );

	/** Creates new form OthersPanel */
	public OthersPanel() {
		initComponents();
		initComponents2();
	}

	private void initComponents2() {
		beanResultsComboBox.setRenderer( new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent( JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
				if( value == null ) {
					setText( "<null value>" );
				} else if( value instanceof Folder ) {
					setText( ((Folder)value).getName() );
				} else {
					setText( value.toString() );
				}
				return( this );
			}
		});
	}

	private void deleteFolder( Folder folder ) {
		FolderDeletionCriteria fdc = new FolderDeletionCriteria();
		fdc.setFolder( folder );

		FolderOperations folderOps = new FolderOperations();
		folderOps.setOperationCriteria( fdc );

		try {
			DeletionResult reply = folderOps.deleteSingle();
			JOptionPane.showMessageDialog( this, "Deleted folder: " + reply.getId() );
		} catch( IOException | JToodleException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beanTypeComboBox = new javax.swing.JComboBox();
        beanResultsComboBox = new javax.swing.JComboBox();
        deleteBeanButton = new javax.swing.JButton();
        beanPropertySheet = new org.openide.explorer.propertysheet.PropertySheet();
        saveBeanButton = new javax.swing.JButton();
        saveToFileButton = new javax.swing.JButton();

        beanTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Choose>", "Folders", "Contexts", "Goals", "Locations" }));
        beanTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beanTypeComboBoxActionPerformed(evt);
            }
        });

        beanResultsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beanResultsComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteBeanButton, org.openide.util.NbBundle.getMessage(OthersPanel.class, "OthersPanel.deleteBeanButton.text")); // NOI18N
        deleteBeanButton.setEnabled(false);
        deleteBeanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBeanButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(saveBeanButton, org.openide.util.NbBundle.getMessage(OthersPanel.class, "OthersPanel.saveBeanButton.text")); // NOI18N
        saveBeanButton.setEnabled(false);
        saveBeanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBeanButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(saveToFileButton, org.openide.util.NbBundle.getMessage(OthersPanel.class, "OthersPanel.saveToFileButton.text")); // NOI18N
        saveToFileButton.setEnabled(false);
        saveToFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(beanPropertySheet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(beanTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(beanResultsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveToFileButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveBeanButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteBeanButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beanResultsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beanTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBeanButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBeanButton)
                    .addComponent(saveToFileButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(beanPropertySheet, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void beanTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beanTypeComboBoxActionPerformed
		deleteBeanButton.setEnabled( false );
		saveBeanButton.setEnabled( false );
		saveToFileButton.setEnabled( false );

		beanResultsComboBox.removeAllItems();
		beanPropertySheet.setNodes( new Node[] {} );

		try {
			List beanList = null;

			switch( beanTypeComboBox.getSelectedItem().toString() ) {
				case "Folders": {
					FolderOperations folderOps = new FolderOperations();
					beanList = folderOps.search();

					Folder f = new Folder();
					f.setName( "<select here to add new Folder>" );
					beanList.add( f );

					break;
				}
				case "Contexts": {
					JOptionPane.showMessageDialog(
							this.getRootPane(),
							"This function is not yet available" );
					break;
				}
				case "Goals": {
					JOptionPane.showMessageDialog(
							this.getRootPane(),
							"This function is not yet available" );
					break;
				}
				case "Locations": {
					JOptionPane.showMessageDialog(
							this.getRootPane(),
							"This function is not yet available" );
					break;
				}
				default: {
					break;
				}
			}

			if( ! NullSafe.isNullOrEmpty( beanList ) ) {
				for( Object o : beanList ) {
					beanResultsComboBox.addItem( o );
				}
			}

			beanResultsComboBoxActionPerformed( null );

			saveToFileButton.setEnabled( beanResultsComboBox.getItemCount() > 1 );

		} catch( IOException | JToodleException ex ) {
			logger.log( Level.SEVERE, null, ex );
			try {
				deleteBeanButton.setEnabled( false );
				beanResultsComboBox.addItem( ex );
				beanPropertySheet.setNodes( new Node[] { new BeanNode( ex ) } );
			} catch( IntrospectionException ex1 ) {
				logger.log( Level.SEVERE, null, ex1 );
			}

			if( AuthExceptionHandler.handledInvalidKey( this, ex ) ) {
				beanTypeComboBoxActionPerformed( null );
			}
		}
    }//GEN-LAST:event_beanTypeComboBoxActionPerformed

    private void beanResultsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beanResultsComboBoxActionPerformed
		try {
			AbstractCoreBean bean = (AbstractCoreBean) beanResultsComboBox.getSelectedItem();

			if( bean != null ) {
				beanPropertySheet.setNodes( new Node[] { new BeanNode( bean ) } );
				deleteBeanButton.setEnabled( bean.getId() != null );
				saveBeanButton.setEnabled( true );
			}
		} catch( IntrospectionException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}
    }//GEN-LAST:event_beanResultsComboBoxActionPerformed

    private void deleteBeanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBeanButtonActionPerformed
		Object bean = beanResultsComboBox.getSelectedItem();

		if( bean instanceof Folder ) {
			deleteFolder( (Folder) bean );
		} else {
			JOptionPane.showMessageDialog(
					this,
					"This function is not yet available",
					null,
					JOptionPane.WARNING_MESSAGE );
		}

		beanTypeComboBoxActionPerformed( null );
    }//GEN-LAST:event_deleteBeanButtonActionPerformed

    private void saveBeanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBeanButtonActionPerformed
		switch( beanTypeComboBox.getSelectedItem().toString() ) {
			case "Folders": {
				Folder f = (Folder) beanResultsComboBox.getSelectedItem();
				f = saveOrUpdateFolder( f );

				beanTypeComboBoxActionPerformed( null );

				for(int i=0; i < beanResultsComboBox.getItemCount(); i++) {
					Folder f2 = (Folder) beanResultsComboBox.getItemAt( i );
					if( f2.getId().equals(  f.getId() ) ) {
						beanResultsComboBox.setSelectedIndex( i );
						break;
					}
				}
					
				break;
			}
			case "Contexts": {
				JOptionPane.showMessageDialog(
						this.getRootPane(),
						"This function is not yet available" );
				break;
			}
			case "Goals": {
				JOptionPane.showMessageDialog(
						this.getRootPane(),
						"This function is not yet available" );
				break;
			}
			case "Locations": {
				JOptionPane.showMessageDialog(
						this.getRootPane(),
						"This function is not yet available" );
				break;
			}
			default: {
				break;
			}
		}

		saveBeanButton.setEnabled( false );
    }//GEN-LAST:event_saveBeanButtonActionPerformed

    private void saveToFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToFileButtonActionPerformed
		final JFileChooser fc = new JFileChooser();
		int rv = fc.showSaveDialog( this );

		switch( rv ) {
			case JFileChooser.APPROVE_OPTION: {
				try {
					List<Object> l = new ArrayList<>();
					for(int i=0; i < beanResultsComboBox.getItemCount()-1; i++) {
						l.add( beanResultsComboBox.getItemAt( i ) );
					}
					BeanWriter.writeObjectList( fc.getSelectedFile(), l );
				} catch( IOException ex ) {
					Exceptions.printStackTrace( ex );
				}
				break;
			}
		}
    }//GEN-LAST:event_saveToFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.propertysheet.PropertySheet beanPropertySheet;
    private javax.swing.JComboBox beanResultsComboBox;
    private javax.swing.JComboBox beanTypeComboBox;
    private javax.swing.JButton deleteBeanButton;
    private javax.swing.JButton saveBeanButton;
    private javax.swing.JButton saveToFileButton;
    // End of variables declaration//GEN-END:variables

	private Folder saveOrUpdateFolder( Folder aFolder ) {
		boolean add = ( aFolder.getId() == null );
		FolderOperations.OperationCriteria<Folder> oc;

		if( add ) {
			FolderAddCriteria fac = new FolderAddCriteria();
			fac.setFolder( aFolder );
			oc = fac;
		} else {
			FolderUpdateCriteria fuc = new FolderUpdateCriteria();
			fuc.setFolder( aFolder );
			oc = fuc;
		}
				
		FolderOperations folderOps = new FolderOperations();
		folderOps.setOperationCriteria( oc );

		try {
			List<Folder> folders = add ? folderOps.create() : folderOps.update();

			if( !NullSafe.isNullOrEmpty( folders ) ) {
				aFolder = folders.get( 0 );
				JOptionPane.showMessageDialog(
						this.getRootPane(),
						"Folder " + ( add ? "created" : "updated" ) + ": " + aFolder.getId() );
			}
		} catch( IOException | JToodleException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}

		return( aFolder );
	}

}
