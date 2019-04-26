package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;
    private T[] mergedArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] mergeArrays(T[] inputArray, T[] arrayToMerge) {
        int inputArrayLength = inputArray.length;
        int arrayToMergeLength = arrayToMerge.length;

        mergedArray = (T[]) new Object[inputArrayLength + arrayToMergeLength];

        System.arraycopy(inputArray, 0, mergedArray, 0, inputArrayLength);
        System.arraycopy(arrayToMerge, 0, mergedArray, inputArrayLength, arrayToMergeLength);

        return mergedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valuetoEvaluate) {
        mergeArrays(inputArray, arrayToMerge);
        int count = 0;
        for (T value : mergedArray) {
            if (value == valuetoEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        mergeArrays(inputArray, arrayToMerge);
        //dont need a map for this but wanted to do some map practice
        HashMap<T, Integer> countingMap = new HashMap<>();

        for (T occurrence : mergedArray) {
            if (countingMap.containsKey(occurrence)) {
                countingMap.put(occurrence, countingMap.get(occurrence) + 1);
            } else {
                countingMap.put(occurrence, 1);
            }
        }
        T element = null;
        int frequency = 1;
        Set<Map.Entry<T, Integer>> entrySet = countingMap.entrySet();
        for (Map.Entry<T, Integer> entry : entrySet) {
            if (entry.getValue() > frequency) {
                element = entry.getKey();
                frequency = entry.getValue();
            }
        }
        return element;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (T value : inputArray) {
            if (value == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] tempArray = inputArray;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToRemove)) {
                //copy up to the found dup
                tempArray = Arrays.copyOf(Arrays.copyOfRange(inputArray, 0, i), inputArray.length - 1);
                //take original, place in temp up to dup
                System.arraycopy(inputArray, i + 1, tempArray, i, inputArray.length - i - 1);
                //go for more dupes
                inputArray = tempArray;
            }
        }
        return tempArray;
    }
}