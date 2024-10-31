package utilities;

import java.util.NoSuchElementException;

/**
 * The {@code StackADT} interface defines the basic operations of a stack data structure.
 *
 * @param <T> the type of elements held in this stack
 */
public interface StackADT<T> {
	
	/**The size method will return the current element count in the stack.
	 * 
	 * precondition: There is no precondition 
	 * postcondition: Returns the number of elements in the stack.
	 * 
	 * @return the current element count.
	 */
	int size();
	
	/**
	 * The isEmpty method will check whether the stack is empty or not.
	 * 
	 * precondition: There is no precondition 
	 * postcondition: Returns true if stack is empty, otherwise false.
	 * 
	 * @return {@code true} if the stack is empty
	 *         {@code false} if the stack is not empty
	 */
	boolean isEmpty();
	
	 /**
     * The isFull method will check if the stack is full. An optional method for fixed size stack.
     * 
     * Precondition: There is no precondition.
     * Postcondition: Returns {@code true} if the stack is full, {@code false} otherwise.
     *
     * @return {@code true} if the stack is full, {@code false} otherwise
     */
	boolean stackOverflow();
	
	
	/** The clear method will remove all of the elements from the stack. This stack will be empty after
	 * this call returns.
	 * 
	 * precondition: There is no precondition 
	 * postcondition: All elements in the stack are removed; stack is empty.
	 */
	void clear();
	
	/** The push method will add new element on the TOP of the current stack.
	 * 
	 * precondition: Element to add is not null.
	 * postcondition: Element is added to the top of the stack.
	 * 
	 * @param element The element to be added.
	 * @throws NullPointerException if the element is {@code null}, and stack implementation does not support
	 *                              having {@code null} elements.
	 */
	void push(T element) throws NullPointerException;
	
	/** The pop method will remove the top element in the stack and return the element that has been removed.
	 * 
	 * precondition: Stack is not empty.
	 * postcondition: The top element is removed and returned.
	 * 
	 * @return The element has been removed.
	 * @throws NoSuchElementException if the stack is already empty.
	 */
	T pop() throws NoSuchElementException;
	
	/** The peek method will return the top element in the stack without removing it.
	 * 
	 * precondition: Stack is not empty.
	 * postcondition: Stack remains unchanged; returns the top element.
	 * 
	 * @retrun The top element in the stack. 
	 */
	T peek();
	
	/** The equals method will take in one stack and compare it with the current stack.
	 * 
	 * precondition: The stack to compare is not null.
	 * postcondition: Returns true if both stacks have same elements in the same order.
	 * 
	 * @param that The stack that need to compare
	 * @return {@code true} If two stacks contain equal items appearing in the same order.
	 *         {@code false} If two stacks do not contain equal items or equal items are not in the same order.
	 * @throws NullPointerException the stack passed in is {@code null}.
	 */
	boolean equals(StackADT<T> that) throws NullPointerException;
	
	/**The search method will look for the specified element that has been passed in the stack.
	 * 
	 * precondition: Element to search is not null.
	 * postcondition: Stack remains unchanged; returns index of element or -1 if not found.
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
	 * precondition: There is no precondition.
	 * postcondition: Stack remains unchanged; returns true if element is found.
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
	 * precondition: There is no precondition. 
	 * postcondition: Returns an array of all stack elements in order.
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
	 * precondition: Array is not null.
	 * postcondition: Returns an array containing stack elements in order.
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
	 * precondition: There is no precondition. 
	 * postcondition: Returns an iterator over elements in stack order.
	 * 
	 * @return An iterator over the elements in this stack, in proper sequence. NB:
	 *         The return is of type {@code linearUtilities.Iterator<E>}, not
	 *         {@code java.util.Iterator}.
	 */
	Iterator<T> iterator();
	
}
