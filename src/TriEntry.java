/*
Jex, Copyright 2021 RandomKiddo

This work is licensed under the GNU General Public License (or GNU GPL), version 3.0
This program comes with ABSOLUTELY NO WARRANTY
This is a free software, and you are welcome to modify and redistribute it under certain conditions.

The current maintainer of this work is RandomKiddo
The "work" is defined as any part of Jex that is a source code file (.java, .jar, etc.)

For more information on the license, see: https://www.gnu.org/licenses/gpl-3.0.en.html
*/

//HTML CODE FOR JAVADOC
/**
 * @author RandomKiddo
 * @version Alpha 1.0
 * <br />
 * <br />
 * Represents a map entry with three values for a <code>TriMap</code>
 * <br />
 * <br />
 * Instantiation: <br />
 * <code>TriEntry<T, U, V> entry = new TriEntry<T, U, V>(T t, U u, V v);</code>
 */
public class TriEntry<T, U, V> extends Object implements Cloneable {
    //Fields
    private T tObj;
    private U uObj;
    private V vObj;
    //Constructors
    /**
     * Constructs a new TriEntry
     * @param t An object of type T
     * @param u An object of type U
     * @param v An object of type V
     */
    public TriEntry(T t, U u, V v) {
        this.tObj = t;
        this.uObj = u;
        this.vObj = v;
    }
    private TriEntry(TriEntry<T, U, V> entry) {
        this.tObj = entry.tObj;
        this.uObj = entry.uObj;
        this.vObj = entry.vObj;
    }
    //Methods
    /**
     * Returns this TriEntry as a String
     * @return A String representation of this TriEntry instance
     */
    @Override
    public String toString() {
        return "TriEntry<" + this.tObj.toString() + ", " + this.uObj.toString() + ", " + this.vObj.toString() + ">";
    }
    /**
     * Returns a copy of this TriEntry
     * @return A TriEntry instance
     * @throws CloneNotSupportedException
     */
    @Override
    public TriEntry<T, U, V> clone() throws CloneNotSupportedException {
        return new TriEntry(this);
    }
    /**
     * Returns the first value in the key
     * @return The first object T of the key
     */
    public T getFirst() {
        return this.tObj;
    }
    /**
     * Returns the second value in the key
     * @return The second object U of the key
     */
    public U getSecond() {
        return this.uObj;
    }
    /**
     * Returns the third value in the key
     * @return The third object V of the key
     */
    public V getThird() {
        return this.vObj;
    }
}