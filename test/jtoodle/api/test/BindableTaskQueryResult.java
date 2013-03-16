/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import jtoodle.api.bean.core.TaskQueryResult;

/**
 *
 * @author justo
 */
public class BindableTaskQueryResult extends TaskQueryResult {

	public BindableTaskQueryResult() {
		super( 0, 0 );
	}

	public void updateProperties( TaskQueryResult result ) {
		setQueryTaskCount( result.getQueryTaskCount() );
		pcs.firePropertyChange( "queryTaskCount", null, getQueryTaskCount() );

		setTotalTaskCount( result.getTotalTaskCount() );
		pcs.firePropertyChange( "totalTaskCount", null, getTotalTaskCount() );

		setTasks( result.getTasks() );
		pcs.firePropertyChange( "tasks", null, getTasks() );
	}

	private final PropertyChangeSupport pcs = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		this.pcs.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		this.pcs.removePropertyChangeListener( listener );
	}

}
