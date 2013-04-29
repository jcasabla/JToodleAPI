/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import jtoodle.api.test.util.FullDateTableCellRenderer;
import jtoodle.api.test.util.JTableUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import jtoodle.api.auth.AuthExceptionHandler;
import jtoodle.api.bean.core.Task;
import jtoodle.api.bean.core.TaskQueryResult;
import jtoodle.api.bean.core.DeletionResult;
import jtoodle.api.bean.util.JToodleException;
import jtoodle.api.json.bean.BeanWriter;
import jtoodle.api.request.web.TaskAddCriteria;
import jtoodle.api.request.web.TaskDeletionCriteria;
import jtoodle.api.request.web.TaskOperations;
import jtoodle.api.request.web.TaskSearchCriteria;
import jtoodle.api.request.web.TaskUpdateCriteria;
import jtoodle.api.util.NullSafe;
import org.openide.util.Exceptions;

/**
 *
 * @author Justo_Casablanca
 */
public class TasksPanel extends javax.swing.JPanel {

	private static final Logger logger = Logger.getLogger( TasksPanel.class.getName() );

	/** Creates new form TasksPanel */
	public TasksPanel() {
		initComponents();
		initComponents2();
	}

	private void initComponents2() {
		completionComboBox.removeAllItems();
		completionComboBox.addItem( TaskSearchCriteria.CompletionCriteria.All_Tasks );
		completionComboBox.addItem( TaskSearchCriteria.CompletionCriteria.Completed_Tasks_Only );
		completionComboBox.addItem( TaskSearchCriteria.CompletionCriteria.Uncompleted_Tasks_Only );

		taskQueryResult.setTasks( new ArrayList<Task>() );

		tasksTable.setDefaultRenderer( Date.class, new FullDateTableCellRenderer() );
		tasksTable.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
			@Override
			public void valueChanged( ListSelectionEvent e ) {
				if( ( tasksTable.getSelectedRows() != null ) &&
					( tasksTable.getSelectedRows().length > 0 ) )
				{
					deleteTasksButton.setEnabled( true );
				} else {
					deleteTasksButton.setEnabled( false );
				}
			}
		});
		tasksTable.getModel().addTableModelListener( new TableModelListener() {
			@Override
			public void tableChanged( TableModelEvent e ) {
				logger.log(  Level.INFO,
							 "tableChanged, TableModelEvent[type={0},firstRow={1},lastRow={2}]",
							 new Object[] { ( e.getType() == TableModelEvent.INSERT ) ? "INSERT" :
											( e.getType() == TableModelEvent.UPDATE ) ? "UPDATE" :
											( e.getType() == TableModelEvent.DELETE ) ? "DELETE" :
											"OTHER:" + e.getType(),
											e.getFirstRow(), e.getLastRow() } );

				// BUGFIX: If TableModelEvent.DELETE, the last row will already
				// have been removed from taskQueryResult.getTasks(), and there-
				// fore the code below:
				//
				//      Task t = taskQueryResult.getTasks().get( e.getFirstRow() );
				//
				// ... will produce a ConcurrentModificationException

				if( ( e.getFirstRow() == e.getLastRow() ) &&
					( e.getType() != TableModelEvent.DELETE ) )
				{
					Task t = taskQueryResult.getTasks().get( e.getFirstRow() );
					logger.log(  Level.INFO, "Task.id={0}", new Object[] { t.getId() } );

					switch( e.getType() ) {
						case TableModelEvent.INSERT: {
							if( t.getId() == null ) {
								newTasks.add( t );
								logger.log(  Level.INFO, "newTasks.size={0}", new Object[] { newTasks.size() } );
							}
							break;
						}
						case TableModelEvent.UPDATE: {
							if( t.getId() != null ) {
								editedTasks.add( t );
								logger.log(  Level.INFO, "editedTasks.size={0}", new Object[] { editedTasks.size() } );
							}
							break;
						}
					} // switch

					saveTasksButton.setEnabled(
							!NullSafe.isNullOrEmpty( newTasks )
							|| !NullSafe.isNullOrEmpty( editedTasks ) );

					JTableUtil.configureTable( tasksTable, null );
					JTableUtil.resizeTableColumnsToFit( tasksTable );
				} // if

				saveToFileButton.setEnabled(
						!NullSafe.isNullOrEmpty( taskQueryResult.getTasks() ) );
			} // tableChanged
		});

		JTableUtil.configureTable( tasksTable, null );
		JTableUtil.resizeTableColumnsToFit( tasksTable );
	}

	private Set<Task> newTasks = new HashSet<>();

	private Set<Task> editedTasks = new HashSet<>();

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        taskQueryResult = new jtoodle.api.test.util.BindableTaskQueryResult();
        startDateLabel = new javax.swing.JLabel();
        startDatePicker = new org.jdesktop.swingx.JXDatePicker();
        taskIdLabel = new javax.swing.JLabel();
        taskIdTextField = new javax.swing.JFormattedTextField();
        endDateLabel = new javax.swing.JLabel();
        endDatePicker = new org.jdesktop.swingx.JXDatePicker();
        rowStartLabel = new javax.swing.JLabel();
        rowStartTextField = new javax.swing.JFormattedTextField();
        clearSearchutton = new javax.swing.JButton();
        completionLabel = new javax.swing.JLabel();
        completionComboBox = new javax.swing.JComboBox();
        numRowsLabel = new javax.swing.JLabel();
        numRowsTextField = new javax.swing.JFormattedTextField();
        searchButton = new javax.swing.JButton();
        tasksInResultLabel = new javax.swing.JLabel();
        tasksInResultTextField = new javax.swing.JTextField();
        tasksInPageLabel = new javax.swing.JLabel();
        tasksInPageTextField = new javax.swing.JTextField();
        tasksScrollPane = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        deleteTasksButton = new javax.swing.JButton();
        saveTasksButton = new javax.swing.JButton();
        newTaskButton = new javax.swing.JButton();
        saveToFileButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(startDateLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.startDateLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(taskIdLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.taskIdLabel.text")); // NOI18N

        taskIdTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        org.openide.awt.Mnemonics.setLocalizedText(endDateLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.endDateLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(rowStartLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.rowStartLabel.text")); // NOI18N

        rowStartTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        org.openide.awt.Mnemonics.setLocalizedText(clearSearchutton, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.clearSearchutton.text")); // NOI18N
        clearSearchutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSearchuttonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(completionLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.completionLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(numRowsLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.numRowsLabel.text")); // NOI18N

        numRowsTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        org.openide.awt.Mnemonics.setLocalizedText(searchButton, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.searchButton.text")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(tasksInResultLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.tasksInResultLabel.text")); // NOI18N

        tasksInResultTextField.setEditable(false);
        tasksInResultTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, taskQueryResult, org.jdesktop.beansbinding.ELProperty.create("${queryTaskCount}"), tasksInResultTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.openide.awt.Mnemonics.setLocalizedText(tasksInPageLabel, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.tasksInPageLabel.text")); // NOI18N

        tasksInPageTextField.setEditable(false);
        tasksInPageTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, taskQueryResult, org.jdesktop.beansbinding.ELProperty.create("${totalTaskCount}"), tasksInPageTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${tasks}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, taskQueryResult, eLProperty, tasksTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${title}"));
        columnBinding.setColumnName("Title");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priority}"));
        columnBinding.setColumnName("Priority");
        columnBinding.setColumnClass(jtoodle.api.json.enums.Priority.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${starred}"));
        columnBinding.setColumnName("Starred");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${parentTaskId}"));
        columnBinding.setColumnName("Parent Task Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${childTaskCount}"));
        columnBinding.setColumnName("Child Task Count");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${childTaskOrder}"));
        columnBinding.setColumnName("Child Task Order");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${addedOn}"));
        columnBinding.setColumnName("Added On");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${modifiedOn}"));
        columnBinding.setColumnName("Modified On");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${folderId}"));
        columnBinding.setColumnName("Folder Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${goalId}"));
        columnBinding.setColumnName("Goal Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${locationId}"));
        columnBinding.setColumnName("Location Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contextId}"));
        columnBinding.setColumnName("Context Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(jtoodle.api.json.enums.Status.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${repeatPattern}"));
        columnBinding.setColumnName("Repeat Pattern");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${repeatsFrom}"));
        columnBinding.setColumnName("Repeats From");
        columnBinding.setColumnClass(jtoodle.api.json.enums.TaskRepeatsFrom.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dueDate}"));
        columnBinding.setColumnName("Due Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dueDateModifier}"));
        columnBinding.setColumnName("Due Date Modifier");
        columnBinding.setColumnClass(jtoodle.api.json.enums.DueDateModifier.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dueTime}"));
        columnBinding.setColumnName("Due Time");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${startDate}"));
        columnBinding.setColumnName("Start Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${startTime}"));
        columnBinding.setColumnName("Start Time");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${timerStartedOn}"));
        columnBinding.setColumnName("Timer Started On");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${timerSecondsElapsed}"));
        columnBinding.setColumnName("Timer Seconds Elapsed");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${minutesToComplete}"));
        columnBinding.setColumnName("Minutes To Complete");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${reminderMinutes}"));
        columnBinding.setColumnName("Reminder Minutes");
        columnBinding.setColumnClass(jtoodle.api.json.enums.ReminderTime.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${completedOn}"));
        columnBinding.setColumnName("Completed On");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${meta}"));
        columnBinding.setColumnName("Meta");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${note}"));
        columnBinding.setColumnName("Note");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tag}"));
        columnBinding.setColumnName("Tag");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tasksScrollPane.setViewportView(tasksTable);

        org.openide.awt.Mnemonics.setLocalizedText(deleteTasksButton, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.deleteTasksButton.text")); // NOI18N
        deleteTasksButton.setEnabled(false);
        deleteTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTasksButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(saveTasksButton, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.saveTasksButton.text")); // NOI18N
        saveTasksButton.setEnabled(false);
        saveTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTasksButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(newTaskButton, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.newTaskButton.text")); // NOI18N
        newTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(saveToFileButton, org.openide.util.NbBundle.getMessage(TasksPanel.class, "TasksPanel.saveToFileButton.text")); // NOI18N
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
                    .addComponent(tasksScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveToFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newTaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveTasksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTasksButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endDateLabel)
                            .addComponent(completionLabel)
                            .addComponent(startDateLabel)
                            .addComponent(tasksInResultLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tasksInResultTextField)
                                .addGap(3, 3, 3))
                            .addComponent(startDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDatePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(completionComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(taskIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13))
                                .addComponent(rowStartLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(numRowsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tasksInPageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taskIdTextField)
                            .addComponent(rowStartTextField)
                            .addComponent(numRowsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(tasksInPageTextField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearSearchutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(startDateLabel)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taskIdLabel)
                    .addComponent(taskIdTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel)
                    .addComponent(rowStartLabel)
                    .addComponent(rowStartTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearSearchutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(completionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completionLabel)
                    .addComponent(numRowsLabel)
                    .addComponent(numRowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tasksInResultLabel)
                    .addComponent(tasksInResultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tasksInPageLabel)
                    .addComponent(tasksInPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tasksScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteTasksButton)
                    .addComponent(saveTasksButton)
                    .addComponent(newTaskButton)
                    .addComponent(saveToFileButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void clearSearchuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSearchuttonActionPerformed
		logger.entering( getClass().getSimpleName(), "clearSearchuttonActionPerformed" );

		startDatePicker.setDate( null );
        endDatePicker.setDate( null );
        completionComboBox.setSelectedItem( TaskSearchCriteria.CompletionCriteria.All_Tasks );
        taskIdTextField.setText( null );
        rowStartTextField.setText( null );
        numRowsTextField.setText( null );
        taskQueryResult.clearTasks();

		newTasks.clear();
		editedTasks.clear();

		JTableUtil.configureTable( tasksTable, null );
		JTableUtil.resizeTableColumnsToFit( tasksTable );
    }//GEN-LAST:event_clearSearchuttonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
		logger.entering( getClass().getSimpleName(), "searchButtonActionPerformed" );

		try {
			newTasks.clear();
			editedTasks.clear();

            TaskSearchCriteria searchOptions = new TaskSearchCriteria();

            searchOptions.setStartDate( startDatePicker.getDate() );
            searchOptions.setEndDate( endDatePicker.getDate() );

            searchOptions.setCompletionCriteria(
                (TaskSearchCriteria.CompletionCriteria)
                completionComboBox.getSelectedItem() );

            if( ! NullSafe.isNullOrEmpty( taskIdTextField.getText() ) ) {
                searchOptions.setTaskId( Integer.parseInt( taskIdTextField.getText() ) );
            }
            if( ! NullSafe.isNullOrEmpty( rowStartTextField.getText() ) ) {
                searchOptions.setPaginationRowStart( Integer.parseInt( rowStartTextField.getText() ) );
            }
            if( ! NullSafe.isNullOrEmpty( numRowsTextField.getText() ) ) {
                searchOptions.setPaginationNumTasks( Integer.parseInt( numRowsTextField.getText() ) );
            }

            TaskOperations taskOps = new TaskOperations();
            taskOps.setOperationCriteria( searchOptions );

            List<Task> results = taskOps.search();
            TaskQueryResult tqResult = TaskQueryResult.createTaskQueryResult(
                results.size(), results.size()
            );

            tqResult.setTasks( results );
            taskQueryResult.updateProperties( tqResult );

            logger.log( Level.INFO, "TaskQueryResult.totalTaskCount={0}", taskQueryResult.getTotalTaskCount() );
            logger.log( Level.INFO, "TaskQueryResult.queryTaskCount={0}", taskQueryResult.getQueryTaskCount() );
            logger.log( Level.INFO, "TaskQueryResult.tasks.size={0}", taskQueryResult.getTasks().size() );
        } catch( IOException | JToodleException ex ) {
            logger.log( Level.SEVERE, null, ex );

            if( AuthExceptionHandler.handledInvalidKey( this, ex ) ) {
                searchButtonActionPerformed( null );
            }
        } finally {
			JTableUtil.configureTable( tasksTable, null );
			JTableUtil.resizeTableColumnsToFit( tasksTable );
		}
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTasksButtonActionPerformed
		logger.entering( getClass().getSimpleName(), "deleteTasksButtonActionPerformed" );

		List<Task> webTasks = new ArrayList<>();
		List<Task> localTasks = new ArrayList<>();

        int[] rowIdx = tasksTable.getSelectedRows();

        for( int idx : rowIdx ) {
			Task nTask = taskQueryResult.getTasks().get( idx );

			if( nTask.getId() == null ) {
				localTasks.add( nTask );
			} else {
				webTasks.add( nTask );
			}
        }

		if( !NullSafe.isNullOrEmpty( webTasks ) ) {
			TaskDeletionCriteria delC = new TaskDeletionCriteria();
			delC.setTasks( webTasks );

			TaskOperations taskOps = new TaskOperations();
			taskOps.setOperationCriteria( delC );

			try {
				List<DeletionResult> dr = taskOps.delete();
				taskQueryResult.removeTasks( webTasks );

				for( DeletionResult result : dr ) {
					logger.log( Level.INFO, "Task deleted, id={0}",
								new String[] { result.getId().toString() } );
				}

				JOptionPane.showMessageDialog( this, "Deleted " + dr.size() + " tasks" );
			} catch( IOException | JToodleException ex ) {
				logger.log( Level.SEVERE, null, ex );
			} finally {
				JTableUtil.configureTable( tasksTable, null );
				JTableUtil.resizeTableColumnsToFit( tasksTable );
			}
		}

		taskQueryResult.removeTasks( localTasks );
    }//GEN-LAST:event_deleteTasksButtonActionPerformed

    private void newTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTaskButtonActionPerformed
		logger.entering( getClass().getSimpleName(), "newTaskButtonActionPerformed" );
		taskQueryResult.addTask( new Task() );
    }//GEN-LAST:event_newTaskButtonActionPerformed

    private void saveTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTasksButtonActionPerformed
		logger.entering( getClass().getSimpleName(), "saveTasksButtonActionPerformed" );

		if( !NullSafe.isNullOrEmpty( newTasks ) ) {
			logger.log( Level.INFO, "need to create {0} new tasks", new Object[] { newTasks.size() } );

			try {
				List<Task> tempTasks = new ArrayList<>( newTasks );

				TaskAddCriteria tac = new TaskAddCriteria();
				tac.setTasks( tempTasks );

				TaskOperations taskOps = new TaskOperations();
				taskOps.setOperationCriteria( tac );
				List<Task> savedTasks = taskOps.create();

				taskQueryResult.removeTasks( tempTasks );
				taskQueryResult.addTasks( savedTasks );
				newTasks.clear();
			} catch( JsonProcessingException ex ) {
				Exceptions.printStackTrace( ex );
			} catch( IOException | JToodleException ex ) {
				Exceptions.printStackTrace( ex );
			}
		}

		if( !NullSafe.isNullOrEmpty( editedTasks ) ) {
			logger.log( Level.INFO, "need to update {0} modified tasks", new Object[] { editedTasks.size() } );

			try {
				List<Task> tempTasks = new ArrayList<>( editedTasks );

				TaskUpdateCriteria tuc = new TaskUpdateCriteria();
				tuc.setTasks( tempTasks );

				TaskOperations taskOps = new TaskOperations();
				taskOps.setOperationCriteria( tuc );
				List<Task> updatedTasks = taskOps.update();

				taskQueryResult.removeTasks( tempTasks );
				taskQueryResult.addTasks( updatedTasks );
				editedTasks.clear();
			} catch( JsonProcessingException ex ) {
				Exceptions.printStackTrace( ex );
			} catch( IOException | JToodleException ex ) {
				Exceptions.printStackTrace( ex );
			}
		}
    }//GEN-LAST:event_saveTasksButtonActionPerformed

    private void saveToFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToFileButtonActionPerformed
		final JFileChooser fc = new JFileChooser();
		int rv = fc.showSaveDialog( this );

		switch( rv ) {
			case JFileChooser.APPROVE_OPTION: {
				try {
					BeanWriter.writeObjectList( fc.getSelectedFile(), taskQueryResult.getTasks() );
				} catch( IOException ex ) {
					Exceptions.printStackTrace( ex );
				}
				break;
			}
		}
    }//GEN-LAST:event_saveToFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearSearchutton;
    private javax.swing.JComboBox completionComboBox;
    private javax.swing.JLabel completionLabel;
    private javax.swing.JButton deleteTasksButton;
    private javax.swing.JLabel endDateLabel;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton newTaskButton;
    private javax.swing.JLabel numRowsLabel;
    private javax.swing.JFormattedTextField numRowsTextField;
    private javax.swing.JLabel rowStartLabel;
    private javax.swing.JFormattedTextField rowStartTextField;
    private javax.swing.JButton saveTasksButton;
    private javax.swing.JButton saveToFileButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel startDateLabel;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JLabel taskIdLabel;
    private javax.swing.JFormattedTextField taskIdTextField;
    private jtoodle.api.test.util.BindableTaskQueryResult taskQueryResult;
    private javax.swing.JLabel tasksInPageLabel;
    private javax.swing.JTextField tasksInPageTextField;
    private javax.swing.JLabel tasksInResultLabel;
    private javax.swing.JTextField tasksInResultTextField;
    private javax.swing.JScrollPane tasksScrollPane;
    private javax.swing.JTable tasksTable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
