package utilities;

import java.util.Scanner;

/*public class GrabUserName extends Object{
 the constructor: 
 public GradUserName(){
 by default it will call the constructor in the super class
 super();
 } 
} */
//do not write void or any other data type in constructor
public class GrabUserName extends Object
{

	public String getTheName()
	{
		System.out.println( "What is your name?" );
		Scanner keyboardInput = new Scanner( System.in );
		String userName = keyboardInput.nextLine();
		return userName;
	}

}
