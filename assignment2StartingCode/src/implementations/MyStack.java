package implementations;

import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E>{
    //attributes
	private MyArrayList<E> stack;
	public MyStack() {
		stack=new MyArrayList<>();
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
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(StackADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int search(E element) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean contains(E element) {
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
}
