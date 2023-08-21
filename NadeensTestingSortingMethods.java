package LA2Q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class NadeensTestingSortingMethods {

    //main method
    public static void main(String [] args) {

        //call header method
        myHeader(2,1);

        //declare and instantiate the size of the array
        int sz = 50000;

        //declare and instantiate a main array and It's backup
        Integer[] arr = new Integer[sz];
        Integer[] backUp = new Integer[sz];

        //populate the main array with random values from 13 to 93 inclusive using the Math.random method
        for (int i = 0; i < sz; i++) {
            arr[i] = (int) (Math.random() * (24)) + 13;
        }

        //copy content of the main array to the backup array
        System.arraycopy(arr, 0, backUp, 0, sz);

        //create a list for the array
        List<Integer> arrList = Arrays.asList(arr);

        //output the unsorted list using the list's toString() method
        //System.out.println("The unsorted list: " + arrList);

        //start the timer
        long beginTime = System.nanoTime();

        //sort the list using the Collections.sort method
        Collections.sort(arrList);

        //end the timer
        long endTime = System.nanoTime();

        //calculate the time difference
        long timeDifference = endTime - beginTime;

        //output the sorted list and the time it took for the Collections.sort method to sort the list
        System.out.printf("Collection's Sort Time: %.2f milliseconds\n",(timeDifference*1e-6));
        //System.out.println("The sorted list using Collection's Sort method: " + arrList);
        System.out.println();

        //copy the backup array to the main array (to sort the same unsorted array every time)
        System.arraycopy(backUp,0,arr,0,sz);

        //call the selectionSort method, and then output the sorted list and the time it took to sort the list
        //System.out.println("The unsorted list: " + arrList);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n",(float)selectionSort(arr)*1e-6);
        //System.out.println("The sorted list using Selection Sort method: " + arrList);
        System.out.println();

        //copy the backup array to the main array (to sort the same unsorted array every time)
        System.arraycopy(backUp,0,arr,0,sz);

        //call the bubbleSort method, and then output the sorted list and the time it took to sort the list
        //System.out.println("The unsorted list: " + arrList);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n",(float)bubbleSort(arr)*1e-6);
        //System.out.println("The sorted list using Bubble Sort method: " + arrList);
        System.out.println();

        //copy the backup array to the main array (to sort the same unsorted array every time)
        System.arraycopy(backUp,0,arr,0,sz);


        //call the insertionSort method, and then output the sorted list and the time it took to sort the list
        //System.out.println("The unsorted list: " + arrList);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n",(float)insertionSort(arr)*1e-6);
        //System.out.println("The sorted list using Insertion Sort method: " + arrList);
        System.out.println();

        //copy the backup array to the main array (to sort the same unsorted array every time)
        System.arraycopy(backUp,0,arr,0,sz);

        //call the mergeSort method, and then output the sorted list and the time it took to sort the list
        //System.out.println("The unsorted list: " + arrList);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n",(float)mergeSort(arr)*1e-6);
        //System.out.println("The sorted list using Merge Sort method: " + arrList);
        System.out.println();

        //copy the backup array to the main array (to sort the same unsorted array every time)
        System.arraycopy(backUp,0,arr,0,sz);

        //call the quickSort method, and then output the sorted list and the time it took to sort the list
        //System.out.println("The unsorted list: " + arrList);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n",(float)quickSort(arr,0,sz-1)*1e-6);
        //System.out.println("The sorted list using Quick Sort method: " + arrList);
        System.out.println();

        //copy the backup array to the main array (to sort the same unsorted array every time)
        System.arraycopy(backUp,0,arr,0,sz);

        //call the bucketSort method, and then output the sorted list and the time it took to sort the list
        //System.out.println("The unsorted list: " + arrList);
        System.out.printf("My Bucket-Sort Time %.2f milliseconds\n",(float)bucketSort(arr,0,sz-1,2)*1e-6);
        //System.out.println("The sorted list using Bucket Sort method: " + arrList);
        System.out.println();

        //call footer method
        myFooter(2,1);
    }

    //selection sort method
    public static <T extends Comparable <? super T>>long selectionSort (T [] a){

        //start the timer
        long beginTime = System.nanoTime();
        int n = a.length;

        for (int i = 0; i < n-1; i++)
        {
            //search for index with the minimum value
            int indexOfNextSmallest = i;
            for (int j = i+1; j < n; j++) {
                if (a[j].compareTo(a[indexOfNextSmallest])<0) {
                    indexOfNextSmallest = j;
                }
            }

            //swap the minimum element with current element
            T temp = a[indexOfNextSmallest];
            a[indexOfNextSmallest] = a[i];
            a[i] = temp;
        }

        //end the timer
        long endTime = System.nanoTime();
        long timeDifference = endTime - beginTime;

        //return the time difference
        return timeDifference;
    }


    //the bubble sort method
    public static < T extends Comparable < ? super T >> long bubbleSort(T[] a) {

        //begin the timer
        long beginTime = System.nanoTime();
        int n = a.length;

        //steps through the data-set from one end to the other and compares adjacent pairs of elements
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < n - i; j++)
            {
                //elements are swapped if they are in the incorrect order (for ascending)
                if (a[j].compareTo(a[j + 1])>0)
                {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        //end the timer
        long endTime = System.nanoTime();
        long timeDifference = endTime - beginTime;

        //return the time difference
        return timeDifference;

    }

    //the insertion sort method
    public static < T extends Comparable <? super T >> long insertionSort(T[] a) {

        //begin the timer
        long beginTime = System.nanoTime();
        int n = a.length;
        int i = 0, j = 0;


        //iterate through the array using a for loop
        for (i = 1; i < n; i++)
        {
            T key = a[i];

            //compare the key with its predecessor elements and then move the elements that are greater than the key one index up
            for (j = i - 1; (j >= 0) && (a[j].compareTo(key) > 0); j--)
            {
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }

        //end the timer
        long endTime = System.nanoTime();
        long timeDifference = endTime - beginTime;

        //return the time difference
        return timeDifference;
    }

    //the merge sort method
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {

        //begin the timer
        long beginTime = System.nanoTime();
        int n = S.length;

        //base case; return if the array is already sorted
        if (n < 2) {
            long endTime = System.nanoTime();
            return (endTime - beginTime);
        }

        // find the middle of the array
        int mid = n / 2;

        //copy the first half of the array into a separate array
        T[] S1 = Arrays.copyOfRange(S, 0, mid);

        //copy the second half of the array into a separate array
        T[] S2 = Arrays.copyOfRange(S, mid, n);


        // conquering
        //sort the first half of the array using recursion
        mergeSort(S1);

        //sort the second half of the array using recursion
        mergeSort(S2); // sort copy of second half


        // combine the two already sorted parts into whole once again in the original array
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && (S1[i].compareTo(S2[j]) < 0))) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }

        //end the timer
        long endTime = System.nanoTime();
        long timeDifference = endTime - beginTime;

        //return the time difference
        return timeDifference;
    }


    //the quick sort method
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b)
    {
        //start the timer
        long beginTime = System.nanoTime();

        //return if a is greater than or equal to b
        if(a>=b)
        {
            long endTime = System.nanoTime();
            return (endTime - beginTime);
        }

        //set the pivot to the element at the end
        T pivot = s[b];
        int l = a;//place for swapping

        //traverse through the array
        for (int k = a; k < b; k++)
        {
            if(s[k].compareTo(pivot)<0){ //compare if current element is lower than the pivot, and swap if they are

                T temp = s[l];
                s[l] = s[k];
                s[k]=temp;
                l++; //increment swap position, l
            }
        }

        //swap the element at the swap position with the element at the end
        T temp = s[l];
        s[l] = s[b];
        s[b] = temp;

        //recursively call the quickSort method with parameters, l-1 and l+1
        quickSort(s,a,l-1);
        quickSort(s,l+1,b);

        //end the timer
        long endTime = System.nanoTime();
        long timeDifference = endTime - beginTime;

        //return the time difference
        return timeDifference;
    }

    //the bucket sort method
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {

        //start the timer
        long beginTime = System.nanoTime();

        //create ten buckets using the the Vector class
        Vector<Integer>[] bucket = new Vector[10];

        //instantiate each bucket
        for (int i = 0; i < 10; i++)
        {
            bucket[i] = new Vector<>();
        }

        for (int i = 0; i < maxDigits; i++)
        {
            //remove all  the elements from the Vector buckets using the removeAllElements() method
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }

            //insert a[index] at the end of bucket[digit]
            for (int index = first; index <= last; index++) {

                //instantiate an Integer called digit by calling the findDigit method
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }

            //return all the Vector buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++)
            {
                for (int n = 0; n < bucket[m].size(); n++)
                {
                    a[index++] = bucket[m].get(n);
                }
            }
        }

        //end timer
        long endTime = System.nanoTime();
        long timeDifference = endTime - beginTime;

        //return the time difference
        return timeDifference;
    }

    //the findDigit method takes the "ith" digit from a decimal number
    public static Integer findDigit(int number, int i)
    {
        int target = 0;

        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    //header method
    public static void myHeader(int labNum, int qNum)
    {
        //displays a formatted header
        System.out.printf("======================================\nLab Assignment %d,Q%d\nPrepared By: Nadeen Shilbayeh\n" +
                "Student Number: 251213277\nGoal of this exercise: Implement different sorting techniques and time them\n======================================\n", labNum, qNum);
    }

    //footer method
    public static void myFooter(int labNum, int qNum) {
        //displays a formatted footer
        System.out.printf("\n======================================\nCompletion of Lab Assignment %d,Q%d is successful!" +
                "\nSigning off - Nadeen Shilbayeh\n======================================\n", labNum, qNum);
    }
}
