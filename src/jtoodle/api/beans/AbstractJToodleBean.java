/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.beans;

/**
 *
 * @author justo
 */
public class AbstractJToodleBean {

	private Integer errorCode;

	private String errorDescription;

	public Integer getErrorCode() {
		return( errorCode );
	}

	public void setErrorCode( Integer errorCode ) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return( errorDescription );
	}

	public void setErrorDescription( String errorDescription ) {
		this.errorDescription = errorDescription;
	}

	public boolean hasError() {
		return( errorCode != null );
	}

	public void throwException() {
		throw new JToodleException( getErrorCode(), getErrorDescription() );
	}

}
