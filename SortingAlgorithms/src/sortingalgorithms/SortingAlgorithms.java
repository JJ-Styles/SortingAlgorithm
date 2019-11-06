package sortingalgorithms;
// Program to generate an array of random integers and sort it using
// different methods.
//
// ADS class
// February 2018

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingAlgorithms {

    static final int arraySize = 20;
    static final int maxValue = 50;
    static final int MAX = 32767;
    static Integer counterC = 0;
    static Integer counterS = 0;

    static int[] dataArray = new int[arraySize];
    static int[] temp = new int[arraySize];

    public static void main(String[] args) {
        Integer[] data = new Integer[arraySize];
        
        for (int i = 0; i < arraySize; i++)
        {
            data[i] = dataArray[i];
        }
        
        // Bubble sort
        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        bubbleSort();
        printArrayContents("Bubble			");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;

        // Bubble sort optimised
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        bubbleSort_opt();
        printArrayContents("Bubble opt		");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;

        // Cocktail Shaker sort
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        shakerSort();
        printArrayContents("Shaker			");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;

        // Cocktail Shaker sort optimised
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        shakerSort_opt();
        printArrayContents("Shaker opt		");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;

        // Shuttle sort optimised
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        shuttleSort();
        printArrayContents("Shuttle			");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;

        // Selection Sort
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        selectionSort(0);
        printArrayContents("Selection			");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;
        
        // Shuttle sort optimised
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        
        if (dataArray[0] > dataArray[1])
        {
            swap(dataArray,0,1);
            counterS += 3;
            counterC += 1;
        }
        
        insertionSort(2);
        printArrayContents("Insertion			");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;
        
        // Bucket Sort
//        generateData(maxValue);
        copyArray();
        printArrayContents("\nUnsorted		");

        System.out.println("Sorting...");
        sort(data,5);
        printArrayContents("Bucket			");
        System.out.println("Comparrison Counts: " + counterC.toString());
        System.out.println("Assignments Counts: " + counterS.toString());
        counterC = 0;
        counterS = 0;
    }

    static void generateData(int maxDataValue) {
        Random randomGenerator = new Random();
//
        for (int i = 0; i < arraySize; i++) {
            temp[i] = randomGenerator.nextInt(maxDataValue);
//            temp[i] = 0;
        }
    }

    static void copyArray() {
        for (int i = 0; i < arraySize; i++) {
            dataArray[i] = temp[i];
        }
    }

    static void printArrayContents(String labelText) {
        System.out.print(labelText + " Array contents : { ");

        for (int i = 0; i < arraySize; i++) {
            System.out.print(dataArray[i] + " ");
        }

        System.out.println("}");
    }

    static void swap(int[] a, int k, int l) {
        int temp = a[k];
        a[k] = a[l];
        a[l] = temp;
    }

    // SORTING ALGORITHMS ###########################
    // bubble Sort
    static void bubbleSort() {
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < (arraySize - i - 1); j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    swap(dataArray, j, j + 1);
                    counterS += 3;
                }
                counterC += 1;
            }
        }
    }

    // bubble Sort optimized
    static void bubbleSort_opt() {
        boolean swapOccured = true;

//        while (swapOccured == true) {
        for (int i = 0; i < arraySize - 1; i++) {
            swapOccured = false;
            for (int j = 0; j < (arraySize - i - 1); j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    swap(dataArray, j, j + 1);
                    counterS += 3;
                    swapOccured = true;
                }
                counterC += 1;
            }
            if (!swapOccured) {
                break;
            }
        }
//        }
    }

    // CocktailShaker Sort
    static void shakerSort() {
        for (int i = 0; i < arraySize / 2; i++) {
            for (int j = i; j < (arraySize - i - 1); j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    swap(dataArray, j, j + 1);
                    counterS += 3;
                }
                counterC += 1;
            }

            for (int j = (arraySize - i - 2); j > i; j--) {
                if (dataArray[j] < dataArray[j - 1]) {
                    swap(dataArray, j, j - 1);
                    counterS += 3;
                }
                counterC += 1;
            }
        }
    }

    // CocktailShaker Sort optimized
    static void shakerSort_opt() {
        boolean swapOccured = true;

//        while (swapOccured == true) {
        for (int i = 0; i < arraySize / 2; i++) {
            swapOccured = false;
            for (int j = i; j < (arraySize - i - 1); j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    swap(dataArray, j, j + 1);
                    counterS += 3;
                    swapOccured = true;
                }
                counterC += 1;
            }

            for (int j = (arraySize - i - 2); j > i; j--) {
                if (dataArray[j] < dataArray[j - 1]) {
                    swap(dataArray, j, j - 1);
                    counterS += 3;
                    swapOccured = true;
                }
                counterC += 1;
            }
            if (!swapOccured) {
                break;
            }
        }
//        }
    }

    // ShuttleShaker Sort
    static void shuttleSort() {
        for (int i = 0; i < arraySize - 1; i++) {
            if (dataArray[i] > dataArray[i + 1]) {
                for (int j = i + 1; j > 0; j--) {
                    if (dataArray[j] < dataArray[j - 1]) {
                        swap(dataArray, j, j - 1);
                        counterS += 3;
                    } 
                    else {
                        break;
                    }
                    counterC += 1;
                }
            }
            counterC += 1;
        }
    }

    static void selectionSort(int low)
    {
        int z = low, smallest = dataArray[low];
        
        for (int i = low; i < dataArray.length; i++)
        {
            if (smallest > dataArray[i])
            {
                z = i;
                smallest = dataArray[i];
            }
            counterC +=1;
        }    
        
        swap(dataArray,z,low);
        counterS += 3;

        if (low != dataArray.length-1)
        {
            selectionSort(low+1);
        }

    }
    
    static void insertionSort(int unsorted)
    {
        int temp = dataArray[unsorted];
        
        if (dataArray[unsorted -1] > dataArray[unsorted])
        {
            for (int i = 0; i < unsorted; i++)
            {
                if (dataArray[i] > dataArray[unsorted])
                {
                    for (int j = unsorted; j > i; j--)
                    {
                        dataArray[j] = dataArray[j-1];
                        counterS += 1;
                    }
                    dataArray[i] =temp;
                    counterS += 1;
                    counterC +=1;
                    break;
                }
                counterC +=1;
            }
        }
        counterC += 1;
        
        if (unsorted != (dataArray.length-1))
        {
            insertionSort(unsorted+1);
        }
    }
    
    static void sort(Integer[] array, int bucketSize) {
        if (array.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        Integer minValue = array[0];
        Integer maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
            counterC += 1;
        }

        // Initialise buckets
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Distribute input array values into buckets
        for (int i = 0; i < array.length; i++) {
            buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
        }

        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            insertionSortBucket(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }
    }
    
    static void insertionSortBucket(Integer arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    
}// end of class
