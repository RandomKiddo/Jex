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

//HTML CODE FOR JAVADOC
/**
 * @author RandomKiddo
 * @version Alpha 1.0
 * <br />
 * <br />
 * A safe parser that deals with error handling by using default return values.
 * These default return values can either be passed in as parameters, or be
 * decided by default.
 * <br />
 * All primitives are included in this class except for char, as char parsing
 * may be done without the need for error handling.
 */
public class Parse extends Object {
    //Methods
    /**
     * Parses the String to an int
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static int tryParseInt(String str, int defaultValue) {
        try {
            Integer value = Integer.parseInt(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an int, returns 0 if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static int tryParseInt(String str) {
        return tryParseInt(str, 0);
    }
    /**
     * Parses the String to an double
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static double tryParseDouble(String str, double defaultValue) {
        try {
            Double value = Double.parseDouble(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an double, returns 0.0 if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static double tryParseDouble(String str) {
        return tryParseDouble(str, 0.0);
    }
    /**
     * Parses the String to an float
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static float tryParseFloat(String str, float defaultValue) {
        try {
            Float value = Float.parseFloat(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an float, returns 0.0f if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static float tryParseFloat(String str) {
        return tryParseFloat(str, 0.0f);
    }
    /**
     * Parses the String to an long
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static long tryParseLong(String str, long defaultValue) {
        try {
            Long value = Long.parseLong(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an long, returns 0L if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static long tryParseLong(String str) {
        return tryParseLong(str, 0L);
    }
    /**
     * Parses the String to an short
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static short tryParseShort(String str, short defaultValue) {
        try {
            Short value = Short.parseShort(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an short, returns (short)0 if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static short tryParseShort(String str) {
        return tryParseShort(str, (short)0);
    }
    /**
     * Parses the String to an boolean
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static boolean tryParseBoolean(String str, boolean defaultValue) {
        try {
            Boolean value = Boolean.parseBoolean(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an boolean, returns false if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static boolean tryParseBoolean(String str) {
        return tryParseBoolean(str, false);
    }
    /**
     * Parses the String to an byte
     * @param str The string to parse
     * @param defaultValue The value to return if an error is caught
     * @return The value parsed
     */
    public static byte tryParseByte(String str, byte defaultValue) {
        try {
            Byte value = Byte.parseByte(str);
            return value;
        } catch (NumberFormatException nferr) {
            return defaultValue;
        }
    }
    /**
     * Parses the String to an byte, returns (byte)0 if an error is caught
     * @param str The string to parse
     * @return The value parsed
     */
    public static byte tryParseByte(String str) {
        return tryParseByte(str, (byte)0);
    }
}