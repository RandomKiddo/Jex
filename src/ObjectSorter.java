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
 * A make-shift Object array sorter using the Object's class default
 * <code>hashCode</code> method. Comparison between Object instances
 * are done using that method. This class implemented different
 * sorting algorithms.
 * <br />
 * <br />
 * Sorting Algorithms Implemented: <br />
 * Selection Sort <br />
 * Bubble Sort <br />
 * Recursive Bubble Sort <br />
 * Insertion Sort <br />
 * Recursive Insertion Sort <br />
 * Merge Sort <br />
 * Quick Sort
 */
public class ObjectSorter extends Object {
    /**
     * Sorts an Object array using selection sort
     * @param arr The array to sort
     */
    public static void selectionSort(Object[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j].hashCode() < arr[index].hashCode()) {
                    index = j;
                }
                Object copy = arr[index];
                arr[index] = arr[i];
                arr[i] = copy;
            }
        }
    }
    /**
     * Sorts an Object array using bubble sort
     * @param arr The array to sort
     */
    public static void bubbleSort(Object[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j].hashCode() > arr[j+1].hashCode()) {
                    Object copy = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = copy;
                }
            }
        }
    }
    /**
     * Sorts an Object array using recursive bubble sort
     * @param arr The array to sort
     */
    public static void recursiveBubbleSort(Object[] arr, int length) {
        if (length == 1) {
            return; //base case
        }
        for (int i = 0; i < length - 1; ++i) {
            if (arr[i].hashCode() > arr[i+1].hashCode()) {
                Object copy = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = copy;
            }
        }
        recursiveBubbleSort(arr, length-1);
    }
    /**
     * Sorts an Object array using insertion sort
     * @param arr The array to sort
     */
    public static void insertionSort(Object[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            Object key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].hashCode() > key.hashCode()) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }
    /**
     * Sorts an Object array using recursive insertion sort
     * @param arr The array to sort
     */
    public static void recursiveInsertionSort(Object[] arr, int length) {
        if (length <= 1) {
            return; //base case
        }
        recursiveInsertionSort(arr, length-1);
        Object last = arr[length-1];
        int j = length - 2;
        while (j >= 0 && arr[j].hashCode() > last.hashCode()) {
            arr[j+1] = arr[j];
            --j;
        }
        arr[j+1] = last;
    }
    /**
     * Sorts an Object array using merge sort
     * @param arr The array to sort
     */
    public static void mergeSort(Object[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r-1) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    private static void merge(Object[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        Object L[] = new Object[n1];
        Object R[] = new Object[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l+i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m+1+j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].hashCode() <= R[j].hashCode()) {
                arr[k] = L[i];
                ++i;
            } else {
                arr[k] = R[j];
                ++j;
            }
            ++k;
        }
        while (i < n1) {
            arr[k] = L[i];
            ++i;
            ++k;
        }
        while (j < n2) {
            arr[k] = R[j];
            ++j;
            ++k;
        }
    }
    /**
     * Sorts an Object array using quick sort
     * @param arr The array to sort
     */
    public static void quickSort(Object[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);
            quickSort(arr, begin, partition-1);
            quickSort(arr, partition+1, end);
        }
    }
    private static int partition(Object[] arr, int begin, int end) {
        Object pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; ++j) {
            if (arr[j].hashCode() <= pivot.hashCode()) {
                ++i;
                Object copy = arr[i];
                arr[i] = arr[j];
                arr[j] = copy;
            }
        }
        Object copy = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = copy;
        return i + 1;
    }
}