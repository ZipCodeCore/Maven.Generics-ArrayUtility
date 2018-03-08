package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    private T[] tArray;

    public ArrayUtility(T[] tArray){
        this.tArray = tArray;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        T[] merged = mergeArrays(arrayToMerge);
        this.tArray = merged;
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        T[] merged = mergeArrays(arrayToMerge);
        int maxDupes = 0;
        T mostCommon = null;
        for (T t:merged) {
            int currentDupes = getNumberOfOccurrencesCustom(t, merged);
            if (currentDupes > maxDupes){
                maxDupes = currentDupes;
                mostCommon = t;
            }
        }
        return mostCommon;
    }

    public int getNumberOfOccurrences(T duplicatesToCount){
        return getNumberOfOccurrencesCustom(duplicatesToCount, tArray);
    }

    public int getNumberOfOccurrencesCustom(T duplicatesToCount, T[] testArray){
        int counter = 0;
        for (T t:testArray) {
            if (t.equals(duplicatesToCount)) counter++;
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove){
        T[] returnArray = Arrays.copyOf(tArray, (tArray.length - this.getNumberOfOccurrences(valueToRemove)));
        int index = 0;
        for (T t:this.tArray) {
            if (!t.equals(valueToRemove)){
                returnArray[index] = t;
                index++;
            }
        }
        return returnArray;
    }

    public T[] mergeArrays(T[] newArray){
        T[] returnArray = Arrays.copyOf(tArray, (tArray.length + newArray.length));
        int index = tArray.length;
        for (T t:newArray){
            returnArray[index] = t;
            index++;
        }
        return returnArray;
    }
}
