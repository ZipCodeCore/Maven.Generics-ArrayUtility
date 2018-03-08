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

        public T[] mergeArrays(T[] inputArray, T[] arrayToMerge){
            T[] merged = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
            System.arraycopy(arrayToMerge, 0, merged, inputArray.length, arrayToMerge.length);
            return merged;
        }

        public Integer getNumberOfOccurrences(T valueToEvaluate) {
            Integer count = 0;
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i].equals(valueToEvaluate)) {
                    count++;
                }
            }
            return count;
        }


        public T getMostCommonFromMerge (T[]arrayToMerge){
            T[] mergedArray = mergeArrays(inputArray, arrayToMerge);

            Integer count = 0;
            T obj = null;
            for (int i = 0; i < mergedArray.length; i++) {
                Integer n = getNumberOfOccurrences(mergedArray[i]);
                if (n > count) {
                    count = n;
                    obj = mergedArray[i];
                }
            }
            return obj;
        }

        public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(inputArray, (T[]) arrayToMerge);
        Integer count = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (mergedArray[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;

    }

        public T[] removeValue(T valueToRemove) {

            T[] arrayWithOutRemovedValue;
            arrayWithOutRemovedValue = Arrays.copyOf(inputArray, (inputArray.length - getNumberOfOccurrences(valueToRemove)));
            int idx = 0;
            for (int i = 0; i < inputArray.length; i++) {
                if (!inputArray[i].equals(valueToRemove)) {
                    arrayWithOutRemovedValue[idx] = inputArray[i];
                    idx++;
                }
            }
            return arrayWithOutRemovedValue;
        }


    }

