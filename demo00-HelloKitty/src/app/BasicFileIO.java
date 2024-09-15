package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BasicFileIO
{

	public static void main( String[] args ) 
	{
// we should write relative path
		File inputFile = new File( "res/sampleInput.txt" );
//		File inputFile = new File( "sampleInput.txt" );
		Scanner input = null;
	
		try
		{
			input = new Scanner( inputFile );
		}
		//if there is no catch block, it will pass upper until JVM
		catch( FileNotFoundException e )
		{
			
			e.printStackTrace();
		}

		while( input.hasNext() )
		{
			String name = input.next();
			//it prints the name and move the cursor to the next line
			System.out.println( name );

			String phoneNumber = input.next();
			System.out.println( phoneNumber );

			double amount = input.nextDouble();
			System.out.println( amount );
		}

	}

}
