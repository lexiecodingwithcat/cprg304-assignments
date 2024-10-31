package implementations;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import utilities.DictionaryADT;

/**
 * A Dictionary data structure implemented from DictionaryADT.
 *@author Tianzi Cui
* @version 22 Oct, 2024  
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
	  * The constructor of Dictionary class
     * Constructs an empty Dictionary with an initial capacity.
     * 
     */
	public Dictionary(){
		keys = new ArrayList<K>(DEFAULT_SIZE);
		values = new ArrayList<V>(DEFAULT_SIZE);
		
	}
	
    /**
     * Inserts a key-value pair into the dictionary.
     *
     * @param key the key to insert
     * @param value the value associated with the key
     * @throws NullPointerException if the key or value is null
     * @throws IllegalArgumentException if the key already exists in the dictionary
     */
	@Override
	public void insert(K key, V value) throws NullPointerException, IllegalArgumentException {
		if(key == null || value == null) {
			throw new NullPointerException("Key and value cannot be null");
		}
		if(keys.contains(key)) {
			throw new IllegalArgumentException("Key already exists");
		}
		keys.add(key);
		values.add(value);
		
	}
	

	
	 /**
     * Removes the key-value pair associated with the specified key.
     *
     * @param key the key to remove
     * @throws NullPointerException if the key is null
     * @throws NoSuchElementException if the key is not found in the dictionary
     */
	@Override
	public void remove(K key)
			throws NullPointerException, NoSuchElementException {
		if(key == null) throw new NullPointerException("Key cannot be null.");
		//find the index
		int index = keys.indexOf(key);
		if(index == -1) throw new NoSuchElementException("No key found.");
		keys.remove(index);
		values.remove(index);
	}
	
	 /**
     * Updates the value associated with the specified key.
     *
     * @param key the key needs to be updated
     * @param newValue the new value to associate with the key
     * @throws NullPointerException if the key or new value is null
     * @throws NoSuchElementException if the key is not found in the dictionary
     */
	
	@Override
	public void update(K key, V newValue)
			throws NullPointerException, NoSuchElementException {
		if(key == null || newValue == null) throw new NullPointerException("Key and value cannot be null.");
		int index = keys.indexOf(key);
		if(index == -1) throw new NoSuchElementException("No key found.");
		values.set(index, newValue);
	}
	
    /**
     * Looks up the value associated with the specified key.
     *
     * @param key the key whose associated value is to be looked up
     * @return the value associated with the specified key
     * @throws NullPointerException if the key is null
     * @throws NoSuchElementException if the key is not found in the dictionary
     */
	@Override
	public V lookup(K key) throws NullPointerException, NoSuchElementException {
		if(key == null) throw new NullPointerException("Key cannot be null.");
		int index = keys.indexOf(key);
		if(index == -1) throw new NoSuchElementException("No key found.");
		V searchedValue = values.get(index);
		return searchedValue;
	}

}
