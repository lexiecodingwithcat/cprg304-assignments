package exercise2;

public class MyNode<E>
{

	private E element;
	private MyNode<E> next;
	private MyNode<E> prev;
	
	public MyNode(E element) {
		this.element = element;
		this.next = null;
		this.prev = null;
	
	}

	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the next
	 */
	public MyNode<E> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(MyNode<E> next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public MyNode<E> getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(MyNode<E> prev) {
		this.prev = prev;
	}

}
