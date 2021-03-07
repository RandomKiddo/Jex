/*
Jex, Copyright 2021 RandomKiddo

This work is licensed under the GNU General Public License (or GNU GPL), version 3.0
This program comes with ABSOLUTELY NO WARRANTY
This is a free software, and you are welcome to modify and redistribute it under certain conditions.

The current maintainer of this work is RandomKiddo
The "work" is defined as any part of Jex that is a source code file (.java, .jar, etc.)

For more information on the license, see: https://www.gnu.org/licenses/gpl-3.0.en.html
*/

import java.util.*;
import java.util.function.*;
//HTML CODE FOR JAVADOC
/**
 * @author RandomKiddo
 * @version Release 1.3.1
 * <br />
 * <br />
 * A tuple is an array-like object which represents a collection of objects.
 * <br />
 * Unlike an array, a tuple is unchangeable upon instantiation.
 * <br />
 * <br />
 * Tuples can be initialized using an array, a List, an ArrayList, or another Tuple (copy constructor).
 * <br />
 * Use static method cast to cast a primitive array to a wrapper array.
 * <br />
 * For example:
 * <br />
 * <code>int[] arr = {1, 2, 3, 4, 5};</code>
 * <br />
 * <code>Tuple&ltInteger&gt tuple = new Tuple&ltInteger&gt(Tuple.cast(arr));</code>
 * <br />
 * Returns arr as an Integer[] instead of an int[]
 * <br />
 * <br />
 * Generic Tuple:
 * <br />
 * <code>Object[] obj = {(Object)1, (Object)2, (Object)3)};</code>
 * <br />
 * <code>Tuple tuple = new Tuple(obj); //Object Tuple (Generic)</code>
 * <br />
 * <br />
 * Dependencies: <br />
 * <code>java.util</code> <br/>
 * <code>java.util.function</code>
 * <br />
 * <br />
 * <u>Changes from Beta 1.3.0:</u>
 * <br />
 * <br />
 * <ul>
 * <li>Updated Documentation</li>
 * </ul>
 * <br />
 */
