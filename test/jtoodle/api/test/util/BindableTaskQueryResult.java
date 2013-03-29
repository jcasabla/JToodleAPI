/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test.util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import jtoodle.api.bean.core.Task;
import jtoodle.api.bean.core.TaskQueryResult;
import jtoodle.api.util.NullSafe;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author justo
 */
public class BindableTaskQueryResult extends TaskQueryResult {

	public BindableTaskQueryResult() {
		super( 0, 0 );
	}

	@Override
	public void setTasks( List<Task> tasks ) {
		List<Task> oldTasks = getTasks();

		if( tasks instanceof ObservableList ) {
			super.setTasks( tasks );
		} else {
			super.setTasks( ObservableCollections.observableList( tasks ) );
		}

		pcs.firePropertyChange( "tasks", oldTasks, getTasks() );
	}

	public void addTask( Task aTask ) {
		if( getTasks() == null ) {
			setTasks( new ArrayList<Task>() );
		}
		getTasks().add( aTask );
	}

	public void removeTasks( List<Task> taskList ) {
		if( ! NullSafe.isNullOrEmpty( getTasks() ) ) {
			getTasks().removeAll( taskList );
		}
	}

	public void clearTasks() {
		if( ! NullSafe.isNullOrEmpty( getTasks() ) ) {
			getTasks().clear();
		}
	}

	public void updateProperties( TaskQueryResult result ) {
		setQueryTaskCount( result.getQueryTaskCount() );
		pcs.firePropertyChange( "queryTaskCount", null, getQueryTaskCount() );

		setTotalTaskCount( result.getTotalTaskCount() );
		pcs.firePropertyChange( "totalTaskCount", null, getTotalTaskCount() );

		setTasks( result.getTasks() );
	}

	private final PropertyChangeSupport pcs = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		this.pcs.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		this.pcs.removePropertyChangeListener( listener );
	}

}
