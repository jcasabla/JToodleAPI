/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

/**
 *
 * @author justo
 */
public class JToodleException extends IllegalArgumentException {

	public JToodleException( Integer errorCode, String errorDescription ) {
		super( errorDescription );
		this.errorCode = errorCode;
	}

	private Integer errorCode;

	public Integer getErrorCode() {
		return( errorCode );
	}

}
