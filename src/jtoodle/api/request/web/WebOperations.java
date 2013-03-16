/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.request.web;

import java.io.IOException;
import java.util.List;
import jtoodle.api.beans.AbstractJToodleBean;
import jtoodle.api.beans.DeletionResult;
import jtoodle.api.beans.JToodleException;

/**
 *
 * @author Justo_Casablanca
 */
public interface WebOperations <T extends AbstractJToodleBean> {

	public static final String BASE_URI = "https://api.toodledo.com/2";

	public List<T> search() throws IOException, JToodleException;

	public DeletionResult delete() throws IOException, JToodleException;

	public List<T> create() throws IOException, JToodleException;

	public List<T> update() throws IOException, JToodleException;

}
