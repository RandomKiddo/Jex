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

//HTML CODE FOR JAVADOC

/**
 * @author RandomKiddo
 * @version Alpha 1.0
 * <br />
 * <br />
 * Allows for prettier formatting of Strings for printing, or other purposes.
 * A format String is defined as follows: A normal String with an escape character
 * <code>{}</code> that is a placeholder for variables to be formatted within the
 * format String. An example would be: <code>"Hello {}! How are you?</code>.
 * Then using <code>.format(String... args)</code>, the variable String "RandomKiddo" could
 * be formatted into the format String, for example.
 * <br />
 * <br />
 * Dependencies: <br />
 * <code>java.util</code>
 */
public class StringFormat extends Object {
    //Fields
    private String format;
    //Constructors

    /**
     * Initializes a new StringFormat
     * @param format The format for this StringFormat
     */
    public StringFormat(String format) {
        this.format = format;
    }
    //Methods

    /**
     * Returns a String representation of this StringFormat
     * @return The String representation
     */
    @Override
    public String toString() {
        return this.format;
    }

    /**
     * Gets this format
     * @return The format of this StringFormat
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * Formats the given arguments onto the format
     * @param args The arguments to format
     * @return The built String
     */
    public String format(String... args) {
        String[] breakPoints = breakString();
        String built = "";
        int trackedIndex = 0;
        for (int i = 0; i < breakPoints.length; i++) {
            if (trackedIndex < args.length && trackedIndex <= breakPoints.length-2) {
                built += breakPoints[i] + args[trackedIndex];
                ++trackedIndex;
            } else {
                built += breakPoints[i];
            }
        }
        return built;
    }
    private String[] breakString() {
        int index = this.format.indexOf("{}");
        String copy = this.format;
        ArrayList<String> breakPoints = new ArrayList<String>();
        while (index != -1) {
            String substring = copy.substring(0, index);
            copy = copy.substring(index+2);
            breakPoints.add(substring);
            index = copy.indexOf("{}");
        }
        breakPoints.add(copy);
        return toStringArray(breakPoints.toArray());
    }
    private String[] toStringArray(Object[] obj) {
        String[] arr = new String[obj.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = obj[i].toString();
        }
        return arr;
    }
}