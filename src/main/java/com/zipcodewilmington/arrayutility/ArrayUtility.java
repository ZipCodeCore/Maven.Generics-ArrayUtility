package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] inputArray;

    public ArrayUtility(T[] input) {
        this.inputArray = input;
    }
    //same as normal method used at the bottom but with a generic object of type T
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = Arrays.copyOf(inputArray, inputArray.length);
        for (int i = inputArray.length; i < (arrayToMerge.length + inputArray.length); i++) {
            mergedArray = Arrays.copyOf(mergedArray, mergedArray.length + 1);
            mergedArray[i] = arrayToMerge[i - inputArray.length];
        }

        Integer resultCount = 0;
        for (int x = 0; x < mergedArray.length; x++) {
            if (mergedArray[x] == valueToEvaluate) {
                resultCount++;
            }
        }

        return resultCount;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = Arrays.copyOf(inputArray, inputArray.length); //empty array that will hold the value of my new merged array once the logic has been done
        for (int i = inputArray.length; i < (arrayToMerge.length + inputArray.length); i++) { //for loop iterating through entire length of both arrays
            mergedArray = Arrays.copyOf(mergedArray, mergedArray.length + 1);
            mergedArray[i] = arrayToMerge[i - inputArray.length];
        }
        //after merging using the above syntax now I want to find the most common occurrence from my new merged array using the method
        this.inputArray = mergedArray;
        T mostCommonOccurrence = mergedArray[0];
        int maxOccurrence = 0;
        for (T value : inputArray) {
            if (this.getNumberOfOccurrences(value) > maxOccurrence) {
                maxOccurrence = this.getNumberOfOccurrences(value);
                mostCommonOccurrence = value;
                }
            }

            return mostCommonOccurrence;
        }
        //I could have also used this method below on both arrays above and compared the maxnumbofOccurrences on both arrays and still got my result
    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (T value : this.inputArray) {
            if (value.equals(valueToEvaluate)) {
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] outputArray = Arrays.copyOf(this.inputArray, 0);
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                outputArray = Arrays.copyOf(outputArray,outputArray.length + 1);
                outputArray[outputArray.length - 1] = inputArray[i];
            }
        }

        return outputArray;
    }
}
//      normal method to get numbofoccurrecences, almost identical except my generic of type 'T' is now my object
//      my objects now no longer need to be cast using the above method
//    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
//        Integer count = 0;
//        for (int i = 0; i < objectArray.length; i++) {
//            if (objectArray[i].equals(objectToCount)) {
//                count++;
//            }
//        }
//        return count;
//    }
//    public static <T> T[] mergeArrays(T[] objectArray, T[] objectArrayToAdd) {
//
//        T[] resultOfMergingTwoArrays = Arrays.copyOf(objectArray,
//                objectArray.length + objectArrayToAdd.length);
//        System.arraycopy(objectArrayToAdd, 0, resultOfMergingTwoArrays,
//                objectArray.length, objectArrayToAdd.length);
//
//        return resultOfMergingTwoArrays;
//    }
//          this is the normal method, object is now  of type 'T' as a generic
//    public static Integer[] mergeArrays(Object[] objectArray, Object[] objectArrayToAdd) {
//        Integer[] resultArr = new Integer[objectArray.length + objectArrayToAdd.length];
//        System.arraycopy(objectArray, 0, resultArr, 0, objectArray.length);
//        System.arraycopy(objectArrayToAdd, 0, resultArr, objectArray.length, objectArrayToAdd.length);
//        return resultArr;
//    }
//
//    public static Object getMostCommon(Object[] objectArray) {
//        Integer count = 0;
//        Object obj = null;
//        for (int i = 0; i < objectArray.length; i++) {
//            Integer n = getNumberOfOccurrences(objectArray, objectArray[i]);
//            if (n > count) {
//                count = n;
//                obj = objectArray[i];
//            }
//        }
//        return obj;
//    }
//  why did intelliJ suggest making me have to cast everything to T...none of these test would pass in this case.
//    public T countDuplicatesInMerge(Integer[] arrayToMerge, T valueToEvaluate) {
//        return null;
//    }
//}