/**
 * 
 */
package utilities;

import java.util.Comparator;

import exercise1.Student;

/**
 * 
 */
public class AgeComparator implements Comparator <Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getAge() > s2.getAge()) {
			return 1;
		}if(s1.getAge()<s2.getAge()) {
			return -1;
		}else {
		  return s1.getName().compareToIgnoreCase(s2.getName());
		}
		
		
	}
	

}
