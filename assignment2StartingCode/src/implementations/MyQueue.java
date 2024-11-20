/**
 * 
 */
package implementations;

import java.util.NoSuchElementException;


import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;


@SuppressWarnings("serial")
public class MyQueue<E> implements QueueADT<E>{
	//attribute
	private MyDLL<E> q;

	
	public MyQueue() {
		q = new MyDLL<>();
	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null) throw new NullPointerException();
		
		q.add(toAdd);
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		return q.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		return q.get(0);
	}

	@Override
	public void dequeueAll() {
		
		q.clear();
		
	}

	@Override
	public boolean isEmpty() {
		
		return q.isEmpty();
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) throw new NullPointerException();
		boolean result = q.contains(toFind);
		return result;
	}

	@Override
	public int search(E toFind) {
		int index = -1;
		for(int i =0; i<q.size();i++) {
			if(q.get(i).equals(toFind)) {
				index = i+1;
			}
		}
		return index;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int currentIndex = 0;
			
			@Override
			public boolean hasNext() {
				if(currentIndex < size()) return true;
				return false;
			}

			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
					return q.get(currentIndex++);
					
				
			}
			
		};
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		if(this.size() != that.size()) return false;

		Iterator<E> thisIterator = this.iterator();
		Iterator<E> thatIterator = that.iterator();
		    
		while (thisIterator.hasNext() && thatIterator.hasNext()) {
		      if (!thisIterator.next().equals(thatIterator.next())) {
		            return false; 
		        }
		 	}
		return true;
		
	}

	@Override
	public Object[] toArray() {
		return q.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) throw new NullPointerException();
		return q.toArray(holder);
	}

	@Override
	public boolean isFull() {
		
		return false;
	}

	@Override
	public int size() {

		return q.size();
	}
	

}
