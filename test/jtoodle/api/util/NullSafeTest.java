/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author justo_casablanca
 */
public class NullSafeTest {

	private static final Logger logger =
			Logger.getLogger( NullSafeTest.class.getName() );

	//@BeforeClass
	//public static void setUpClass() {
	//}
	
	//@AfterClass
	//public static void tearDownClass() {
	//}
	
	//@Before
	//public void setUp() {
	//}
	
	//@After
	//public void tearDown() {
	//}

	/**
	 * Test of equals method, of class NullSafe.
	 */
	@Test
	public void testEquals() {
		logger.log( Level.INFO, "" );
		logger.log( Level.INFO, "equals(Object,Object)" );

		assertTrue( "failure: null == null", NullSafe.equals( null, null ) );
		assertFalse( "failure: 1 != null", NullSafe.equals( 1, null ) );
		assertFalse( "failure: null != 1", NullSafe.equals( null, 1 ) );
		assertFalse( "failure: \"\" != null", NullSafe.equals( "", null ) );
		assertFalse( "failure: null != \"\"", NullSafe.equals( null, "" ) );

		assertTrue( "failure: 1 == 1", NullSafe.equals( 1, 1 ) );
		assertFalse( "failure: 1 != 2", NullSafe.equals( 1, 2 ) );

		assertTrue( "failure: \"xyz\" == \"xyz\"",
					NullSafe.equals( "xyz", "xyz" ) );
		assertFalse( "failure: \"abc\" != \"xyz\"",
					 NullSafe.equals( "abc", "xyz" ) );
	}

	/**
	 * Test of isNullOrEmpty method, of class NullSafe.
	 */
	@Test
	public void testIsNullOrEmptyString() {
		logger.log( Level.INFO, "" );
		logger.log( Level.INFO, "isNullOrEmpty(String)" );

		assertTrue( "failure - null should be considered empty",
					NullSafe.isNullOrEmpty( (String) null ) );
		assertTrue( "failure - 0-length string should be considered empty",
					NullSafe.isNullOrEmpty( "" ) );
		assertTrue( "failure - all-spaces string should be considered empty",
					NullSafe.isNullOrEmpty( " " ) );
		assertFalse( "failure - \"-!@#$\" should not be considered empty",
					 NullSafe.isNullOrEmpty( "-!@#$" ) );
		assertFalse( "failure - \" ab cd \" should not be considered empty",
					 NullSafe.isNullOrEmpty( " ab cd " ) );
	}
	
	/**
	 * Test of isNullOrEmpty method, of class NullSafe.
	 */
	@Test
	public void testIsNullOrEmptyCollection() {
		logger.log( Level.INFO, "" );
		logger.log( Level.INFO, "isNullOrEmpty(Collection)" );

		assertTrue( "failure: null collection is empty",
					NullSafe.isNullOrEmpty( (Collection) null ) );
		assertTrue( "failure: Collections.emptyList() is empty",
					NullSafe.isNullOrEmpty( Collections.emptyList() ) );

		List l = new ArrayList();

		l.add( Boolean.FALSE );
		assertFalse( "failure: Collection not empty after call to .add( Boolean.FALSE )",
					 NullSafe.isNullOrEmpty( l ) );

		l.clear();
		assertTrue( "failure: Collection is empty after call to .clear()",
					NullSafe.isNullOrEmpty( l ) );
	}
	
}