package utilities;

/**
 * Created on August 21, 2019 Modified on October 17, 2023
 *
 * @author kitty
 * @version 1.2
 */

import java.util.Comparator;

public final class KittySort
{
	// any guesses on what sorting algorithm this is? :D
	public static <T> void someSort( Comparable<T>[] array )
	{
		while( !isSorted( array, null ) )
		{
			randomize( array );
		}
	}
	
	public static <T> void someSort( Comparable<T>[] array, Comparator<? super T> comp )
	{
		while( !isSorted( array, comp ) )
		{
			randomize( array );
		}
	}

	private static <T> void randomize( Comparable<T>[] array )
	{
		for( int i = 0; i < array.length; i++ )
		{
			swapElements( array, i, (int) Math.floor( Math.random() * i + 1 ) );
		}
	}

	private static <T> void swapElements( Comparable<T>[] array, int i, int j )
	{
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

//	@SuppressWarnings( "unchecked" )
	private static <T> boolean isSorted( Comparable<T>[] array, Comparator<? super T> comp )
	{
		for( int i = 0; i < array.length - 1; i++ )
		{
			// this unchecked cast is safe because all the elements have already
			// been type checked when they were added to the list, thus the warning 
			// can not ignored or suppress warning can be used
			if( comp == null )
			{
				if( ( (Comparable<T>) array[i] ).compareTo( (T) array[i + 1] ) > 0 )
				{
					return false;
				}
			}
			else
			{
				if( comp.compare( (T) array[i], (T) array[i + 1] ) > 0 )
				{
					return false;
				}
			}
		}
		return true;
	}
}
