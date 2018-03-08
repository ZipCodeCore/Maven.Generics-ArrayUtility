package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public T[] inputArray;
    public T[] mergedArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
     this.mergedArray = Arrays.copyOf(this.inputArray, this.inputArray.length + arrayToMerge.length);
     System.arraycopy(arrayToMerge, 0, mergedArray, mergedArray.length - arrayToMerge.length, arrayToMerge.length);
     return null;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
     this.mergedArray = Arrays.copyOf(this.inputArray, this.inputArray.length + arrayToMerge.length);
      System.arraycopy(arrayToMerge, 0, mergedArray, mergedArray.length - arrayToMerge.length, arrayToMerge.length);
       Integer count = 0;
       for (T t : this.mergedArray){
           if (t == valueToEvaluate){
               count++;
           }
       }
        return count;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return null;
    }

    public T[] removeValue(T valueToRemove) {
           return null;
    }

}
