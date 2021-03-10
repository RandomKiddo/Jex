/*
Jex, Copyright 2021 RandomKiddo

This work is licensed under the GNU General Public License (or GNU GPL), version 3.0
This program comes with ABSOLUTELY NO WARRANTY
This is a free software, and you are welcome to modify and redistribute it under certain conditions.

The current maintainer of this work is RandomKiddo
The "work" is defined as any part of Jex that is a source code file (.java, .jar, etc.)

For more information on the license, see: https://www.gnu.org/licenses/gpl-3.0.en.html
*/

package Jex;

import java.util.*;
import java.util.function.*;

//HTML CODE FOR JAVADOC
/**
 * @author RandomKiddo
 * @version Alpha 1.0
 * <br />
 * <br />
 * Represents a Map with three values, instead of the normal two
 * <br />
 * <br />
 * Instantiation: <br />
 * <code>TriMap<T, U, V> map = new TriMap<T, U, V>();</code>
 * <br />
 * <br />
 * Dependencies: <br />
 * <code>java.util</code> <br />
 * <code>java.util.function</code>
 */
public class TriMap<T, U, V> extends Object implements Cloneable, RandomAccess, Iterable<TriEntry<T, U, V>> {
    //Fields
    private ArrayList<TriEntry<T, U, V>> map;
    //Constructors

    /**
     * Instantiates a new TriMap instance
     */
    public TriMap() {
        this.map = new ArrayList<TriEntry<T, U, V>>();
    }
    private TriMap(TriMap<T, U, V> copy) {
        this.map = copy.map;
    }
    //Methods
    /**
     * Creates a String representation of this TriMap instance
     * @return a String of this TriMap
     */
    @Override
    public String toString() {
        String tos = "{\n";
        for (TriEntry<T, U, V> entry : this.map) {
            tos += entry.toString() + "\n";
        }
        tos += "}";
        return tos;
    }
    /**
     * Clones this TriMap
     * @return A clone of this TriMap
     * @throws CloneNotSupportedException
     */
    @Override
    public TriMap<T, U, V> clone() throws CloneNotSupportedException {
        return new TriMap(this);
    }
    /**
     * Adds the given values to the TriMap
     * @param t The key for this entry
     * @param u The first value for this entry
     * @param v The second value for this entry
     */
    public void put(T t, U u, V v) {
        TriEntry<T, U, V> entry = new TriEntry(t, u, v);
        this.map.add(entry);
    }
    /**
     * Adds the given entry to the TriMap
     * @param entry The entry to add
     */
    public void put(TriEntry<T, U, V> entry) {
        this.map.add(entry);
    }
    /**
     * Clears this TriMap
     */
    public void clear() {
        this.map = new ArrayList<TriEntry<T, U, V>>();
    }
    /**
     * Gets the entry of the given key
     * @param key The key to get then entry from
     * @return The entry, null if not found
     */
    public TriEntry<T, U, V> get(T key) {
        for (TriEntry<T, U, V> entry : this.map) {
            if (key.equals(entry.getFirst())) {
                return entry;
            }
        }
        return null;
    }
    /**
     * Returns if this key is found in this TriMap
     * @param key The key to be located
     * @return True if found, false otherwise
     */
    public boolean containsKey(T key) {
        for (TriEntry<T, U, V> entry : this.map) {
            if (key.equals(entry.getFirst())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns if this value is found in this TriMap (either U or V value)
     * @param value An Object of the U or V value
     * @return True if found, false otherwise
     */
    public boolean containsValue(Object value) {
        for (TriEntry<T, U, V> entry : this.map) {
            if (value.equals((Object)entry.getSecond()) || value.equals((Object)entry.getThird())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the mutable size of this TriMap
     * @return An int representing the size
     */
    public int size() {
        return this.map.size();
    }
    /**
     * Adds all the given values to this TriMap
     * @param values The values to add to this TriMap
     */
    public void putAll(Collection<TriEntry<T, U, V>> values) {
        this.map.addAll(values);
    }
    /**
     * Iterates this TriMap with the given action
     * @param action The lambda action to use when iterating this TriMap
     */
    @Override
    public void forEach(Consumer<? super TriEntry<T, U, V>> action) {
        for (TriEntry<T, U, V> entry : this.map) {
            action.accept(entry);
        }
    }
    /**
     * Returns an iterator for this TriMap
     * @return The iterator for this TriMap
     */
    @Override
    public Iterator iterator() {
        return this.map.iterator();
    }
    /**
     * Returns the keys of this TriMap in a set
     * @return The set of the keys
     */
    public Set<T> keySet() {
        Set<T> set = new HashSet<T>();
        for (TriEntry<T, U, V> entry : this.map) {
            set.add(entry.getFirst());
        }
        return set;
    }
    /**
     * Returns the values of this TriMap as a linked HashMap, with U being the new key
     * @return A linked HashMap of values
     */
    public HashMap<U, V> linkedValues() {
        HashMap<U, V> linked = new HashMap<U, V>();
        for (TriEntry<T, U, V> entry : this.map) {
            linked.put(entry.getSecond(), entry.getThird());
        }
        return linked;
    }
    /**
     * Returns a set of TriEntry instances for this TriMap
     * @return A set of entries
     */
    public Set<TriEntry<T, U, V>> entrySet() {
        Set<TriEntry<T, U, V>> set = new HashSet<TriEntry<T, U, V>>();
        for (TriEntry<T, U, V> entry : this.map) {
            set.add(entry);
        }
        return set;
    }
}