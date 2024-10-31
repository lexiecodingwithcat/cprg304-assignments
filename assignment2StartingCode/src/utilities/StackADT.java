package utilities;

public interface StackADT<T> {
	
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
	
	/** The clear method will remove all of the elements from the stack. This stack will be empty after
	 * this call returns.
	 */
	void clear();
	
	/** The push method will add new element on the TOP of the current stack.
	 * 
	 * @param element The element to be added.
	 * @throws NullPointerException if the element is {@code null}, and stack implementation does not support
	 *                              having {@code null} elements.
	 */
	void push(T element) throws NullPointerException;
	
	/** The pop method will remove the top element in the stack and return the element that has been removed.
	 * 
	 * @return The element has been removed.
	 */
	T pop();
	
	/** The peek method will return the top element in the stack without removing it.
	 * 
	 * @retrun The top element in the stack.
	 */
	T peek();
	
	/** The equals method will take in one stack and compare it with the current stack.
	 * 
	 * @param that The stack that need to compare
	 * @return {@code true} If two stacks contain equal items appearing in the same order.
	 *         {@code false} If two stacks do not contain equal items or equal items are not in the same order.
	 * 
	 */
	boolean equals(StackADT<T> that);
	
	/**The search method will look for the specified element that has been passed in the stack.
	 * 
	 * @param element The element need to be searched
	 * @return the index of the searched element if found.
	 * @return -1 if the element is not found.
	 * @throws NullPointerException If the element passed in is {@code null}. And stack implementation 
	 *                              does not support having {@code null} elements.
	 *                                                             
	 */
	int search(T element) throws NullPointerException;
	
	/**The contains method will search the stack to see whether it is contains the element passed in.
	 * 
	 * @param element The element need to be searched for
	 * @return {@code true} if the collection contains the specified element,
     *         {@code false} otherwise
     * @throws NullPointerException If the element passed in is {@code null}. And stack implementation 
	 *                              does not support having {@code null} elements.         
	 */
	boolean contains(T element) throws NullPointerException;
	
	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence. Obeys the general contract of the
	 *{@code java.util.Collection.toArray()} method.
	 * 
	 * @return An array containing all of the elements in this stack in proper
	 *         sequence.
	 */
	Object[] toArray();
	
	
	/**
	 * This method will return an array containing all of the items in this stack in proper order
	 * ; the runtime type of the returned array is that of the specified array. 
	 * Obeys the general contract of the {@code java.util.Collection.toArray(Object [])} method.
	 * 
	 * @param copy The array into which the elements of this list are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this stack.
	 * @throws NullPointerException If the specified array is {@code null}.
	 */
	T[] toArray(T[] copy) throws NullPointerException;
	
	/**
	 * Returns an iterator over the elements in this stack, in proper sequence.
	 * 
	 * @return An iterator over the elements in this stack, in proper sequence. NB:
	 *         The return is of type {@code linearUtilities.Iterator<E>}, not
	 *         {@code java.util.Iterator}.
	 */
	Iterator<T> iterator();
	
}
