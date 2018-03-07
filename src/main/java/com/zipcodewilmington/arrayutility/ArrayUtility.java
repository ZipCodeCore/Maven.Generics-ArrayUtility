package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        return betterGetNumberOfOccurrences(inputArray, valueToEvaluate) + betterGetNumberOfOccurrences(arrayToMerge, valueToEvaluate);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        E[] mergedArray = theGreatMerge(inputArray, arrayToMerge);
        Arrays.sort(mergedArray);
        Integer counter = 0;
        Integer currentMax = 0;
        E currentlyExamining;
        E previouslyExamined;
        E currentWinner = null;
        for (int i = 1; i < mergedArray.length; i++) {
            currentlyExamining = mergedArray[i];
            previouslyExamined = mergedArray[i-1];
            if (currentlyExamining.equals(previouslyExamined)) {
                counter++;
            }
            if (counter > currentMax) {
                currentMax = counter;
                currentWinner = currentlyExamining;
            }
            if (!(currentlyExamining.equals(previouslyExamined))) {
                counter = 0;
            }
        }
        return currentWinner;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        return betterGetNumberOfOccurrences(inputArray, valueToEvaluate);
    }

    public E[] removeValue(E valueToRemove) {
        E[] arrayToReturn = inputArray;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToRemove)) {
                arrayToReturn = Arrays.copyOf(Arrays.copyOfRange(inputArray, 0, i), inputArray.length - 1);
                System.arraycopy(inputArray, i + 1, arrayToReturn, i, inputArray.length - i - 1);
                inputArray = arrayToReturn;
            }
        }
        return arrayToReturn;
    }

    private Integer betterGetNumberOfOccurrences(E[] arr, E value) {
        Integer counter = 0;
        for (E anArr : arr) {
            if (anArr.equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    private E[] theGreatMerge(E[] first, E[] second) {
        int firstLength = first.length;
        int secondLength = second.length;

        @SuppressWarnings("unchecked")
        E[] mergedArrays = (E[]) Array.newInstance(first.getClass().getComponentType(), firstLength + secondLength);
        System.arraycopy(first, 0, mergedArrays, 0, firstLength);
        System.arraycopy(second, 0, mergedArrays, firstLength, secondLength);

        return mergedArrays;
    }
}


