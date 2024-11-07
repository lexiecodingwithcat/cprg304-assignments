package implementations;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import exceptions.DuplicateKeyException;
import utilities.DictionaryADT;

/**
 * A Dictionary data structure implemented from DictionaryADT.
 *@author Tianzi Cui
* @version 30 Oct, 2024  
 * It holds data in (key, value) pairs where every key is unique and both key and value cannot be null.
 * It enables function of insertion, update, deletion and lookup based on a specified key.
 *
 * @param <K> the type of keys maintained by this dictionary
 * @param <V> the type of values maintained by this dictionary
 */
public class Dictionary<K,V> implements DictionaryADT<K,V>
{
	// constant
	private static final int DEFAULT_SIZE = 10;

	// index indicates pairing, e.g. keys[1] is stored at values[1]
	private ArrayList<K> keys;
	private ArrayList<V> values;
	
	 /**
     * Constructs a dictionary with a specified initial capacity.
     * If the size passed is less than or equal with zero, use the DEFAULT_SIEZ as its initial capacity.
     *
     * @param size the initial capacity of the dictionary
     */
	
	public Dictionary(int size) {
		int capacity = size > 0 ? size : DEFAULT_SIZE;
		keys = new ArrayList<K>(capacity);
		values = new ArrayList<V>(capacity);
	}
	
	 /**
     * Constructs a dictionary with the default initial capacity.
     */
	public Dictionary() {
	    this(DEFAULT_SIZE); 
	}

	 /**
     * Initializes the dictionary with a specified capacity.
     * If the size passed is less than or equal with zero, use the DEFAULT_SIEZ as its initial capacity.
     * 
     * precondition: There is no precondition.
     * postcondition: Dictionary is initialized with the specified size.
     * 
     * @param size the initial capacity of the dictionary.
     * 
     */
	@Override
	public void create(int size) {
		int initialSize = size > 0 ? size : DEFAULT_SIZE;
		keys = new ArrayList<K>(initialSize);
		values = new ArrayList<V>(initialSize);
		
	}
	
	
	 /**
     * The insert method will insert a key-value pair into the dictionary.
     * 
     * precondition: {@code key} and {@code value} are not {@code null}, and {@code key} does not already exist.
     * postcondition: The dictionary contains the new key-value pair.
     * 
     * @param key the key to insert.
     * @param value the value associated with the key.
     * @return {@code true} if the insertion is successful,
     * 		   {@code false} otherwise.
     * @throws DuplicateKeyException if the key already exists in the dictionary
     * 
     */
	@Override
	public boolean insert(K key, V value) throws DuplicateKeyException {
		if(keys.contains(key)) {
			throw new DuplicateKeyException();
		}
		keys.add(key);
		values.add(value);
		return true;
	}
	

	
	 /**
     * The remove method will removes the key-value pair associated with the specified key.
     * 
     * precondition: {@code key} is not {@code null}.
     * postcondition: The key-value pair associated with the specified key is removed from the dictionary.
     * 
     * @param key the key to remove.
     * @return the value associated with the removed key, or {@code null} if the key is not found.

     */
	@Override
	public V remove(K key) {
		int index = keys.indexOf(key);
		if(index == -1) return null;
		keys.remove(index);
		V value = values.get(index);
		values.remove(index);
		return value;
		
	}
	
	 /**
     * Updates the value associated with the specified key.
     * 
     * precondition: {@code key} and {@code newValue} are not {@code null}, and {@code key} exists in the dictionary.
     * postcondition: The dictionary contains the new value associated with the specified key.
     * 
     * @param key the key to update.
     * @param newValue the new value to associate with the key.
     * @return {@code true} if the update is successful, {@code false} if the key is not found.
     */
	@Override
	public boolean update(K key, V newValue) {
		int index = keys.indexOf(key);
		if(index == -1) return false;
		values.set(index, newValue);
		return true;
	}
	
	 /**
     * The lookup method will look up the value associated with the specified key.
     *
     * precondition: {@code key} is not {@code null} and already exists in the dictionary.
     * postcondition: The dictionary remains unchanged; returns the value associated with the key.
     * 
     * @param key the key whose associated value is to be looked up.
     * @return the value associated with the specified key, or {@code null} if the key is not found.
     * @throws NullPointerException if the key is {@code null}
     * 
     */
	@Override
	public V lookup(K key) {
		int index = keys.indexOf(key);
		if(index == -1) return null;
		V searchedValue = values.get(index);
		return searchedValue;
	}

	

}
