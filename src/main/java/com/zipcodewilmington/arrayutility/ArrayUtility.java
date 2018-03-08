package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    protected T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        ArrayList<T> mergedArrays = new ArrayList<T>(Arrays.asList(inputArray));
        mergedArrays.addAll(Arrays.asList(arrayToMerge));
        Integer occurred = count(mergedArrays, valueToEvaluate);
        return occurred;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        ArrayList<T> mergedArrays = new ArrayList<T>(Arrays.asList(arrayToMerge));
        mergedArrays.addAll(Arrays.asList(inputArray));
        T common = null;
        for(int x = 0; x<mergedArrays.size(); x++) {
            for(int y = 0; y< mergedArrays.size(); y++){
                if(count(mergedArrays, mergedArrays.get(x))> count(mergedArrays, mergedArrays.get(y))){
                    common = mergedArrays.get(x);
                }
            }
        }
        return common;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        ArrayList<T> obArray = new ArrayList<T>(Arrays.asList(inputArray));
        return count(obArray, valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove){
        ArrayList<T> obArray = new ArrayList<T>(Arrays.asList(inputArray));
        int counter = count(obArray, valueToRemove);
        T[] shorten = Arrays.copyOf(inputArray, inputArray.length-counter);
        for(int i = 0; i<obArray.size(); i++){
            if(valueToRemove.equals(obArray.get(i)) ){
                obArray.remove(obArray.get(i));
            }
        }
        return obArray.toArray(shorten);

    }
    /*public void removeStudent(String firstName, String lastName) {

            if (students[p] == null) {
                students[p] = this.students[p + 1];
                students[p + 1] = null;
            }
        }
    }*/

    public Integer count(ArrayList<T> mergedArrays, T valueToEvaluate) {
    Integer count = 0;
        for(int i = 0; i<mergedArrays.size();i++) {
            if (mergedArrays.get(i).equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }
}
