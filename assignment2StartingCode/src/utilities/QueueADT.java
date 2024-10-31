package utilities;

import java.util.NoSuchElementException;

/**
 * A generic interface representing a Queue Abstract Data Type (ADT) that defines
 * the basic operations of a queue data structure.
 *
 * @param <E> the type of elements held in this queue
 */
public interface QueueADT<E> {
	
	
	/**The size method will return the current element count in the stack.
	 * 
	 * @return the current element count.
	 */
	int size();
	
	/**
	 * The isEmpty method will check whether the stack is empty or not.
	 * 
	 * @return {@code true} if the stack is empty
	 *         {@code false} if the stack is not empty
	 */
	boolean isEmpty();
	
    /**
     * The isFull method will check if the queue is full. An optional method for fixed size queue.
     *
     * @return {@code true} if the queue is full, {@code false} otherwise
     */
	boolean isFull();
	
	/**
     * The dequeueAll method Removes all elements from the queue.
     */
	void dequeueAll();
	
	  /**
     * The enqueue method will add an element to the end of the queue.
     *
     * @param element the element to be added to the queue
     * @throws IllegalStateException if the queue is full.
     * @throws NullPointerException if the element is {@code null}, and queue implementation does not support
	 *                              having {@code null} elements.
     */
	void enqueue(E element) throws IllegalStateException, NullPointerException;
	
	/**
     * The dequeue will remove the first element from the queue.
     *
     * @throws NoSuchElementException if the element is not found in the queue.
     */
	void dequeue() throws NoSuchElementException;
	
	/** The peek method will return the first element in the queue without removing it.
	 * 
	 * @retrun The first element in the queue.
	 */
	E peek();
	
	/** The equals method will take in one queue and compare it with the current queue.
	 * 
	 * @param that The queue that need to compare
	 * @return {@code true} If two queues contain equal items appearing in the same order.
	 *         {@code false} If two queues do not contain equal items or equal items are not in the same order.
	 * 
	 */
	boolean equals(QueueADT<E> that);
	
	/**
	 * The toArray method will return an array containing all of the elements in this queue in proper
	 * sequence. Obeys the general contract of the {@code java.util.Collection.toArray()} method.
	 * 
	 * @return An array containing all of the elements in this queue in proper sequence.
	 */
	Object[] toArray();
	
	/**
	 * This method will return an array containing all of the items in this queue in proper order
	 * ; the runtime type of the returned array is that of the specified array. 
	 * Obeys the general contract of the {@code java.util.Collection.toArray(Object [])} method.
	 * 
	 * @param copy The array into which the elements of this list are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this queue.
	 * @throws NullPointerException If the specified array is {@code null}.
	 */
	E[] toArray(E[] copy) throws NullPointerException;

	/**
	 * Returns an iterator over the elements in this queue, in proper sequence.
	 * 
	 * @return An iterator over the elements in this queue in proper sequence. NB:
	 *         The return is of type {@code linearUtilities.Iterator<E>}, not
	 *         {@code java.util.Iterator}.
	 */
	Iterator<E> iterator();
}
