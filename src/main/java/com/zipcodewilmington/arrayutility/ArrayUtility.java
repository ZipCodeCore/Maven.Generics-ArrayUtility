package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;

    public ArrayUtility(T[] input) {
        this.inputArray = input;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = Arrays.copyOf(inputArray, inputArray.length);
        for (int i = inputArray.length; i < arrayToMerge.length + inputArray.length; i++) {
            mergedArray = Arrays.copyOf(mergedArray, mergedArray.length + 1);
            mergedArray[i] = arrayToMerge[i - inputArray.length];
        }
        Integer outputCounter = 0;

        for (int j = 0; j < mergedArray.length; j++) {
            if (mergedArray[j] == valueToEvaluate) {
                outputCounter++;
            }
        }
        return outputCounter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = Arrays.copyOf(inputArray, inputArray.length);
        for (int i = inputArray.length; i < arrayToMerge.length + inputArray.length; i++) {
            mergedArray = Arrays.copyOf(mergedArray, mergedArray.length + 1);
            mergedArray[i] = arrayToMerge[i - inputArray.length];
        }
        this.inputArray = mergedArray;
        T mostCommon = mergedArray[0];
        int highestOccurrence = 0;
        for (T t : inputArray) {
            if (this.getNumberOfOccurrences(t) > highestOccurrence) {
                highestOccurrence = this.getNumberOfOccurrences(t);
                mostCommon = t;
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToCount) {
        int counter = 0;
        for (T t : this.inputArray) {
            if (t.equals(valueToCount)) {
                counter++;
            }
        }

        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        T[] outputArray = Arrays.copyOf(this.inputArray, 0);
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                outputArray = Arrays.copyOf(outputArray, outputArray.length + 1);
                outputArray[outputArray.length - 1] = inputArray[i];
            }
        }
        return outputArray;
    }
}