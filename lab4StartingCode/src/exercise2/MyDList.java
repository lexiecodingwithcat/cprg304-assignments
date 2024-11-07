package exercise2;

import java.util.NoSuchElementException;

/**
 * A doubly linked list implementation.
 *
 * @param <E> the type of elements held in this list
 * 
 * @author Tianzi Cui
 * @version Nov 7, 2024
 */
public class MyDList<E> {

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    /**
     * Constructs an empty MyDList.
     */
    public MyDList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * Returns the head node of this list.
     *
     * @return the head node, or null if the list is empty
     */
    public MyNode<E> getHead() {
        return head;
    }

    /**
     * Adds the specified item to the front of this list.
     *
     * @param item the item to be added
     */
    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (head == null) {
            // The new node is both head and tail
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        head = newNode;
        size++;
    }

    /**
     * Adds the specified item to the end of this list.
     *
     * @param item the item to be added
     */
    public void addLast(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes and returns the item at the front of this list.
     *
     * @return the item at the front of this list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if (head == null) throw new NoSuchElementException("The list is empty");
        MyNode<E> curNode = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            MyNode<E> nextNode = head.getNext();
            nextNode.setPrev(null);
            head = nextNode;
        }
        size--;
        return curNode.getElement();
    }

    /**
     * Removes and returns the item at the end of this list.
     *
     * @return the item at the end of this list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeLast() {
        if (tail == null) throw new NoSuchElementException("The list is empty");
        MyNode<E> curNode = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            MyNode<E> prevNode = tail.getPrev();
            prevNode.setNext(null);
            tail = prevNode;
        }
        size--;
        return curNode.getElement();
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list is empty.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return head == null;
    }
}