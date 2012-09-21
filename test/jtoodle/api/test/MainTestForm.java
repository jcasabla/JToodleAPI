/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test;

import java.awt.Component;
import java.beans.IntrospectionException;
import java.beans.PropertyEditorManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import jtoodle.api.auth.AuthCache;
import jtoodle.api.beans.AccountInfo;
import jtoodle.api.beans.Folder;
import jtoodle.api.beans.JToodleException;
import jtoodle.api.beans.Task;
import jtoodle.api.request.GetAccountInfo;
import jtoodle.api.request.GetFolders;
import jtoodle.api.request.GetTasks;
import jtoodle.api.util.NullSafe;
import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.auth.LoginService;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Node;

/**
 *
 * @author Justo_Casablanca
 */
public class MainTestForm extends javax.swing.JFrame {

	private static final Logger logger = Logger.getLogger( MainTestForm.class.getName() );

    /**
     * Creates new form MainTestForm
     */
    public MainTestForm() {
        initComponents();
		initComponents2();
    }

	private void initComponents2() {
		PropertyEditorManager.registerEditor(Date.class, DatePropertyEditor.class);

		beanResultsComboBox.setRenderer( new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent( JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
				if( value == null ) {
					setText( "<null value>" );
				} else if( value instanceof Folder ) {
					setText( ((Folder)value).getName() );
				} else if( value instanceof Task ) {
					setText( ((Task)value).getTitle() );
				} else {
					setText( value.toString() );
				}
				return this;
			}
		});
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        authenticationPanel = new javax.swing.JPanel();
        userIdLabel = new javax.swing.JLabel();
        userIdTextField = new javax.swing.JTextField();
        tokenLabel = new javax.swing.JLabel();
        tokenTextField = new javax.swing.JTextField();
        apiKeyLabel = new javax.swing.JLabel();
        apiKeyTextField = new javax.swing.JTextField();
        errorTypeLabel = new javax.swing.JLabel();
        errorTypeTextField = new javax.swing.JTextField();
        errorCodeLabel = new javax.swing.JLabel();
        errorCodeTextField = new javax.swing.JTextField();
        errorDescLabel = new javax.swing.JLabel();
        errorDescPane = new javax.swing.JScrollPane();
        errorDescTextArea = new javax.swing.JTextArea();
        accountInfoPanel = new javax.swing.JPanel();
        accountInfoButton = new javax.swing.JButton();
        accountInfoPropertySheet = new org.openide.explorer.propertysheet.PropertySheet();
        othersPanel = new javax.swing.JPanel();
        beanTypeComboBox = new javax.swing.JComboBox();
        beanResultsComboBox = new javax.swing.JComboBox();
        beanPropertySheet = new org.openide.explorer.propertysheet.PropertySheet();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loginMenuItem = new javax.swing.JMenuItem();
        logoutMenuItem = new javax.swing.JMenuItem();
        exitSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userIdLabel.setLabelFor(userIdTextField);
        userIdLabel.setText("User Id:");

        userIdTextField.setEditable(false);

        tokenLabel.setLabelFor(tokenTextField);
        tokenLabel.setText("Token:");

        tokenTextField.setEditable(false);

        apiKeyLabel.setText("API Key:");

        apiKeyTextField.setEditable(false);

        errorTypeLabel.setText("Error Type:");

        errorCodeLabel.setLabelFor(errorCodeTextField);
        errorCodeLabel.setText("Error Code:");

        errorCodeTextField.setEditable(false);

        errorDescLabel.setLabelFor(errorDescPane);
        errorDescLabel.setText("<html>\nError<br>Description:\n</html>");
        errorDescLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        errorDescTextArea.setEditable(false);
        errorDescTextArea.setColumns(20);
        errorDescTextArea.setRows(5);
        errorDescPane.setViewportView(errorDescTextArea);

