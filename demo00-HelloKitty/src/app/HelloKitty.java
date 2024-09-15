package app;
//import official package first
import java.util.Date;
//import the package we wrote
import utilities.GrabUserName;

/**
 * This is Kitty's version of Hello World!
 * 
 * @author kitty
 */
//we can only have one public class
public class HelloKitty
{
	//string is not the primitive data type
	//"final" means it is a constant
	//private is only accessible inside this class
	//static means all instances share the same user_name variable
	private static final String USER_NAME = "Kitty";

	/*
	 * arrays can be declared in 2 ways in Java! C# only uses the first approach and
	 * is considered easier to read, the second approach is backwards compatible
	 * with C/C++
	 */

	// array declaration 1
	public static void main( String[] args )
	{
		/*
		 * the main method is the entry point in both Java and C# except in Java it's
		 * lowercase 'm' instead of uppercase 'M'. (This is because all methods in Java
		 * starts with lowercase)
		 */

		// array declaration 2
		// public static void main( String args[] ) {
		/*
		 * there's no real consensus in where this curly brace should be Oracle says
		 * "east coast" but many professionals use "west coast"
		 */
		
		//if the data type is not primitive, it is an object reference
		GrabUserName newUser = new GrabUserName();
		String name = newUser.getTheName();

		if( name.equals( "" ) )
		{
			name = USER_NAME;
		}

		System.out.println( "Hello " + name + "! " + new Date() );
	}

}