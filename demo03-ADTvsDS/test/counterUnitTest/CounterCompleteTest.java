/**
 * ANNOTATIONS:
 * 
 * @Test - The annotation @Test identifies that a method is a test method.
 * @Ignore - Will ignore the test method. This is useful when the underlying
 *         code has been changed and the test case has not yet been adapted. Or
 *         if the execution time of this test is too long to be
 *         included. @Test(expected=Exception.class) - Fails, if the method does
 *         not throw the named exception. @Test(timeout=100) - Fails, if the
 *         method takes longer than 100 milliseconds. ASSERTS: [] = optional
 *         message to display fail([String]) - Let the method fail. Might be
 *         used to check that a certain part of the code is not reached. Or to
 *         have failing test before the test code is implemented.
 *         assertTrue(boolean) - Will always be true/false. Can be used to
 *         predefine a test result, if the test is not yet implemented.
 *         assertTrue([String], boolean condition) - Checks that the boolean
 *         condition is true. assertsEquals([String], expected, actual) - Tests
 *         that two values are the same. Note: for arrays the reference is
 *         checked not the content of the arrays. assertsEquals([String],
 *         expected, actual, tolerance) - Test that float or double values
 *         match. The tolerance is the number of decimals which must be the
 *         same. assertNull([String], object) - Checks that the object is null.
 *         assertNotNull([String], object) - Checks that the object is not null.
 *         assertSame([String], expected, actual) - Checks that both variables
 *         refer to the same object. assertNotSame([String], expected, actual) -
 *         Checks that both variables refer to different objects. For a list of
 *         all test classes - check out http://junit.org/javadoc/latest/
 */
package counterUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import counterADT.CounterComplete;
import counterADT.InvalidCounterException;

/**
 * @author kitty
 */
public class CounterCompleteTest
{
	// test objects
	CounterComplete one;
	static CounterComplete zero;

	/**
	 * @BeforeClass - Will execute the method once, before the start of all tests.
	 *              This can be used to perform time intensive activities, for
	 *              example to connect to a database.
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		zero = new CounterComplete( 0 );
	}

	/**
	 * @AfterClass - Will execute the method once, after all tests have finished.
	 *             This can be used to perform clean-up activities, for example to
	 *             disconnect from a database.
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		zero = null;
	}

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		one = new CounterComplete( 1 );
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		one = null;
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#createCounter()}.
	 * @throws InvalidCounterException 
	 */
	@Test
	public void testCreateCounterDefault() 
	{
		int expected = 0;
		CounterComplete c;
		try
		{
			c = new CounterComplete();
			int actual = c.getCounter();
			assertEquals( "Constructor did not create the correct counter value.", expected, actual );
		}
		catch( InvalidCounterException e )
		{
			fail( "CreateCounter should not throw InvalidCounterException." );
		}
		
	}
	
	/**
	 * Test method for {@link counterADT.CounterComplete#createCounter()}.
	 * @throws InvalidCounterException 
	 */
	@Test
	public void testCreateCounterValidValue() throws InvalidCounterException
	{
		int expected = 5;
		CounterComplete c;
		try
		{
			c = new CounterComplete(5);
			int actual = c.getCounter();
			assertEquals( "Constructor did not create the correct counter value.", expected, actual );
		}
		catch( InvalidCounterException e )
		{
			fail( "CreateCounter should not throw InvalidCounterException." );
		}
	}
	
	/**
	 * Test method for {@link counterADT.CounterComplete#createCounter()}.
	 */
	@Test
	// @Test(expected = InvalidCounterException.class) is another way to specify
	// an expected exception to be thrown but it will pass test no matter where
	// it's thrown! Thus you can't use it to pinpoint the exact line of code
	// where the exception is expected
	public void testCreateCounterInvalidValue()
	{
		CounterComplete c;
		try
		{
			c = new CounterComplete(-5);
			fail( "CreateCounter did not throw InvalidCounterException correctly." );
		}
		catch( InvalidCounterException e )
		{
			// do nothing and the test will pass
			// or return; 
			// or assertTrue(true); 
		}
	}
	
	/**
	 * Test method for {@link counterADT.CounterComplete#getCounter()}.
	 */
	@Test
	public void testGetCounter()
	{
		int expected = 1;
		int actual = one.getCounter();
		assertEquals( "GetCounter method did not return the correct counter value.", expected, actual );
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#setCounter(int)}.
	 * 
	 * @throws InvalidCounterException
	 */
	@Test
	public void testSetCounterNonnegative()
	{
		int expected = 5;
		try
		{
			one.setCounter( 5 );
		}
		catch( InvalidCounterException e )
		{
			fail( "SetCounter throws InvalidCounterException incorrectly." );
		}
		int actual = one.getCounter();
		assertEquals( "SetCounter method did not set the counter value correctly.", expected, actual );
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#setCounter(int)}.
	 * 
	 * @throws InvalidCounterException
	 */
	@Test
	public void testSetCounterBoundaryZero()
	{
		int expected = 0;
		try
		{
			one.setCounter( 0 );
		}
		catch( InvalidCounterException e )
		{
			fail( "SetCounter throws InvalidCounterException incorrectly." );
		}
		int actual = one.getCounter();
		assertEquals( "SetCounter method did not set the counter value correctly.", expected, actual );
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#setCounter(int)}.
	 * 
	 * @throws InvalidCounterException
	 */
	@Test
	public void testSetCounterNegative()
	{
		try
		{
			one.setCounter( -1 );
			fail( "SetCounter failed to throw InvalidCounterException." );
		}
		catch( InvalidCounterException e )
		{
			// do nothing and the test will pass
			return; 
			// or assertTrue(true); 
		}
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#incCounter()}.
	 */
	@Test
	public void testIncCounter()
	{
		int expected = 2;
		one.incCounter();
		int actual = one.getCounter();
		assertEquals( "IncCounter method did not increment the counter value correctly.", expected, actual );
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#decCounter()}.
	 * 
	 * @throws InvalidCounterException
	 */
	@Test
	public void testDecCounterNonZero()
	{
		int expected = 0;
		try
		{
			one.decCounter();
		}
		catch( InvalidCounterException e )
		{
			fail( "DecCounter throws InvalidCounterException incorrectly." );
		}
		int actual = one.getCounter();
		assertEquals( "DecCounter method did not decrement the counter value correctly.", expected, actual );
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#decCounter()}.
	 * 
	 * @throws InvalidCounterException
	 */
	@Test
	public void testDecCounterZero()
	{
		try
		{
			zero.decCounter();
			fail( "DecCounter failed to throw InvalidCounterException." );
		}
		catch( InvalidCounterException e )
		{
			// do nothing and the test will pass
			// or return; 
			assertTrue(true); 
		}
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#isZero()}.
	 */
	@Test
	public void testIsZero()
	{
		boolean actual = true;
		boolean expected = zero.isZero();
		assertEquals( "IsZero method did not check zero value correctly.", expected, actual );
	}

	/**
	 * Test method for {@link counterADT.CounterComplete#isZero()}.
	 */
	@Test
	public void testIsNotZero()
	{
		boolean actual = false;
		boolean expected = one.isZero();
		assertEquals( "IsZero method did not check zero value correctly.", expected, actual );
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString()
	{
		// unless you write some complex regex, this will be a manual visual verification
		System.out.println( one.toString() );
	}

}
