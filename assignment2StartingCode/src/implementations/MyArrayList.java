package implementations;

import utilities.Iterator;
import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E>{

	//attributes
	private static final  int  CAPACITY = 10;
	private E[] array;	
	//the size, the actual numbers of elements is 0
	private int size;
	
	//default constructor
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[CAPACITY];
	}
	
	//constructor
	
	
	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index > size || index<0) throw new IndexOutOfBoundsException();
		if(toAdd == null) throw new NullPointerException();
		checkCapacity();
		shiftToRight(index);
		array[index] = toAdd;
		size++;
		
		
		return true;
	}

	private void shiftToRight(int index) {
		// TODO Auto-generated method stub
		for(int i = array.length-1; i>index;i--) {
			array[i] = array[i-1];
		}
		
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if( toAdd == null) {
			throw new NullPointerException();
		}
		//check capacity
		checkCapacity();
		array[size] = toAdd;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void checkCapacity() {
		if(size == array.length) {
			E[] newArray = (E[]) new Object[CAPACITY*2];
			//copy old array to the new 
			for(int i = 0; i< array.length; i++) {
				newArray[i] = array[i];
			}
//			the attribute points to the new array
			array = newArray;
		}
		
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd)
			throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange)
			throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
