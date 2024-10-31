/**
 * 
 */
package implementations;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.QueueADT;

/**
 * 
 */
public class MyQueue<E> implements QueueADT<E>{
	//attribute
	private MyDLL<E> q;
	public MyQueue() {
		q = new MyDLL<>();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E peek() {
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
	public E[] toArray(E[] copy) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

}
