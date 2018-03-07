package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        Integer duplicateAmount = 0;
        T[] mergedArray = mergeArrays(arrayToMerge, inputArray);
        for (T value: mergedArray) {
            if (valueToEvaluate.equals(value)){
                duplicateAmount++;
            }
        }
        return duplicateAmount;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        T[] mergedArray = mergeArrays(arrayToMerge, inputArray);
        return getMostCommon(mergedArray);
    }

    public Integer getNumberOfOccurrences(T valueToCheck){
        Integer numberOfOccurrences = 0;
        for (T value: this.inputArray) {
            if (value.equals(valueToCheck)){
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    public T[] removeValue(T objectToRemove){
        for (int i = 0; i < this.inputArray.length; i++) {
            if (this.inputArray[i].equals(objectToRemove)) {
                for (int j = i + 1; j <this.inputArray.length; j++) {
                    this.inputArray[i] = this.inputArray[j];
                }
                this.inputArray = Arrays.copyOf(this.inputArray, this.inputArray.length - 1);
                i--;
            }
        }
        return this.inputArray;
    }

    public T[] mergeArrays(T[] objectArray, T[] objectArrayToAdd) {
        int originalLength = objectArray.length;
        T[] newArray = Arrays.copyOf(objectArray, objectArray.length + objectArrayToAdd.length);
        int count = 0;
        for (int i = originalLength; i < newArray.length; i++) {
            newArray[i] = objectArrayToAdd[count];
            count++;
        }
        return newArray;
    }

    public T getMostCommon(T[] objectArray) {
        T mostCommon = null;
        int mostCommonCount = 0;
        for (T object: objectArray) {
            int count = 0;
            for (T object2: objectArray) {
                if (object.equals(object2)) {
                    count++;
                }
            }
            if (count > mostCommonCount) {
                mostCommon = object;
                mostCommonCount = count;
            }
        }
        return mostCommon;
    }
}
