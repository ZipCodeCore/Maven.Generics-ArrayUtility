package com.zipcodewilmington.arrayutility;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */

    public class ArrayUtility<T> {

    private T[] inputArray;

    public ArrayUtility(T[] array) {
        this.inputArray = array;
    }

    public T[] mergeArrays(T[] inputArray, T[] newArray) {
        T[] finalArray = Arrays.copyOf(inputArray, inputArray.length + newArray.length);

        System.arraycopy(newArray, 0, finalArray, inputArray.length, newArray.length);

        return finalArray;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(inputArray, arrayToMerge);
        Integer counter = 0;
        for (int i = 0; i < mergedArray.length; i++)
            if (mergedArray[i].equals(valueToEvaluate)) {
                counter++;
            }


        return counter;

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToEvaluate)) {
                counter++;
            }

        }
        return counter;


    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = mergeArrays(inputArray, arrayToMerge);
        Integer counter = 0;
        T object = null;

        for (int i = 0;i < mergedArray.length; i++){
            Integer n = getNumberOfOccurrences(mergedArray[i]);
            if (n > counter){
                counter = n;
                object = mergedArray[i];
            }
        }
        return object;


    }


    public T[] removeValue(T valueToRemove) {
        Integer sizeOfArray;
        sizeOfArray = inputArray.length - getNumberOfOccurrences(valueToRemove);

        T [] removeValueArray;
        removeValueArray = Arrays.copyOf(inputArray,sizeOfArray);
        int m= 0;
        for (int i =0; i < inputArray.length;i++){
            if (!inputArray[i].equals(valueToRemove)){
                removeValueArray[m] = inputArray[i];
                m++;
            }
        }
        return removeValueArray;
    }
}