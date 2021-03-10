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

/**
 * THIS FILE IS FOR TEST PURPOSES ONLY!
 */
public class Test {
    public static void main(String[] args) {
        String format = "Hello {}! I am {}, and {} is my job.";
        StringFormat sformat = new StringFormat(format);
        String formatted = sformat.format("Jane", "John", "carpenter");
        System.out.println(formatted);
    }
}