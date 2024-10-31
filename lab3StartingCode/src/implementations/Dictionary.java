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
	
	public Dictionary(int size) {
		int initialSize = size > 0 ? size : DEFAULT_SIZE;
		keys = new ArrayList<K>(initialSize);
		values = new ArrayList<V>(initialSize);
	}
	public Dictionary() {
	    this(DEFAULT_SIZE); // 调用 Dictionary(int size) 构造器，将默认大小 DEFAULT_SIZE 传入
	}

	@Override
	public void create(int size) {
		int initialSize = size > 0 ? size : DEFAULT_SIZE;
		keys = new ArrayList<K>(initialSize);
		values = new ArrayList<V>(initialSize);
		
	}
	
	
    /**
     * Inserts a key-value pair into the dictionary.
     *
     * @param key the key to insert
     * @param value the value associated with the key
     * @return 
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
     * Removes the key-value pair associated with the specified key.
     *
     * @param key the key to remove
	 * @return 

     */
	@Override
	public V remove(K key) {
		int index = keys.indexOf(key);
		if(index == -1) return null;
		keys.remove(index);
		values.remove(index);
		return values.get(index);
		
	}
	
	 /**
     * Updates the value associated with the specified key.
     *
     * @param key the key needs to be updated
     * @param newValue the new value to associate with the key
	 * @return 
     * @throws NullPointerException if the key or new value is null
     * @throws NoSuchElementException if the key is not found in the dictionary
     */
	
	@Override
	public boolean update(K key, V newValue) {
		int index = keys.indexOf(key);
		if(index == -1) return false;
		values.set(index, newValue);
		return true;
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
	public V lookup(K key) {
		int index = keys.indexOf(key);
		if(index == -1) return null;
		V searchedValue = values.get(index);
		return searchedValue;
	}

	

}
