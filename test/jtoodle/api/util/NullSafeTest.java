/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author justo_casablanca
 */
public class NullSafeTest {
	
	public NullSafeTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of equals method, of class NullSafe.
	 */
	@Test
	public void testEquals() {
		System.out.println( "equals" );

		testEquals( null, null, true );

		testEquals( 1, null, false );
		testEquals( null, 1, false );
		testEquals( 1, 1, true );
		testEquals( 1, 2, false );

		testEquals( "", null, false );
		testEquals( null, "", false );
		testEquals( "xyz", "xyz", true );
		testEquals( "abc", "xyz", false );
	}

	private void testEquals( Object o1, Object o2, boolean expResult ) {
		System.out.println( "equals - " +
							"o1=" + o1 + ", " +
							"o2=" + o2 + ", " +
							"expResult=" + expResult );								
		boolean result = NullSafe.equals( o1, o2 );
		assertEquals( expResult, result );
	}

	/**
	 * Test of isNullOrEmpty method, of class NullSafe.
	 */
	@Test
	public void testIsNullOrEmpty_String() {
		System.out.println( "isNullOrEmpty" );

		testIsNullOrEmpty_String( null, true );
		testIsNullOrEmpty_String( "", true );
		testIsNullOrEmpty_String( " ", true );
		testIsNullOrEmpty_String( " ".trim(), true );
		testIsNullOrEmpty_String( "-!@#$".trim(), false );
	}
	
	private void testIsNullOrEmpty_String( String s, boolean expResult ) {
		System.out.println( "isNullOrEmpty - " +
							"s=[" + s + "], " +
							"expResult=" + expResult );
		boolean result = NullSafe.isNullOrEmpty( s );
		assertEquals( expResult, result );
	}

	/**
	 * Test of isNullOrEmpty method, of class NullSafe.
	 */
	//@Test
	public void testIsNullOrEmpty_Collection() {
		System.out.println( "isNullOrEmpty" );
		Collection c = null;
		boolean expResult = false;
		boolean result = NullSafe.isNullOrEmpty( c );
		assertEquals( expResult, result );
		// TODO review the generated test code and remove the default call to fail.
		fail( "The test case is a prototype." );
	}
	
}