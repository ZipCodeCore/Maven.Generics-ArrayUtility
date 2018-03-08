package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public T[] inputArray;
    public T[] mergedArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        mergeArrays(arrayToMerge);
        Integer indexCount = 0;
        T currentMatch = null;
        for( T elementInArray : mergedArray){
            if (getNumberOfOccurrences(elementInArray) > getNumberOfOccurrences(mergedArray[indexCount +1])){
                currentMatch = elementInArray;
                indexCount++;
            }
        }
        return currentMatch;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        mergeArrays(arrayToMerge);
        Integer count = 0;
        for (T elementInArray : this.mergedArray) {
            if (elementInArray == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T elementInArray : this.inputArray) {
            if (elementInArray == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] arrayWitValueRemoved = Arrays.copyOf(this.inputArray, this.inputArray.length - getNumberOfOccurrences(valueToRemove));
        Integer indexCount = 0;
        for (T elementInArray : this.inputArray) {
            if (valueToRemove != elementInArray) {
                arrayWitValueRemoved[indexCount] = elementInArray;
                indexCount++;
            }
        }
        return arrayWitValueRemoved;
    }

    public T[] mergeArrays(T[] arrayToMerge) {
        this.mergedArray = Arrays.copyOf(this.inputArray, this.inputArray.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, mergedArray, mergedArray.length - arrayToMerge.length, arrayToMerge.length);
        return this.mergedArray;
    }
}
