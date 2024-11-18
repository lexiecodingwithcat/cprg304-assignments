package implementations;

import java.util.NoSuchElementException;


import utilities.Iterator;
import utilities.ListADT;

@SuppressWarnings("serial")
public class MyDLL<E> implements ListADT<E> {

	
	//attributes
	private MyDLLNode<E> head, tail;
	private int size;
	public MyDLL() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd)
			throws NullPointerException, IndexOutOfBoundsException {
		//loop to find the node at index 
		if(index<0 || index >size) throw new IndexOutOfBoundsException();
		if(toAdd == null) throw new NullPointerException();
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
		if(index == 0) {
			if(head == null) {
			head = newNode;
			tail = newNode;
			}else {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}
		}else if(index == size) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}else {
			MyDLLNode<E> currentNode = head;
			for(int i = 0;i<index;i++) {
				currentNode = currentNode.getNext();
			}
			MyDLLNode<E> prevNode = currentNode.getPrev();
			newNode.setPrev(prevNode);
			prevNode.setNext(newNode);
			newNode.setNext(currentNode);
			currentNode.setPrev(newNode);
		}
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) throw new NullPointerException();
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
		if(tail == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	if(toAdd == null) throw new NullPointerException();
	for(int i = 0; i<toAdd.size();i++) {
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd.get(i));
		if(tail == null) {
			head = newNode;
			tail = newNode;
		}else {
		tail.setNext(newNode);
		newNode.setPrev(tail);
		tail = newNode;
		}
		size++;
	}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index<0 || index >=size) throw new IndexOutOfBoundsException();
		if(index == 0) return head.getElement();
		if(index == size-1) return tail.getElement();
		MyDLLNode<E> currentNode = head;
		for(int i =0; i<index;i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index<0 || index >=size) throw new IndexOutOfBoundsException();
		E element = null;
		//remove head
		if(index == 0) {
			element = head.getElement();
			if(size == 1) {
				head = null;
				tail = null;
			}else {
			MyDLLNode<E> nextNode = head.getNext();
			nextNode.setPrev(null);
			head = nextNode;
			}
		}else if(index == size-1) {
			//remove tail
			element = tail.getElement();
			if(size ==1) {
				head = null;
				tail =null;
			}else {
			MyDLLNode<E> prevNode = tail.getPrev();
			prevNode.setNext(null);
			tail = prevNode;
			}
		}else {
			MyDLLNode<E> currentNode = head;
			for(int i =0;i<index; i++) {
				currentNode = currentNode.getNext();
			}
			element = currentNode.getElement();
			MyDLLNode<E> prevNode = currentNode.getPrev();
			MyDLLNode<E> nextNode = currentNode.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
		}
		size--;
		return element;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) throw new NullPointerException();
		MyDLLNode<E> currentNode = head;
		E element = null;
		for(int i=0; i<size; i++) {
			if(currentNode.getElement().equals(toRemove)) {
				element = currentNode.getElement();
				if(currentNode == head) {
					head = head.getNext();
					if(head != null) {
						head.setPrev(null);
					}else {
						tail = null;
					}
				}else if(currentNode == tail){
					tail = currentNode.getPrev();
					if(tail != null) {
						tail.setNext(null);
					}else {
						head = null;
					}
				}else {
					currentNode.getPrev().setNext(currentNode.getNext());
					currentNode.getNext().setPrev(currentNode.getPrev());
				}
				size --;
				return element;
			}
			currentNode = currentNode.getNext();}
		return null;
	}

	@Override
	public E set(int index, E toChange)
			throws NullPointerException, IndexOutOfBoundsException {
		if(index<0 || index >=size) throw new IndexOutOfBoundsException();
		if(toChange == null) throw new NullPointerException();
		MyDLLNode<E> currentNode = head;
		for(int i = 0; i<index; i++) {
			currentNode= currentNode.getNext();
		}
		E element = currentNode.getElement();
		currentNode.setElement(toChange);
		return element;
	}

	@Override
	public boolean isEmpty() {
	
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind ==  null) throw new NullPointerException();
		MyDLLNode<E> currentNode = head;
		for(int i = 0; i<size; i++) {
			if(currentNode.getElement().equals(toFind)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) throw new NullPointerException();
		if(size>toHold.length) {
//			E[] newArr = (E[]) new Object[size];
			toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
		}
		MyDLLNode<E> currentNode = head;
		for(int i = 0;i<size;i++) {
			toHold[i]= currentNode.getElement();
			currentNode = currentNode.getNext();
		}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] newArr = new Object[size];
		MyDLLNode<E> currentNode = head;
		for(int i = 0;i<size;i++) {
			newArr[i]= currentNode.getElement();
			currentNode = currentNode.getNext();
		}
		return newArr;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int currentIndex = 0;
			private MyDLLNode<E> currentNode = head;
			@Override
			public boolean hasNext() {
				if(currentIndex < size) return true;
				return false;
			}

			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
					E element = currentNode.getElement();
					currentIndex++;
					currentNode= currentNode.getNext();
					return element;
					
				
			}
			
		};
		
		}

}