        javax.swing.GroupLayout authenticationPanelLayout = new javax.swing.GroupLayout(authenticationPanel);
        authenticationPanel.setLayout(authenticationPanelLayout);
        authenticationPanelLayout.setHorizontalGroup(
            authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authenticationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(authenticationPanelLayout.createSequentialGroup()
                        .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIdLabel)
                            .addComponent(tokenLabel)
                            .addComponent(apiKeyLabel))
                        .addGap(37, 37, 37)
                        .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tokenTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(userIdTextField)
                            .addComponent(apiKeyTextField)))
                    .addGroup(authenticationPanelLayout.createSequentialGroup()
                        .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorTypeTextField)
                            .addComponent(errorCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, authenticationPanelLayout.createSequentialGroup()
                        .addComponent(errorDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorDescPane, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        authenticationPanelLayout.setVerticalGroup(
            authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authenticationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tokenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apiKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apiKeyLabel))
                .addGap(39, 39, 39)
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorCodeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(authenticationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorDescPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Authentication", authenticationPanel);

        accountInfoButton.setText("Account Info");
        accountInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountInfoPanelLayout = new javax.swing.GroupLayout(accountInfoPanel);
        accountInfoPanel.setLayout(accountInfoPanelLayout);
        accountInfoPanelLayout.setHorizontalGroup(
            accountInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountInfoPanelLayout.createSequentialGroup()
                        .addComponent(accountInfoButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(accountInfoPropertySheet, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                .addContainerGap())
        );
        accountInfoPanelLayout.setVerticalGroup(
            accountInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountInfoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountInfoPropertySheet, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Account Info", accountInfoPanel);

        beanTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Choose>", "Folders", "Tasks" }));
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

        javax.swing.GroupLayout othersPanelLayout = new javax.swing.GroupLayout(othersPanel);
        othersPanel.setLayout(othersPanelLayout);
        othersPanelLayout.setHorizontalGroup(
            othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, othersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(beanPropertySheet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(othersPanelLayout.createSequentialGroup()
                        .addComponent(beanTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(beanResultsComboBox, 0, 448, Short.MAX_VALUE)))
                .addContainerGap())
        );
        othersPanelLayout.setVerticalGroup(
            othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(othersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beanResultsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beanTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(beanPropertySheet, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPane.addTab("Others", othersPanel);

        fileMenu.setText("File");

        loginMenuItem.setText("Login");
        loginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loginMenuItem);

        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenuItem);
        fileMenu.add(exitSeparator);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void accountInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountInfoButtonActionPerformed
		try {
			AccountInfo bean = new GetAccountInfo().requestBean();
			accountInfoPropertySheet.setNodes( new Node[] { new BeanNode( bean ) } );
		} catch( IntrospectionException | IOException | JToodleException ex ) {
			logger.log( Level.SEVERE, null, ex );
			try {
				accountInfoPropertySheet.setNodes( new Node[] { new BeanNode( ex ) } );
			} catch( IntrospectionException ex1 ) {
				logger.log( Level.SEVERE, null, ex1 );
			}
		}
    }//GEN-LAST:event_accountInfoButtonActionPerformed

    private void loginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuItemActionPerformed
		JXLoginPane.Status status = JXLoginPane.showLoginDialog( this, new LoginService() {
			@Override
			public boolean authenticate( String name, char[] password, String server ) {
				errorCodeTextField.setText( null );
				errorDescTextArea.setText( null );

				try {
					AuthCache.login( name, new String( password ) );

					userIdTextField.setText( AuthCache.getUserId() );
					tokenTextField.setText( AuthCache.getToken() );
					apiKeyTextField.setText( AuthCache.getApiKey() );

					return( true );
				} catch( JToodleException jte ) {
					errorTypeTextField.setText( jte.getClass().getName() );
					errorCodeTextField.setText( "" + jte.getErrorCode() );
					errorDescTextArea.setText( jte.getMessage() );

					logger.log( Level.SEVERE, null, jte );
					return( false );
				} catch( Exception ex ) {
					errorTypeTextField.setText( ex.getClass().getName() );
					errorCodeTextField.setText( "N/A" );
					errorDescTextArea.setText( ex.getMessage() );

					logger.log( Level.SEVERE, null, ex );
					return( false );
				}
			}
		} );
    }//GEN-LAST:event_loginMenuItemActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        int yn = JOptionPane.showConfirmDialog( this, "Are you sure you want to logout ?" );

		if( yn == JOptionPane.OK_OPTION ) {
			AuthCache.logout();
		}
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void beanResultsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beanResultsComboBoxActionPerformed
		try {
			if( beanResultsComboBox.getSelectedItem() == null ) {
				beanPropertySheet.setNodes( new Node[] {} );
			} else {
				beanPropertySheet.setNodes( new Node[] {
					new BeanNode( beanResultsComboBox.getSelectedItem() )
				});
			}
		} catch( IntrospectionException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}
    }//GEN-LAST:event_beanResultsComboBoxActionPerformed

    private void beanTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beanTypeComboBoxActionPerformed
		beanResultsComboBox.removeAllItems();
		beanPropertySheet.setNodes( new Node[] {} );

		try {
			List beanList = null;

			switch( beanTypeComboBox.getSelectedItem().toString() ) {
				case "Folders": {
					beanList = new GetFolders().requestBeanList();
					break;
				}
				case "Tasks": {
					beanList = new GetTasks().requestBeanList();
					break;
				}
				default:
			}

			if( !NullSafe.isNullOrEmpty( beanList ) ) {
				for( Object o: beanList ) {
					beanResultsComboBox.addItem( o );
				}
			} else {
				beanResultsComboBox.addItem(
					"<no results for: " + beanTypeComboBox.getSelectedItem() + ">" );
			}

			beanResultsComboBoxActionPerformed( null );

		} catch( IOException | JToodleException ex ) {
			logger.log( Level.SEVERE, null, ex );
			try {
				beanResultsComboBox.addItem( ex );
				beanPropertySheet.setNodes( new Node[] { new BeanNode( ex ) } );
			} catch( IntrospectionException ex1 ) {
				logger.log( Level.SEVERE, null, ex1 );
			}
		}
    }//GEN-LAST:event_beanTypeComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
		try {
			/* Create and display the form */
			java.awt.EventQueue.invokeAndWait( new Runnable() {
				@Override
				public void run() {
					new MainTestForm().setVisible(true);
				}
			});
		} catch( InterruptedException | InvocationTargetException ex ) {
			logger.log( Level.SEVERE, null, ex );
		}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountInfoButton;
    private javax.swing.JPanel accountInfoPanel;
    private org.openide.explorer.propertysheet.PropertySheet accountInfoPropertySheet;
    private javax.swing.JLabel apiKeyLabel;
    private javax.swing.JTextField apiKeyTextField;
    private javax.swing.JPanel authenticationPanel;
    private org.openide.explorer.propertysheet.PropertySheet beanPropertySheet;
    private javax.swing.JComboBox beanResultsComboBox;
    private javax.swing.JComboBox beanTypeComboBox;
    private javax.swing.JLabel errorCodeLabel;
    private javax.swing.JTextField errorCodeTextField;
    private javax.swing.JLabel errorDescLabel;
    private javax.swing.JScrollPane errorDescPane;
    private javax.swing.JTextArea errorDescTextArea;
    private javax.swing.JLabel errorTypeLabel;
    private javax.swing.JTextField errorTypeTextField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator exitSeparator;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem loginMenuItem;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel othersPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel tokenLabel;
    private javax.swing.JTextField tokenTextField;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JTextField userIdTextField;
    // End of variables declaration//GEN-END:variables
}
