/**
 * 
 */
package implementations;

import java.util.NoSuchElementException;

import utilities.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * 
 */
public class MyQueue<E> implements QueueADT<E>{
	//attribute
	private MyDLL<E> q;
	private int size;
	private int capacity;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dequeueAll() {
		size =0;
		q.clear();
		
	}

	@Override
	public boolean isEmpty() {
		
		return size ==0 ;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return size == capacity;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	

}
