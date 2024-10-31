package app;

/**
 * Created on August 23, 2019
 *
 * @author kitty
 * @version 1.2
 */

import school.Program;
import school.UntypedCourse;
import school.Course;
import people.ITSStudent;
import people.SDStudent;

public class Driver
{

	public static void main( String[] args )
	{
		UntypedCourse rc = new UntypedCourse( "Untyped Course" );
		
		SDStudent link = new SDStudent( "Link" );
		SDStudent zelda = new SDStudent( "Zelda" );
		ITSStudent ganon = new ITSStudent( "Ganon" );
		
		rc.addStudent( link );
		rc.addStudent( zelda );
		// the following is allowed because RawCourse allows any type of student and
		// generates no errors or warnings
		rc.addStudent( ganon );
		rc.printStudentList();

		Program<Course<SDStudent>> SD = new Program<>( "SD" );
		Program<Course<ITSStudent>> ITS = new Program<>( "ITS" );

		Course<SDStudent> cprg304 = new Course<>( "CPRG304" );
		Course<SDStudent> cprg307 = new Course<>( "CPRG307" );
		Course<ITSStudent> cmps254 = new Course<>( "CMPS254" );

		SD.addCourse( cprg304 );
		SD.addCourse( cprg307 );
		// the following is not allowed due to program only allowing course of SD
		// students
		SD.addCourse( cmps254 );
		ITS.addCourse( cmps254 );

		cprg304.addStudent( link );
		cprg304.addStudent( zelda );
		// the following is not allowed due to course only allowing SD students
		cprg304.addStudent( ganon );
		cmps254.addStudent( ganon );

		// these generate an unchecked warning for raw types and allows for any
		// student to be added to the course
		Course rawCourse = new Course( "Raw Course" );
		rawCourse.addStudent( link );
		rawCourse.addStudent( ganon );

		// these generate an unchecked warning for raw types and allows for any
		// course to be added to the program
		Program rawProgram = new Program( "Raw Program" );
		rawProgram.addCourse( cprg304 );
		rawProgram.addCourse( cmps254 );
		rawProgram.addCourse( rawCourse );

		Program<Course> halfRaw = new Program<>( "Half Raw" );
		halfRaw.addCourse( cprg304 ); // no warning?!?!
		halfRaw.addCourse( cmps254 ); // no warning?!?!

	}

}
