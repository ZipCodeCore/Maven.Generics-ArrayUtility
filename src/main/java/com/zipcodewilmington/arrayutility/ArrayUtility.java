package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    private T[] array;
    private T valueToEvaluate;
    public T valueToFind;



    public ArrayUtility() {
    }
    public ArrayUtility(T[] array, T valueToEvaluate) {
        this.array = array;
        this.valueToEvaluate = valueToEvaluate;
    }

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    //merge 2 arrays method
    public T[] mergeArrays(T[] array, T[] arrayToMerge){
        ArrayList<T> mergedArr = new ArrayList<>(Arrays.asList(array));
        mergedArr.addAll(Arrays.asList(arrayToMerge));
        return (T[]) mergedArr.toArray();

    }
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArr = mergeArrays(array, arrayToMerge);
        Integer count = 0;
        for(int i = 0; i < mergedArr.length; i++){
            if (mergedArr[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArr = mergeArrays(array, arrayToMerge);
        return getMostCommon(mergedArr);
    }

    public T getMostCommon(T[] array1){
        TreeMap<T, Integer> map = new TreeMap<>();
        for (int i = 0; i < array1.length; i++) {
            if (map.keySet().contains(array1[i])) {
                map.put(array1[i], map.get(array1[i]) + 1);
            } else {
                map.put(array1[i], 1);
            }
        }
        Integer count = 0;
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            T key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= count) {
                count = value;
                valueToFind =  key;
            }
        }

        return valueToFind;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] newArr = Arrays.copyOf(array, array.length-(getNumberOfOccurrences(valueToRemove)));
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if (!array[i].equals(valueToRemove)){
                newArr[index] = array[i];
                index++;
            }
        }
        return newArr;

    }
//    @SuppressWarnings("unckecked")
//    public T[] removeValue(T valueToRemove) throws ClassCastException {
//        List<?> list = new ArrayList<>(Arrays.asList(this.array));
//        list.removeAll(Arrays.asList(valueToRemove));
//        return (T[]) list.toArray();
//    }

    }
