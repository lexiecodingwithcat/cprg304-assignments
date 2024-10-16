/**
 * 
 */
package utilities;

import java.util.Comparator;

import shapes.Shape;

/**
 * 
 */
public class VolumeComparator implements Comparator<Shape>{

	@Override
	public int compare(Shape s1, Shape s2) {
		if(s1.calcVolume() > s2.calcVolume()) return 1;
		if(s1.calcVolume() < s2.calcVolume()) return -1;
		return 0;
	}

}
