package implementations;


import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

@SuppressWarnings("serial")
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

	
	@Override
	public void clear() {
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index > size || index< 0) throw new IndexOutOfBoundsException();
		if(toAdd == null) throw new NullPointerException();
		checkCapacity();
		shiftToRight(index);
		array[index] = toAdd;
		size++;
		return true;
	}
	private void shiftToRight(int index) {
		// TODO Auto-generated method stub
		for(int i = size; i>index;i--) {
			array[i] = array[i-1];
		}
		
	}
	@SuppressWarnings("unchecked")
	private void checkCapacity() {
		if(size == array.length) {
			E[] newArray = (E[]) new Object[array.length*2];
			//copy old array to the new 
			for(int i = 0; i< array.length; i++) {
				newArray[i] = array[i];
			}
			//the attribute points to the new array
			array = newArray;
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

	
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null) throw new NullPointerException();
		checkCapacity();
		for(int i = 0; i<toAdd.size();i++) {
			array[size] = toAdd.get(i);
			size++;
			
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index >= size || index<0) throw new IndexOutOfBoundsException();
		
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index<0 || index >= size) throw new IndexOutOfBoundsException();
		if(size>0) {
			E element = array[index];
			shiftToLeft(index);
			size--;
			return element;
		}
		return null;
	}
	private void shiftToLeft(int index) {
		for(int i=index; i<size-1;i++) {
			array[i] = array[i+1];
		}
		//set the last element to null
		array[size-1] = null;
		
	}
	
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) throw new NullPointerException();
		for(int i =0; i<size; i++) {
			if(array[i].equals(toRemove) ) {
				E removedElement = array[i];
				shiftToLeft(i);
				size --;
				return removedElement;	
			}
		}
		return null;
	}

	@Override
	public E set(int index, E toChange)throws NullPointerException, IndexOutOfBoundsException {
		if(toChange == null) throw new NullPointerException();
		if(index<0 || index>=size)throw new IndexOutOfBoundsException();
		E prevElement = array[index];
		array[index] = toChange;
		return prevElement;
	}

	@Override
	public boolean isEmpty() {
	
		return size==0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
	if(toFind == null) throw new NullPointerException();
	for(int i =0; i<size; i++) {
		if(array[i].equals(toFind)) {
			return true;
		}
	}
		return false;
	}

	//copy current array into toHold
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) throw new NullPointerException();
		if(size>toHold.length) {
//			E[] newArr = (E[])new Object[size];
			toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
		}
		System.arraycopy(array, 0, toHold, 0, size);
		return toHold;
	}

	
	@Override
	public Object[] toArray() {
		Object[] newArr = new Object[size];
		System.arraycopy(array, 0, newArr, 0, size);
	
		return newArr;
	}

	@Override
	public Iterator<E> iterator() {
		
		//anonymous class
		return new Iterator<E>(){
			private int currentIndex = 0;
			@Override
			public boolean hasNext() {
				return currentIndex<size;
			}

			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
				E element = array[currentIndex];
				currentIndex++;
				return element;
//				return array[currentIndex++];
			}
			
		} ;
		
	}
	
	
	
	
	
	



}
