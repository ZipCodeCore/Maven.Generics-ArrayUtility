package com.zipcodewilmington.arrayutility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        int count = 0;
        for (T element: arrayToMerge) {
            if (element.equals(valueToEvaluate)) {
                count++;
            }
        }

        for(T element: this.inputArray) {
            if (element.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int currentCount = 1;
        int mostCommonCount;

        T mostCommon = arrayToMerge[0];
        T tempCount;

        for (int i = 0; i < (arrayToMerge.length - 1); i++) {
            tempCount = arrayToMerge[i];
            mostCommonCount = 0;
            for (int j = 1; j < arrayToMerge.length; j++) {
                if (tempCount == arrayToMerge[j])
                    mostCommonCount++;
            }
            if (mostCommonCount > currentCount) {
                mostCommon = tempCount;
                currentCount = mostCommonCount;
            }
        }
        return mostCommon;
    }

    public T[] removeValue(T valueToRemove) {
        int numDups = getNumberOfOccurrences(valueToRemove);
        T[] noDuplicates = Arrays.copyOf(this.inputArray, this.inputArray.length - numDups);

        int count = 0;
        for (int i = 0; i < this.inputArray.length; i++) {
            if (!this.inputArray[i].equals(valueToRemove)) {
                noDuplicates[count] = this.inputArray[i];
                count++;
            }
        }
        return noDuplicates;
    }

    public int getNumberOfOccurrences(T valueToEvaluate) {

        int count = 0;

        for (int i = 0; i < this.inputArray.length; i++) {
            if (this.inputArray[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }
}
