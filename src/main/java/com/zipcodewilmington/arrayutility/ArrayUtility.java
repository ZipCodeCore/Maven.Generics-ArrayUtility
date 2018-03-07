package com.zipcodewilmington.arrayutility;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }

    public E[] getInputArray() {
        return inputArray;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        return betterGetNumberOfOccurrences(inputArray, valueToEvaluate) + betterGetNumberOfOccurrences(arrayToMerge, valueToEvaluate);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        return null;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        return betterGetNumberOfOccurrences(inputArray, valueToEvaluate);
    }

    public Integer betterGetNumberOfOccurrences(E[] arr, E value) {
        Integer counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    public E[] removeValue(E valueToRemove) {
        for (int i = 0; i < inputArray.length; )
        return null;
    }

}
