package utilities;

import java.util.NoSuchElementException;

/**
 * The {@code QueueADT} interface defines that defines
 * the basic operations of a queue data structure.
 *
 * @param <E> the type of elements held in this queue.
 */
public interface QueueADT<E> {
	
	
	/**The size method will return the current element count in the stack.
	 * 
	 * Precondition: There is no precondition.
     * Postcondition: Returns the number of elements in the queue.
     * 
	 * @return the current element count.
	 */
	int size();
	
	/**
	 * The isEmpty method will check whether the stack is empty or not.
	 * 
	 * Precondition: There is no precondition.
     * Postcondition: Returns {@code true} if the queue is empty, {@code false} otherwise.
     *
	 * @return {@code true} if the stack is empty
	 *         {@code false} if the stack is not empty
	 */
	boolean isEmpty();
	
    /**
     * The isFull method will check if the queue is full. An optional method for fixed size queue.
     * 
     * Precondition: There is no precondition.
     * Postcondition: Returns {@code true} if the queue is full, {@code false} otherwise.
     *
     * @return {@code true} if the queue is full, {@code false} otherwise
     */
	boolean isFull();
	
	 /**
     * The enqueue method will add an element to the end of the queue.
     *
     * Precondition: The queue must not be full. The element must not be {@code null} if null elements are not allowed.
     * Postcondition: The element is added to the end of the queue.
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
     * Precondition: The queue must not be empty.
     * Postcondition: The first element in the queue is removed.
     * 
     * @throws NoSuchElementException if the element is not found in the queue.
     */
	void dequeue() throws NoSuchElementException;
	
	/**
     * The dequeueAll method that removes all elements from the queue.
     * 
     * Precondition: There is no precondition.
     * Postcondition: The queue is empty after this call.
     * 
     */
	void dequeueAll();
	
	/** The peek method will return the first element in the queue without removing it.
	 * 
	 * Precondition: The queue must not be empty.
     * Postcondition: Returns the first element in the queue without modifying the queue.
     * 
	 * @retrun The first element in the queue.
	 */
	E peek();
	
	/** The equals method will take in one queue and compare it with the current queue.
	 * 
	 * Precondition: The argument queue cannot be {@code null}.
     * Postcondition: Returns {@code true} if both queues have the same elements in the same order, {@code false} otherwise.
     * 
	 * @param that The queue that need to compare
	 * @return {@code true} If two queues contain equal items appearing in the same order.
	 *         {@code false} If two queues do not contain equal items or equal items are not in the same order.
	 * 
	 */
	boolean equals(QueueADT<E> that);
	
	/**The search method will look for the specified element that has been passed in the queue.
	 * 
	 * precondition: Element to search is not null.
	 * postcondition: Queue remains unchanged; returns index of element or -1 if not found.
	 * 
	 * @param element The element need to be searched
	 * @return the index of the searched element if found.
	 * @return -1 if the element is not found.
	 * @throws NullPointerException If the element passed in is {@code null}. And queue implementation 
	 *                              does not support having {@code null} elements.
	 *                                                             
	 */
	int search(E element) throws NullPointerException;
	
	/**The contains method will search the stack to see whether it is contains the element passed in.
	 * 
	 * precondition: There is no precondition.
	 * postcondition: Queue remains unchanged; returns true if element is found.
	 * 
	 * @param element The element need to be searched for
	 * @return {@code true} if the collection contains the specified element,
     *         {@code false} otherwise
     * @throws NullPointerException If the element passed in is {@code null}. And queue implementation 
	 *                              does not support having {@code null} elements.         
	 */
	boolean contains(E element) throws NullPointerException;
	
	
	/**
	 * The toArray method will return an array containing all of the elements in this queue in proper
	 * sequence. Obeys the general contract of the {@code java.util.Collection.toArray()} method.
	 * 
	 * Precondition: There is no precondition.
     * Postcondition: Returns an array containing the elements in the queue in the order they were added.
     *
	 * 
	 * @return An array containing all of the elements in this queue in proper sequence.
	 */
	Object[] toArray();
	
	/**
	 * This method will return an array containing all of the items in this queue in proper order
	 * ; the runtime type of the returned array is that of the specified array. 
	 * Obeys the general contract of the {@code java.util.Collection.toArray(Object [])} method.
	 * 
	 * Precondition: The array provided cannot be {@code null}.
     * Postcondition: Returns an array containing the elements of this queue.
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
	 * Precondition: There is no precondition.
     * Postcondition: Returns an iterator that allows traversal of the elements in the queue in proper sequence.
     *
	 * @return An iterator over the elements in this queue in proper sequence. NB:
	 *         The return is of type {@code linearUtilities.Iterator<E>}, not
	 *         {@code java.util.Iterator}.
	 */
	Iterator<E> iterator();
}
