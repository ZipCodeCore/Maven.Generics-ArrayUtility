package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

   private ArrayList<T> inputList = new ArrayList<>();

    public ArrayUtility(T[] inputArray) {
        inputList.addAll(Arrays.asList(inputArray));
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        inputList.addAll(Arrays.asList(arrayToMerge));

        Integer counter = 0;
        for(T t : inputList){
            if(t.equals(valueToEvaluate)){
                counter++;
            }

        }return counter;
    }

    public T[] removeValue(T valueToRemove){
        inputList.removeAll(Arrays.asList(valueToRemove));
        return (T[]) inputList.toArray();
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        inputList.addAll(Arrays.asList(arrayToMerge));

        Map<T, Integer> inputMap = new HashMap<>(inputList.size());
        int maxCount = Integer.MIN_VALUE;
        T mostCommon = null;
        for (T t : inputList) {
            if (!inputMap.containsKey(t)) {
                inputMap.put(t, 1);
            } else {
                inputMap.put(t, inputMap.get(t) + 1);
            }
            maxCount = 0;
            for (Map.Entry<T, Integer> entry : inputMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostCommon = entry.getKey();
                }
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        Integer counter = 0;
        for(T t : inputList){
            if(t == null){
                counter = 1;
            }else if(t.equals(valueToEvaluate)){
                counter++;
            }
        }return counter;
    }
}
