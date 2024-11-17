package implementations;

import java.util.EmptyStackException;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;

@SuppressWarnings("serial")
public class MyStack<E> implements StackADT<E>{
    //attributes
	private MyArrayList<E> stack;
	public MyStack() {
		stack = new MyArrayList<>();
	}
	
	@Override
	public void push(E toAdd) throws NullPointerException {
		if(toAdd == null) throw new NullPointerException();
		stack.add(toAdd);
	}
	
	@Override
	public E pop() throws EmptyStackException {
	if(stack.isEmpty()) throw new EmptyStackException();
		return stack.remove(stack.size()-1);
	}
	
	@Override
	public E peek() throws EmptyStackException {
		if(stack.isEmpty()) throw new EmptyStackException();
		return stack.get(stack.size()-1);
	}
	@Override
	public void clear() {
		stack.clear();
		
	}
	@Override
	public boolean isEmpty() {
		return stack.size() ==0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) throw new NullPointerException();
		int size = stack.size();
		if(size>holder.length) {
//			E[] newArr = (E[])new Object[size];
			holder = (E[]) java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), stack.size());
		}
		for(int i = 0; i<size; i++) {
			holder[i]= stack.get(size-1-i);
		}
		return holder;
	}
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) throw new NullPointerException();
		
		return stack.contains(toFind);
	}
	@Override
	public Object[] toArray() {
		
		int size = stack.size();
		Object[] newArr = new Object[size];
		for(int i = 0; i<size; i++) {
			newArr[i]= stack.get(size-1-i);
		}
		return newArr;

		
	}
	
	@Override
	public int search(E toFind) {
		if(toFind == null) throw new NullPointerException();
		int index = -1;
		int size = stack.size();
		for(int i=0; i<size;i++) {
			if(stack.get(i).equals(toFind)) {
				index = size-i;
			}
		}
		return index;
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {
			private int currentIndex = stack.size()-1;
			@Override
			public boolean hasNext() {
				return currentIndex>=0;
			}

			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
				E element = stack.get(currentIndex);
				currentIndex--;
				return element;
			}
			
		};
	}
	

	@Override
	public boolean equals(StackADT<E> that) {

	if(this.size() != that.size()) return false;

	Iterator<E> thisIterator = stack.iterator();
	Iterator<E> thatIterator = that.iterator();
	    
	while (thisIterator.hasNext() && thatIterator.hasNext()) {
	      if (!thisIterator.next().equals(thatIterator.next())) {
	            return false; 
	        }
	 	}
	return true;
	}
	
	@Override
	public int size() {
		return stack.size();
	}
	
	@Override
	public boolean stackOverflow() {
		
		return false;
	}
	
}
