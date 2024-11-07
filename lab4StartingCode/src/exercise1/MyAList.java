package exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * A generic list implementation using an underlying ArrayList.
 *
 * @param <E> the type of elements in this list
 * 
 * @author Tianzi Cui
 * @version Nov 7, 2024
 */
public class MyAList<E> implements Iterable<E> {
    private ArrayList<E> list;

    /**
     * Constructs an empty MyAList.
     */
    public MyAList() {
        list = new ArrayList<>();
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return list.size();
    }

    /**
     * The isEmpty method will check whether the list is empty or not.
     *
     * @return true if this list contains no elements
     * 			false if the list contains at least one element.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds the specified item to the end of this list.
     *
     * @param item the item to be added
     * @throws NullPointerException if the specified item is null
     */
    public void add(E item) throws NullPointerException {
        if (item == null) throw new NullPointerException("Item cannot be null");
        list.add(item);
    }

    /**
     * Adds all items from the specified MyAList to this list.
     *
     * @param items the MyAList containing items to be added
     * @throws NullPointerException if the specified list is null
     */
    public void addAll(MyAList<E> items) throws NullPointerException {
        if (items == null) throw new NullPointerException("List cannot be null");
        for (E item : items) {
            list.add(item);
        }
    }

    /**
     * Returns the item at the specified position in this list.
     *
     * @param index the index of the item to return
     * @return the item at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("index cannot be less than zero or out of list size.");
        return list.get(index);
    }

    /**
     * Removes the item at the specified position in this list.
     *
     * @param index the index of the item to be removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("index cannot be less than zero or out of list size.");
        list.remove(index);
    }

    /**
     * Replaces the item at the specified position in this list with the specified item.
     *
     * @param index the index of the item to replace
     * @param item the item to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     * @throws NullPointerException if the specified item is null
     */
    public void set(int index, E item) throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("index cannot be less than zero or out of list size.");
        if (item == null) throw new NullPointerException("Item cannot be null");
        list.set(index, item);
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing all of the elements in this list
     */
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
