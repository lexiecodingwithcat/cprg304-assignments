package exercise1;

import java.util.ArrayList;
import java.util.Collections;

import utilities.AgeComparator;


public class Driver
{

	public static void main( String[] args )
	{

		ArrayList<Student> studs = new ArrayList<>();
		studs.add( new Student( "Smith", 34 ) );
		studs.add( new Student( "Johnson", 21 ) );
		studs.add( new Student( "Williams", 67 ) );
		studs.add( new Student( "Brown", 53 ) );
		studs.add( new Student( "Jones", 48 ) );
		studs.add( new Student( "Miller", 36 ) );
		studs.add( new Student( "Davis", 44 ) );
		studs.add( new Student( "Wilson", 52 ) );
		studs.add( new Student( "Anderson", 34 ) );
		studs.add( new Student( "Moore", 33 ) );

		AgeComparator ac = new AgeComparator();
		System.out.println("before:");
		System.out.println( studs );
		//sort the students by name
		System.out.println("after:");
		Collections.sort(studs);
		//sort the students by age
		Collections.sort(studs, ac);
		System.out.println( studs );
	}

}
