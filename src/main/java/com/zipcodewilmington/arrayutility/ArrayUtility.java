package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] mergeArray(T[] inputArray, T[] arrayToMerge){
        T[] mergedArray = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);

        System.arraycopy(arrayToMerge, 0, mergedArray, inputArray.length, arrayToMerge.length);

        return mergedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer count = 0;
        T[] finalArray = mergeArray(arrayToMerge, inputArray);
        for(int i = 0; i< finalArray.length; i++){
            if(finalArray[i].equals(valueToEvaluate)){
                count ++;
            }

        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer count = 0;
        T obj = null;
        T[] newArray = mergeArray(inputArray, arrayToMerge);
        for(int i = 0; i < newArray.length; i++){
            Integer a = getNumberOfOccurrences(newArray[i]);
            if(a > count){
                count = a;
                obj = newArray[i];
            }
        }

        return obj;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for(int i = 0; i<inputArray.length; i++){
            if(inputArray[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        Integer notDuplicates = 0;
        int newSize = inputArray.length - getNumberOfOccurrences(valueToRemove);
        T[] outputArray;
        outputArray = Arrays.copyOf(inputArray, newSize);
        for(int i = 0; i<inputArray.length; i++){
            if(!inputArray[i].equals(valueToRemove)){
                outputArray[notDuplicates]=inputArray[i];
                notDuplicates++;
            }
        }
        return outputArray;
    }
}
