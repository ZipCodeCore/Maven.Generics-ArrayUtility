package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;   // given from test cases

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] mergeArrays(T[] inputArray, T[] arrayToMerge) {
        T[] result = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, result, inputArray.length, arrayToMerge.length);
        return result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = mergeArrays(inputArray, arrayToMerge);

        Integer count = 0;
        T output = null;

        for (int i = 0; i < mergedArray.length; i++) {
            Integer compare = getNumberOfOccurrences(mergedArray[i]);
            if (compare > count) {
                count = compare;
                output = mergedArray[i];
            }
        }
        return output;
    }

    public T[] removeValue(T valueToRemove) {

        Integer newSize = inputArray.length - getNumberOfOccurrences(valueToRemove);
        T[] arrayWithoutRemovedValue = Arrays.copyOf(inputArray, newSize);
        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                arrayWithoutRemovedValue[count] = inputArray[i];
                count++;
            }
        }
        return arrayWithoutRemovedValue;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(inputArray, arrayToMerge);
        Integer count = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (mergedArray[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

}
