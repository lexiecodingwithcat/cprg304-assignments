package exercise2;

import java.util.NoSuchElementException;

public class MyDList<E>
{

	private MyNode<E> head;
	private MyNode<E> tail;
	private int size;
	 
	public MyDList() {
		this.head = null;
		this.tail = null;
		size = 0;
		
	}
	

	public MyNode<E> getHead() {
		return head;
	}
	
	
	public void addFirst(E item) {
		MyNode<E> newNode = new MyNode<>(item);
		if(head == null) {
			//the new node is both head and tail
			tail = newNode;
		}else {
		newNode.setNext(head);
		head.setPrev(newNode);
		}
		head = newNode;
		size ++;
	}
	
	public void addLast(E item) {
		MyNode<E> newNode = new MyNode<>(item);
		if(tail == null) {
		head = newNode;
		}else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			
		}
		tail = newNode;
		size++;
	}
	
	public E removeFirst()  {
		if(head == null) throw new NoSuchElementException("The list is empty");
		MyNode<E> curNode = head;
		if(head == tail) {
			head = null;
			tail = null;
		}else {
		MyNode<E> nextNode = head.getNext();
		nextNode.setPrev(null);
		head = nextNode;
		}
		size--;
		return curNode.getElement();
	}
	
	 public E removeLast() {
		if(tail == null) throw new NoSuchElementException("The list is empty");
		MyNode<E> curNode = tail;
		if(head == tail) {
			head = null;
			tail = null;
		}else {
			MyNode<E> prevNode = tail.getPrev();
			prevNode.setNext(null);
			tail = prevNode;
		} 
		size--;
		return curNode.getElement();
	}
	 
	 public int size() {
		return size;
	}
	 
	 public boolean isEmpty() {
		if(head == null) return true;
		return false;
	}
	
}
