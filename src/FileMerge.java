/*
Jex, Copyright 2021 RandomKiddo

This work is licensed under the GNU General Public License (or GNU GPL), version 3.0
This program comes with ABSOLUTELY NO WARRANTY
This is a free software, and you are welcome to modify and redistribute it under certain conditions.

The current maintainer of this work is RandomKiddo
The "work" is defined as any part of Jex that is a source code file (.java, .jar, etc.)

For more information on the license, see: https://www.gnu.org/licenses/gpl-3.0.en.html
*/

import java.io.*;
import java.util.*;

//HTML CODE FOR JAVADOC
/**
 * @author RandomKiddo
 * @version Alpha 1.0
 * <br />
 * <br />
 * A file merger that can either merge files vertically (append one file to another), or
 * alternatively (merge one line at a time). This class uses the use of the Java
 * PrintWriter class, and it should be noted that IOExceptions are thrown in all public
 * methods.
 * <br />
 * <br />
 * Instantiation: <br />
 * <code>FileMerge merger = new FileMerge(String fnOut, String fn1, String fn2);</code> <br />
 * <code>FileMerge merger = new FileMerge(String fnOut, File f1, File f2);</code>
 * <br />
 * <br />
 * Dependencies: <br />
 * <code>java.util</code> <br />
 * <code>java.io</code>
 */
public class FileMerge extends Object {
    //Fields
    private File fileIn1, fileIn2;
    private FileWriter fileOut;
    private PrintWriter printer;
    //Constructors
    /**
     * Constructs a new FileMerge instance
     * @param fnOut The filename / directory to write the new merged file
     * @param fn1 The filename / directory of the first file
     * @param fn2 The filename / directory of the second file
     * @throws IOException
     */
    public FileMerge(String fnOut, String fn1, String fn2) throws IOException {
        this.fileOut = new FileWriter(fnOut);
        this.fileIn1 = new File(fn1);
        this.fileIn2 = new File(fn2);
        this.printer = new PrintWriter(this.fileOut);
    }
    /**
     * Constructs a new FileMerge instance
     * @param fnOut The filename / directory to write the new merged file
     * @param f1 The File instance of the first file
     * @param f2 The File instance of the second file
     * @throws IOException
     */
    public FileMerge(String fnOut, File f1, File f2) throws IOException {
        this.fileOut = new FileWriter(fnOut);
        this.fileIn1 = f1;
        this.fileIn2 = f2;
        this.printer = new PrintWriter(this.fileOut);
    }
    //Methods
    /**
     * Merges two files vertically (appends second file to first file)
     * @throws IOException
     */
    public void mergeVertical() throws IOException {
        Scanner reader = new Scanner(this.fileIn1);
        while (reader.hasNextLine()) {
            this.printer.println(reader.nextLine());
        }
        reader = new Scanner(this.fileIn2);
        while (reader.hasNextLine()) {
            this.printer.println(reader.nextLine());
        }
    }
    /**
     * Merges two files, alternating line by line
     * @throws IOException
     */
    public void mergeAlternate() throws IOException {
        Scanner reader1 = new Scanner(this.fileIn1);
        Scanner reader2 = new Scanner(this.fileIn2);
        ArrayList<String> lines1 = new ArrayList<String>();
        ArrayList<String> lines2 = new ArrayList<String>();
        while (reader1.hasNextLine()) {
            lines1.add(reader1.nextLine());
        }
        while (reader2.hasNextLine()) {
            lines2.add(reader2.nextLine());
        }
        ArrayList<String> merged = combineLists(lines1, lines2);
        for (String line : merged) {
            this.printer.println(line);
        }
    }
    private ArrayList<String> combineLists(ArrayList<String> lines1, ArrayList<String> lines2) {
        ArrayList<String> merged = new ArrayList<String>();
        int i = 0, j = 0, tracker = 1;
        while (i <= lines1.size() && j <= lines2.size()) {
            if (tracker % 2 != 0) {
                try {
                    merged.add(lines1.get(i));
                } catch (IndexOutOfBoundsException err) {
                    //do nothing
                }
                ++i;
            } else if (tracker % 2 == 0){
                try {
                    merged.add(lines2.get(j));
                } catch (IndexOutOfBoundsException err) {
                    //do nothing
                }
                ++j;
            } else;
            ++tracker;
        }
        if (lines1.size() > lines2.size()) {
            for (int k = i; k < lines1.size(); ++k) {
                merged.add(lines1.get(k));
            }
        } else if (lines2.size() > lines1.size()) {
            for (int k = j; k < lines2.size(); ++k) {
                merged.add(lines2.get(k));
            }
        } else;
        return merged;
    }
}