package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] inputArray;

    public ArrayUtility(T[] input) {
        this.inputArray = input;
    }
    //created method to strictly merge arrays, (I remembered Single responsibility hehe)
    public static <T> T[] mergeArrays(T[] objectArray, T[] objectArrayToAdd) {
        T[] resultOfMergingTwoArrays = Arrays.copyOf(objectArray,
                objectArray.length + objectArrayToAdd.length);
        System.arraycopy(objectArrayToAdd, 0, resultOfMergingTwoArrays,
                objectArray.length, objectArrayToAdd.length);
        return resultOfMergingTwoArrays;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        mergeArrays(arrayToMerge, inputArray);
        T[] mergedArray = mergeArrays(arrayToMerge, inputArray);
        Integer resultCount = 0;
        for (int x = 0; x < mergedArray.length; x++) {
            if (mergedArray[x] == valueToEvaluate) {
                resultCount++;
            }
        }
        return resultCount;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        mergeArrays(arrayToMerge,inputArray);
        T[] mergedArray = mergeArrays(arrayToMerge, inputArray);
        this.inputArray = mergedArray;
        T mostCommonOccurrence = mergedArray[0];
        int maxOccurrence = 0;
        for (T value : inputArray) {
            if (this.getNumberOfOccurrences(value) > maxOccurrence) {
                maxOccurrence = this.getNumberOfOccurrences(value);
                mostCommonOccurrence = value;
                }
            }
            return mostCommonOccurrence;
        }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (T value : this.inputArray) {
            if (value.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] outputArray = Arrays.copyOf(this.inputArray, 0);
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                outputArray = Arrays.copyOf(outputArray,outputArray.length + 1);
                outputArray[outputArray.length - 1] = inputArray[i];
            }
        }
        return outputArray;
    }
}
