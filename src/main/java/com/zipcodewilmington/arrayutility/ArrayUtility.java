package com.zipcodewilmington.arrayutility;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    private T[] array;

    public ArrayUtility (T[] array) {
        this.array = array;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;

        for(int i = 0; i < array.length; i++ ) {
            if(array[i] == valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfOccurrencesMerged(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(arrayToMerge);
        Integer counter = 0;
        for(int i = 0; i < mergedArray.length; i++) {
            if(mergedArray[i] == valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    public T[] mergeArrays(T[] arrayToMerge) {
        T[] mergedArray = Arrays.copyOf(this.array, this.array.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, mergedArray, this.array.length, arrayToMerge.length);
        return mergedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(arrayToMerge);
        Integer counter = 0;

        for(int i = 0; i < mergedArray.length; i++) {
            if(mergedArray[i] == valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    public T getMostCommon(T[] arrayToMerge) {
        T[] mergedArray = mergeArrays(arrayToMerge);
        Map<T, Integer> countMap = new HashMap<>();
        for(T key : mergedArray) {
            if(countMap.get(key) == null) {
                countMap.put(key, getNumberOfOccurrencesMerged(arrayToMerge, key));
            }
        }

        int max = Collections.max(countMap.values());
        T mostCommon = null;

        for(Map.Entry<T, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == max) {
                mostCommon = entry.getKey();
            }
        }
        return mostCommon;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return getMostCommon(arrayToMerge);
    }

    public T[] removeValue(T valueToRemove) {
        T[] newArray = Arrays.copyOf(this.array, array.length - getNumberOfOccurrences(valueToRemove));
        for(int i = 0, j = 0; i < this.array.length; i++) {
            if(array[i] != valueToRemove) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }

}