public class Tuple<T> extends Object implements Comparable<Tuple<T>>, Iterable<T>, RandomAccess, Cloneable{
    //Fields
    private T[] arr;
    /**
     * The length of this tuple, alias to size
     */
    public int length;
    /**
     * The size of this tuple, alias to length
     */
    public int size;
    //Constructors
    /**
     * Constructs a tuple (unchangeable array) of array param a
     * @param a Reference data type array to initialize this tuple to
     * @return a Tuple from the given array
     */
    public Tuple(T[] a){
        this.arr = a;
        this.length = a.length;
        this.size = a.length;
    }
    /**
     * Constructs a tuple (unchangeable array) of list param l
     * @param l List that initializes the values of this tuple
     * @return a Tuple from the given list
     */
    public Tuple(List<T> l){
        Object[] o = new Object[l.size()];
        for (int i = 0; i < l.size(); i++){
            o[i] = l.get(i);
        }
        for (int i = 0; i < o.length; i++){
            this.arr[i] = (T)o[i];
        }
        this.length = l.size();
        this.size = l.size();
    }
    /**
     * Constructs a tuple (unchangeable array) of arraylist param a
     * @param a ArrayList that initializes the values of this tuple
     */
    public Tuple(ArrayList<T> a){
        Object[] o = new Object[a.size()];
        for (int i = 0; i < a.size(); i++){
            o[i] = a.get(i);
        }
        for (int i = 0; i < o.length; i++){
            this.arr[i] = (T)o[i];
        }
        this.length = a.size();
        this.size = a.size();
    }
    /**
     * Constructs a tuple (unchangeable array) of tuple param t
     * @param t Tuple to be copied to this tuple
     */
    public Tuple(Tuple<T> t){
        this.arr = t.arr;
        this.length = t.length;
        this.size = t.size;
    }
    //Methods
    /**
     * Compares the length of this tuple to the length of param other
     * @param other The tuple to be compared to
     * @return An integer representing the comparison
     */
    @Override
    public int compareTo(Tuple<T> other){
        return this.length - other.length;
    }
    /**
     * Compares the length of tuple param one to tuple param two
     * @param one The first tuple to be compared to
     * @param two The second tuple that will be compared to the first
     * @return An integer representing the comparison
     */
    public static int compare(Tuple<? extends Object> one, Tuple<? extends Object> two){
        return one.length - two.length;
    }
    /**
     * Casts an integer array to an Integer array for tuple constructor
     * @param in The int array that will be casted to an Integer array
     * @return An Integer array
     */
    public static Integer[] cast(int[] in){
        Integer[] casted = new Integer[in.length];
        for (int i = 0; i < in.length; i++){
            casted[i] = (Integer)in[i];
        }
        return casted;
    }
    /**
     * Casts a double array to a Double array for tuple constructor
     * @param d The double array that will be casted to an Double array
     * @return A Double array
     */
    public static Double[] cast(double[] d){
        Double[] casted = new Double[d.length];
        for (int i = 0; i < d.length; i++){
            casted[i] = (Double)d[i];
        }
        return casted;
    }
    /**
     * Casts a char array to a Character array for tuple constructor
     * @param c The char array that will be casted to an Character array
     * @return A Character array
     */
    public static Character[] cast(char[] c){
        Character[] casted = new Character[c.length];
        for (int i = 0; i < c.length; i++){
            casted[i] = (Character)c[i];
        }
        return casted;
    }
    /**
     * Casts a long array to a Long array for tuple constructor
     * @param l The long array that will be casted to an Long array
     * @return A Long array
     */
    public static Long[] cast(long[] l){
        Long[] casted = new Long[l.length];
        for (int i = 0; i < l.length; i++){
            casted[i] = (Long)l[i];
        }
        return casted;
    }
    /**
     * Casts a boolean array to a Boolean array for tuple constructor
     * @param b The boolean array that will be casted to an Boolean array
     * @return A Boolean array
     */
    public static Boolean[] cast(boolean[] b){
        Boolean[] casted = new Boolean[b.length];
        for (int i = 0; i < b.length; i++){
            casted[i] = (Boolean)b[i];
        }
        return casted;
    }
    /**
     * Casts a byte array to a Byte array for tuple constructor
     * @param b The byte array that will be casted to an Byte array
     * @return A Byte array
     */
    public static Byte[] cast(byte[] b){
        Byte[] casted = new Byte[b.length];
        for (int i = 0; i < b.length; i++){
            casted[i] = (Byte)b[i];
        }
        return casted;
    }
    /**
     * Casts a short array to a Short array for tuple constructor
     * @param s The short array that will be casted to an Short array
     * @return A Short array
     */
    public static Short[] cast(short[] s){
        Short[] casted = new Short[s.length];
        for (int i = 0; i < s.length; i++){
            casted[i] = (Short)s[i];
        }
        return casted;
    }
    /**
     * Casts a float array to a Float array for tuple constructor
     * @param f The float array that will be casted to an Float array
     * @return A Float array
     */
    public static Float[] cast(float[] f){
        Float[] casted = new Float[f.length];
        for (int i = 0; i < f.length; i++){
            casted[i] = (Float)f[i];
        }
        return casted;
    }
    /**
     * Returns this tuple as a String
     * @return A String of this tuple
     */
    @Override
    public String toString(){
        String str = "(";
        for (int i = 0; i < this.length - 1; i++){
            str += this.arr[i].toString() + ", ";
        }
        str += this.arr[this.length - 1].toString() + ")";
        return str;
    }
    /**
     * Takes in a lambda expression to iterate the tuple
     * @param action The action that is used during iteration
     */
    @Override
    public void forEach(Consumer<? super T> action){
        for (T i : arr){
            action.accept(i);
        }
    }
    /**
     * Takes a predicate expression to iterate the tuple and then proceeds with the action if predicate condition is met
     * @param filter The filter that will filter the items in tuple
     * @param action The action taken if the filter expression is met
     */
    public void forEach(Predicate<? super T> filter, Consumer<? super T> action){
        for (T i : arr){
            if (filter.test(i)){
                action.accept(i);
            }
        }
    }
    /**
     * Takes a predicate expression to iterate the tuple, assumed consumer action is println()
     * @param filter The filter that will filter the items in tuple
     */
    public void forEach(Predicate<? super T> filter){
        for (T i : arr){
            if (filter.test(i)){
                System.out.println(i);
            }
        }
    }
    /**
     * Gets the item at index
     * @param index The index to get the item from this tuple
     * @return The object at the given index
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException{
        return this.arr[index];
    }
    /**
     * Returns true if obj in this tuple, false otherwise
     * @param obj The object being checked if it is in this tuple
     * @return A boolean if the object was found
     */
    public boolean contains(T obj){
        for (T o : this.arr){
            if (o.equals(obj)){
                return true;
            }
        }
        return false;
    }
    /**
     * Gets the index of the first instance of obj in this tuple, returns -1 if not found
     * @param obj The object the method is getting the index of
     * @return An integer representing the index
     */
    public int indexOf(T obj){
        for (int i = 0; i < this.arr.length; i++){
            if (this.arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Returns an iterator for this tuple
     * @return An Iterator instance
     */
    @Override
    public Iterator<T> iterator(){
        return Arrays.asList(this.arr).iterator();
    }
    /**
     * Gets the index of the first instance of param obj in this tuple, starting at the end, returns -1 if not found
     * @param obj The object the method is getting the last index of
     * @return An integer representing the index
     */
    public int lastIndexOf(T obj){
        for (int i = this.arr.length - 1; i >= 0; i--){
            if (this.arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Returns true if this tuple is empty, false otherwise
     * @return True if empty, false otherwise
     */
    public boolean isEmpty(){
        return this.length == 0;
    }
    /**
     * Returns this tuple as an Object array
     * @return An object array
     */
    public Object[] toGenericArray(){
        Object[] o = new Object[this.length];
        for (int i = 0; i < this.arr.length; i++){
            o[i] = (Object)this.arr[i];
        }
        return o;
    }
    /**
     * Returns this tuple as an array
     * @return An array of this tuple's type
     */
    public T[] toArray(){
        return this.arr;
    }
    /**
     * Returns this tuple as an unmodifiable object list
     * @return A generic List instance
     */
    public List toGenericList(){
        ArrayList a = new ArrayList();
        for (int i = 0; i < this.arr.length; i++){
            a.add((Object)this.arr[i]);
        }
        List immutable = Collections.unmodifiableList(a);
        return immutable;
    }
    /**
     * Returns this tuple as an unmodifiable list
     * @return A List instance
     */
    public List<T> toList(){
        ArrayList<T> a = new ArrayList<>();
        for (int i = 0; i < this.arr.length; i++){
            a.add(this.arr[i]);
        }
        List<T> immutable = Collections.unmodifiableList(a);
        return immutable;
    }
    /**
     * Returns this tuple as a modifiable arraylist
     * @return An ArrayList instance
     */
    public ArrayList<T> toArrayList(){
        ArrayList<T> a = new ArrayList<>();
        for (int i = 0; i < this.arr.length; i++){
            a.add(this.arr[i]);
        }
        return a;
    }
    /**
     * Returns this tuple as a modifiable object arraylist
     * @return A generic ArrayList instance
     */
    public ArrayList toGenericArrayList(){
        ArrayList a = new ArrayList();
        for (int i = 0; i < this.arr.length; i++){
            a.add((Object)this.arr[i]);
        }
        return a;
    }
    /**
     * Checks if this tuple is equal to param other
     * @param other The tuple that will be checked against this tuple for equality
     * @return True if equal, false otherwise
     */
    public boolean equals(Tuple<T> other){
        if (other.arr.length != this.arr.length){
            return false;
        }
        for (int i = 0; i < this.arr.length; i++){
            if (!this.arr[i].equals(other.arr[i])){
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a copy of this tuple
     * @return A clone of this tuple
     * @throws CloneNotSupportedException
     */
    @Override
    public Tuple<T> clone() throws CloneNotSupportedException{
        return new Tuple<T>(this.arr);
    }
    /**
     * Returns a new tuple, a combination of this tuple and param two
     * @param two The tuple that will be added to this tuple
     * @return A new tuple
     */
    public Tuple<T> plus(Tuple<T> two){
        Object[] o = new Object[this.length + two.length];
        for (int i = 0; i < this.length; i++){
            o[i] = (Object)this.arr[i];
        }
        for (int i = this.length; i < this.length + two.length; i++){
            o[i] = (Object)two.arr[i];
        }
        ArrayList<T> list = new ArrayList<>();
        for (Object obj : o){
            list.add((T)obj);
        }
        return new Tuple<T>(list);
    }
    /**
     * Compares the number of different items in same positions of tuple param one and two
     * @param one The first tuple to check the number of different items
     * @param two The second tuple that will be checked against the first tuple
     * @return An int comparing the two tuples
     */
    public static int compareNumItems(Tuple<? extends Object> one, Tuple<? extends Object> two){
        int num = 0;
        for (int i = 0, j = 0; i < one.length && j < two.length; i++, j++){
            if (!one.get(i).equals(two.get(i))){
                num++;
            }
        }
        if (one.length > two.length){
            num += (one.length - two.length);
        } else if (one.length < two.length){
            num += (two.length - one.length);
        }
        return num;
    }
    /**
     * Returns the name of the class being contained
     * @return String of the Class container
     */
    public String container(){
        return this.arr[0].getClass().getName();
    }
    /**
     * Returns the class instance of the class being contained
     * @return Class container of this tuple
     */
    public Class<? extends Object> classContainer(){
        return this.arr[0].getClass();
    }
    /**
     * Empty main method
     * @param args Internal call used by Java
     */
    public static final void main(String [] args){
    }
}