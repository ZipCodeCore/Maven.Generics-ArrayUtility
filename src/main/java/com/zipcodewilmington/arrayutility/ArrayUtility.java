package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public T[] inputArray;


    public ArrayUtility(T[] inputArray) {
        this.inputArray =inputArray;
    }


    public T[] mergeArrays(T[] inputArray, T[] arrayToMerge) {

        T[] mergedArray = (T[])Array.newInstance(inputArray.getClass().getComponentType(),
                inputArray.length + arrayToMerge.length);

        System.arraycopy(inputArray, 0 , mergedArray, 0 , inputArray.length);
        System.arraycopy(arrayToMerge, 0, mergedArray, inputArray.length, arrayToMerge.length);
        return mergedArray;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

       T[] mergedArray = mergeArrays(inputArray, arrayToMerge);
       Integer countValueToEvaluate =0;

       for (int i = 0; i < mergedArray.length; i++) {
           if (mergedArray[i] == valueToEvaluate)
               countValueToEvaluate ++;
       }
       return countValueToEvaluate;
    }


    public T[] removeValue(T valueToRemove) {

        T[] arrayWithValueRemoved = (T[])Array.newInstance(inputArray.getClass().getComponentType(),
                inputArray.length - getNumberOfOccurrences(valueToRemove));

        int count = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                arrayWithValueRemoved[count] = inputArray[i];
                count++;
            }
        }
        return arrayWithValueRemoved;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer occurrences = 0;
        for (int i = 0; i <inputArray.length; i++) {
            if (inputArray[i].equals(valueToEvaluate)) {
                occurrences++;
            }
        }
        return occurrences;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = mergeArrays(inputArray, arrayToMerge);
        T mostCommon = null;
        Integer count= 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (count <= getNumberOfOccurrences(mergedArray[i])) {
                mostCommon = mergedArray[i];
                count = getNumberOfOccurrences(mergedArray[i]);
            }
        }
        return mostCommon;

    }
}
