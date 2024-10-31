package convertErrors;

import java.util.ArrayList;

public class RuntimeToCompileTime
{

	public static void main( String args[] )
	{
		// runtime error using raw types (not defining a type)
		ArrayList stuff = new ArrayList();
		stuff.add( "Kitty" );
		stuff.add( 28 );
		
		for( int i = 0; i < stuff.size(); i++ )
		{
			String name = (String) stuff.get( i );
			Integer age = (Integer) stuff.get( i );
		}
		
		if( stuff.get( 0 ).equals( stuff.get( 1 ) ) )
		{
			// what the heck are we comparing and why???
		}

		// compile time error if we give a type to the constructor
		//before run we could see it from the editor
		ArrayList<String> names = new ArrayList<>();
		names.add( "Kitty" );
		names.add(28);

	}

}
