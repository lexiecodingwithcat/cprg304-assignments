package utilities;

import java.util.NoSuchElementException;

/**
* DictionaryADT.java
*
* @author Tianzi Cui
* @version 19 Oct, 2024
* 
* Class Definition: This interface represents the public contract for the
* implementation of Dictionary for the DictionaryADT Lab. 
*/

public interface DictionaryADT<K,V>{
/**
 * Insert specified key and value as a pair into the dictionary. 
 * They key and value will append to the end of the current dictionary.
 * 
 * Precondition: The key and value must be non-null. There is no duplicate key exists in the dictionary.
 * Postcondition: If the key does not exist and both key and value are not null, they are inserted.
 * 				  If an exception has been thrown, there is no change inside the dictionary.
 * 
 * @param key   The key to be inserted into the dictionary. 
 * @param value The value associated with the key. 
 * @throws NullPointerException      If the key or value is {@code null}.
 * @throws IllegalArgumentException  If the key already exists in the dictionary.
 */

void insert(K key, V value) throws NullPointerException, IllegalArgumentException ;

/** Remove a pair (both key and value) based on the key.
 * 
 *  Precondition: They key must be non-null and must already exists in the dictionary.
 *  Postcondition: If the key exists, the corresponding key-value pair is removed from the dictionary.
 * 				   If an exception is thrown, the dictionary remains unchanged.
 *  
 *  @param key  The key of the key-value pair to be removed.
 *  @throws NullPointerException     If the key is {@code null}
 *  @throws NoSuchElementException  If the key does not exist in the dictionary.
 */
void remove(K key) throws NullPointerException, NoSuchElementException;

/** Update the value based on its associated key.
 * 
 *  Precondition: They key must be non-null and must already exists in the dictionary.
 *  			  The new value must be non-null as well.
 *  Postcondition: If it matches the precondition, the value is updated to new.
 *  			   If not, an exception is thrown and the value remains unchanged.
 *  
 *  @param key  The key of the key-value pair to be updated.
 *  @param newValue The new value to be associated with the key. 
 *  
 *  @throws NullPointerException     If the key or the new value is {@code null}
 *  @throws NoSuchElementException  If the key is not found in the dictionary.
 */
void update(K key, V newValue) throws  NullPointerException, NoSuchElementException ;

/** Look up the value based on its corresponding key.
 *  Precondition: They key must already exists in the dictionary.
 *  Postcondition: If it matches the precondition, the value is returned.
 *  			   If not, an exception is thrown and there is no value returned.
 *  @param key  The key of the key-value pair to be updated.
 *  @return value The value associated with the specified key.
 *  
 *  @throws NullPointerException     If the key is {@code null}
 *  @throws NoSuchElementException  If the key is not found in the dictionary.
 */
V lookup(K key) throws NullPointerException, NoSuchElementException;
	
	

}
