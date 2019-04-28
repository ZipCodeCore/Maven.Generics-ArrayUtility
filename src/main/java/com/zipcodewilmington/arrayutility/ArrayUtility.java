package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] arrayToMerge;
    private T valueToEvaluate;
    private T[] inputArray;

    //constructor
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }


    //methods
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer count = 0;
        Integer duplicateCount = 0;

        T[] mergedArr = Arrays.copyOf(arrayToMerge, arrayToMerge.length+inputArray.length );
        for (int i = 0; i < arrayToMerge.length; i++) {
            mergedArr[i] = arrayToMerge[i];
            count++;
        }
        for (int j = 0; j < inputArray.length; j++) {
            mergedArr[count++] = inputArray[j];
        }
        for (T thing : mergedArr) {
            if (thing == valueToEvaluate) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }



//        List myArrays = new ArrayList((Arrays.asList(inputArray)));
//        myArrays.addAll(Arrays.asList(arrayToMerge));
//         T[]mergedArray = myArrays.toArray();

        //this part works
//
//        for (T thing : arrayToMerge) {
//            if (thing == valueToEvaluate) {
//                count++;
//            }
//        }
//            for (T thingtwo : inputArray) {
//                if (thingtwo == valueToEvaluate) {
//                    count++;
//                }
//            }
//        return count;



    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;

        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] == valueToEvaluate){
                count++;
            }
        }
        return count;
    }



    public T[] removeValue(T valueToRemove) {
        Integer adjustedlength;

        adjustedlength = inputArray.length - getNumberOfOccurrences(valueToRemove);
        T[] scrubbedArray = Arrays.copyOf(inputArray, adjustedlength);

        int j = 0;
        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] != valueToRemove){
               scrubbedArray[j] = inputArray[i];
                j++;
            }
        }
        return scrubbedArray;
    }


    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int commoncount = 0;
        int count = 0;
        T obj = null;


        T[] mergedArr = Arrays.copyOf(arrayToMerge, arrayToMerge.length+inputArray.length );
        for (int i = 0; i < arrayToMerge.length; i++) {
            mergedArr[i] = arrayToMerge[i];
            count++;
        }
        for (int j = 0; j < inputArray.length; j++) {
            mergedArr[count++] = inputArray[j];
        }

        for (int i = 0; i < mergedArr.length; i++){
            int n = getNumberOfOccurrences(mergedArr[i]);

            if (n >commoncount){
                commoncount = n;
                obj = mergedArr[i];
            }

        }


        return obj;
    }
}


