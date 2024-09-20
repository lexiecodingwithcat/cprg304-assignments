/**
 * Created on May 31, 2011 Modified on September 30, 2013 Project:
 * demo00-ComplexityAnalysisOfStringConcatenation
 */
package complexityStrings;

/**
 * Concat.java
 *
 * @author dwatson, kitty
 * @version 1.1 
 * 
 * Class Definition: Class to demonstrate the performance
 *          differences between String, StringBuffer and StringBuilder when
 *          appending characters to a string.
 */
public class Concat
{
	
	//static makes only one copy and share it with other instances of the current class
	//final means the variable is immutable
	public static final int TEST_SIZE = 10000;

	// Attributes
	//class-level attributes have default values
	//but local attributes must be initialized within methods
	private String str = ""; //null
//	StringBuffer: It is thread-safe. 
//All its methods are synchronized, meaning multiple threads can safely use a StringBuffer object without causing inconsistent results. 
//This makes StringBuffer slightly slower due to the overhead of synchronization.
//	StringBuilder: It is not thread-safe. 
//It does not use synchronized methods, which makes it faster than StringBuffer, but it is not safe to use in a multi-threaded environment.
	private StringBuffer sBuf;
	private StringBuilder sBuild;
	private int size;

	// Constructors-- default
	public Concat()
	{}

	/**
	 * @param size
	 */
	public Concat( int size )
	{
		this.size = size;
	}

	// Operational Methods
	/**
	 * Concats characters to a String object.
	 * 
	 * @return the time required to perform this operation.
	 */
	
	//it is a instance method that must be used by invoking an instance
	//if it is a static method, it can be accessed by class without invoking an instance
	public long stringTime()
	{
		char letter;
		int i;
		long start, stop;

		start = System.currentTimeMillis();

		for( letter = 'a', i = 0; i < size; i++, letter++ )
		{
			str = str + letter;//null + a  --> 
			//nulla not what we want so we initialize the letter to "" empty string
			if( i % 25 == 0 )
			{
				letter = 'a';
			}
		}
		stop = System.currentTimeMillis();
		return stop - start;
	}

	/**
	 * Concats characters to a StringBuffer object.
	 * 
	 * @return the time required to perform this operation.
	 */
	public long stringBufferTime()
	{
		char letter;
		int i;
		long start, stop;
		//the value currently is 0 but it has capacity to store 10000
		sBuf = new StringBuffer( size );

		start = System.currentTimeMillis();

		for( letter = 'a', i = 0; i < size; i++, letter++ )
		{
			sBuf.append( letter );
			if( i % 25 == 0 )
			{
				letter = 'a';
			}
		}
		stop = System.currentTimeMillis();
		return stop - start;
	}

	/**
	 * Concats characters to a StringBuilder object.
	 * 
	 * @return the time required to perform this operation.
	 */
	public long stringBuilderTime()
	{
		char letter;
		int i;
		long start, stop;
		sBuild = new StringBuilder( size );

		start = System.currentTimeMillis();

		for( letter = 'a', i = 0; i < size; i++, letter++ )
		{
			sBuild.append( letter );
			if( i % 25 == 0 )
			{
				letter = 'a';
			}
		}
		stop = System.currentTimeMillis();
		return stop - start;
	}

	/**
	 * Main to run application
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		Concat cs = new Concat( TEST_SIZE );

		System.out.println( "This is time for string: " + cs.stringTime() );
		System.out.println( "This is time for StringBuffer: " + cs.stringBufferTime() );
		System.out.println( "This is time for StringBuilder: " + cs.stringBuilderTime() );
	}
}
