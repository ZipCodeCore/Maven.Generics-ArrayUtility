package com.zipcodewilmington.arrayutility;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    ArrayList<T> inputList = new ArrayList<>();

    public ArrayUtility(T[] inputArray) {
        for(T t : inputArray){
            inputList.add(t);
        }
    }

    public <E> E countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        for(T e : arrayToMerge){
            inputList.add(e);
        }

        Integer counter = 0;
        for(T t : inputList){
            if(t.equals(valueToEvaluate)){
                counter++;
                continue;
            }

        }return (E) counter;
    }

    public T[] removeValue(T valueToRemove){
        return null;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        return null;
    }

    public T getNumberOfOccurrences(T valueToEvaluate){
        return null;
    }
}
