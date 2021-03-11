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
 * @version Alpha 1.0 Untested
 * <br />
 * <br />
 * Converts between decimal, binary, octal, and hexadecimal number systems.
 * All methods are static, and take String parameters, and return a String.
 */
public class NumberSystemConverter extends Object {
    private static String string(int[] value) {
        String str = "";
        for (int i : value) {
            str += i;
        }
        return str;
    }
    /**
     * Converts a decimal String to binary String
     * @param decimal The decimal String
     * @return The binary String
     * @throws NumberFormatException
     */
    public static String decimalToBinary(String decimal) throws NumberFormatException {
        int value = Integer.parseInt(decimal);
        int[] binary = new int[40];
        int index = 0;
        while (value > 0) {
            binary[index++] = value % 2;
            value /= 2;
        }
        return string(binary);
    }
    /**
     * Converts a decimal String to an octal String
     * @param decimal The decimal String
     * @return The octal String
     * @throws NumberFormatException
     */
    public static String decimalToOctal(String decimal) throws NumberFormatException {
        int value = Integer.parseInt(decimal);
        int[] octal = new int[100];
        int i = 0;
        while (value != 0) {
            octal[i] = value % 8;
            value /= 8;
            ++i;
        }
        return string(octal);
    }
    /**
     * Converts a decimal String to a hexadecimal String
     * @param decimal The decimal String
     * @return The hexadecimal String
     * @throws NumberFormatException
     */
    public static String decimalToHexadecimal(String decimal) throws NumberFormatException {
        int value = Integer.parseInt(decimal);
        int[] hex = new int[100];
        int i = 0;
        while (value != 0) {
            hex[i] = value % 16;
            value /= 16;
            ++i;
        }
        String hexString = "";
        for (int j = i-1; j >= 0; --j) {
            if (hex[j] > 9) {
                hexString += (char)(55 + hex[j]);
            } else {
                hexString += hex[j];
            }
        }
        return hexString;
    }
    /**
     * Converts a binary String to a decimal String
     * @param binary The binary String
     * @return The decimal String
     * @throws NumberFormatException
     */
    public static String binaryToDecimal(String binary) throws NumberFormatException {
        long value = Long.parseLong(binary);
        int decimal = 0, i = 0;
        while (value > 0) {
            decimal += Math.pow(2, i++) * (value % 10);
            value /= 10;
        }
        return ((Integer)decimal).toString();
    }
    /**
     * Converts a binary String to an octal String
     * @param binary The binary String
     * @return The octal String
     * @throws NumberFormatException
     */
    public static String binaryToOctal(String binary) throws NumberFormatException {
        String decimal = binaryToDecimal(binary);
        return decimalToOctal(decimal);
    }
    /**
     * Converts a binary String to a hexadecimal String
     * @param binary The binary String
     * @return The hexadecimal String
     * @throws NumberFormatException
     */
    public static String binaryToHexadecimal(String binary) throws NumberFormatException {
        String decimal = binaryToDecimal(binary);
        return decimalToHexadecimal(decimal);
    }
    /**
     * Converts an octal String to a decimal String
     * @param octal The octal String
     * @return The decimal String
     * @throws NumberFormatException
     */
    public static String octalToDecimal(String octal) throws NumberFormatException {
        int value = Integer.parseInt(octal);
        int decimal = 0;
        int base = 1;
        while (value > 0) {
            int lastDigit = value % 10;
            value /= 10;
            decimal += lastDigit * base;
            base *= 8;
        }
        return ((Integer)decimal).toString();
    }
    /**
     * Converts an octal String to a binary String
     * @param octal The octal String
     * @return The binary String
     * @throws NumberFormatException
     */
    public static String octalToBinary(String octal) throws NumberFormatException {
        String decimal = octalToDecimal(octal);
        return decimalToBinary(decimal);
    }
    /**
     * Converts an octal String to a hexadecimal String
     * @param octal The octal String
     * @return The hexadecimal String
     * @throws NumberFormatException
     */
    public static String octalToHexadecimal(String octal) throws NumberFormatException {
        String decimal = octalToDecimal(octal);
        return decimalToHexadecimal(decimal);
    }
    /**
     * Converts a hexadecimal String to a decimal String
     * @param hexadecimal The hexadecimal String
     * @return The decimal String
     * @throws NumberFormatException
     */
    public static String hexadecimalToDecimal(String hexadecimal) throws NumberFormatException {
        int base = 1;
        int decimal = 0;
        for (int i = hexadecimal.length()-1; i>= 0; --i) {
            if (hexadecimal.charAt(i) >= '0' && hexadecimal.charAt(i) <= '9') {
                decimal += (hexadecimal.charAt(i) - 48) * base;
                base *= 16;
            } else if (hexadecimal.charAt(i) >= 'A' && hexadecimal.charAt(i) <= 'F') {
                decimal += (hexadecimal.charAt(i) - 55) * base;
                base *= 16;
            }
        }
        return ((Integer)decimal).toString();
    }
    /**
     * Converts a hexadecimal String to a binary String
     * @param hexadecimal The hexadecimal String
     * @return The binary String
     * @throws NumberFormatException
     */
    public static String hexadecimalToBinary(String hexadecimal) throws NumberFormatException {
        String decimal = hexadecimalToDecimal(hexadecimal);
        return decimalToBinary(decimal);
    }
    /**
     * Converts a hexadecimal String to an octal String
     * @param hexadecimal The hexadecimal String
     * @return The octal String
     * @throws NumberFormatException
     */
    public static String hexadecimalToOctal(String hexadecimal) throws NumberFormatException {
        String decimal = hexadecimalToDecimal(hexadecimal);
        return decimalToOctal(decimal);
    }
}