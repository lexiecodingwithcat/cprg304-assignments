package exercise2;

/**
 * A node in a doubly linked list.
 *
 * @param <E> the type of elements held in this node
 * 
 * @author Tianzi Cui
 * @version Nov 7, 2024
 */
public class MyNode<E> {

    private E element;
    private MyNode<E> next;
    private MyNode<E> prev;

    /**
     * Constructs a new MyNode with the specified element.
     *
     * @param element the element to be stored in this node
     */
    public MyNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return the element in this node
     */
    public E getElement() {
        return element;
    }

    /**
     * Sets the element for this node.
     *
     * @param element the element to set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node, or null if there is no next node
     */
    public MyNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the next node to set
     */
    public void setNext(MyNode<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node, or null if there is no previous node
     */
    public MyNode<E> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the previous node to set
     */
    public void setPrev(MyNode<E> prev) {
        this.prev = prev;
    }
}