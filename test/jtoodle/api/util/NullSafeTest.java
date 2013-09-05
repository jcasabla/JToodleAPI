/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtoodle.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
		System.out.println();
		System.out.println( "equals(Object,Object)" );

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
							"o1=[" + o1 + "], " +
							"o2=[" + o2 + "], " +
							"expResult=" + expResult );								
		boolean result = NullSafe.equals( o1, o2 );
		assertEquals( expResult, result );
	}

	/**
	 * Test of isNullOrEmpty method, of class NullSafe.
	 */
	@Test
	public void testIsNullOrEmpty_String() {
		System.out.println();
		System.out.println( "isNullOrEmpty(String)" );

		testIsNullOrEmpty_String( null, true );
		testIsNullOrEmpty_String( "", true );
		testIsNullOrEmpty_String( " ", true );
		testIsNullOrEmpty_String( "-!@#$", false );
		testIsNullOrEmpty_String( " ab cd ", false );
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
	@Test
	public void testIsNullOrEmpty_Collection() {
		System.out.println();
		System.out.println( "isNullOrEmpty(Collection)" );

		testIsNullOrEmpty_Collection( null, true );
		testIsNullOrEmpty_Collection( Collections.emptyList(), true );

		List l = new ArrayList();

		l.add( Boolean.FALSE );
		testIsNullOrEmpty_Collection( l, false );		

		l.clear();
		testIsNullOrEmpty_Collection( l, true );		
	}
	
	private void testIsNullOrEmpty_Collection( Collection c, boolean expResult ) {
		System.out.println( "isNullOrEmpty - " +
							"c=[" + c + "], " +
							"expResult=" + expResult );
		boolean result = NullSafe.isNullOrEmpty( c );
		assertEquals( expResult, result );
	}
}