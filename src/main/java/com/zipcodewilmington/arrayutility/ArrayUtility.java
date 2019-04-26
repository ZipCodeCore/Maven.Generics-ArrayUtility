package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    private T[] inputArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }

    public T[] mergeBothArrays(T[] firstArray, T[] secondArray) {

        int firstArrayLength = firstArray.length;

        T[] mergedArray = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);

        int count = 0;
        for (int i = firstArrayLength; i < mergedArray.length; i++) {
            mergedArray[i] = secondArray[count];
            count++;
        }
        return mergedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){

        Integer dupes = 0;

        T[] mergedArray = mergeBothArrays(arrayToMerge, inputArray);

        for (int i = 0; i < mergedArray.length; i++){
            if(valueToEvaluate.equals(mergedArray[i])){
                dupes++;
            }
        }
        return dupes;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        Integer occurences = 0;

        for (int i = 0; i < this.inputArray.length; i++){
            if(this.inputArray[i].equals(valueToEvaluate)){
                occurences++;
            }
        }
        return occurences;
    }

    public T[] removeValue(T valueToRemove) {

        int counter = 0;
        int remove = 0;

        for (int i = 0; i < this.inputArray.length; i++) {
            if (this.inputArray[i] == valueToRemove) {
                counter++;
            }
        }
            //Had a hard time figuring out to create a new generic -
            // array so had to cast. Will refactor when I find a better solution.
        T[] newArray = (T[]) Array.newInstance(this.inputArray.getClass().getComponentType(),
                this.inputArray.length - counter);

        for (int j = 0; j < this.inputArray.length; j++) {
            if (this.inputArray[j] != valueToRemove) {
                newArray[remove] = this.inputArray[j];
                remove++;
            }
        }
        return newArray;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge){

        Integer count = 0;
        T mostCommon = null;

        for (int i = 0; i < arrayToMerge.length; i++){
            Integer numberOfTimesSeen = getNumberOfOccurrences(arrayToMerge[i]);
            if (numberOfTimesSeen > count){
                count = numberOfTimesSeen;
                mostCommon = arrayToMerge[i];
            }
        }
        return mostCommon;
    }

}
