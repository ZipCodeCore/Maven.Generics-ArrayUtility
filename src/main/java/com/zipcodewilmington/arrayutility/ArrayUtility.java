package com.zipcodewilmington.arrayutility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.*;


/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

   private ArrayList<T> inputList = new ArrayList<>();
   private T[] newArray;

    public ArrayUtility(T[] inputArray) {
        inputList.addAll(asList(inputArray));
        this.newArray = copyOf(inputArray, inputArray.length);
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        inputList.addAll(asList(arrayToMerge));

        Integer counter = 0;
        for(T t : inputList){
            if(t.equals(valueToEvaluate)){
                counter++;
            }

        }return counter;
    }

    public T[] removeValue(T valueToRemove){
        T[] myArray = copyOf(newArray, newArray.length);
        T[] lastArray = null;
        for(int i = 0; i < myArray.length; i++){
            if(myArray[i] == valueToRemove){
                System.arraycopy(myArray, i+1, myArray, i, myArray.length - i - 1);
            }
        }
        lastArray = Arrays.copyOf(myArray, myArray.length - getNumberOfOccurrences(valueToRemove));
        return lastArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        inputList.addAll(asList(arrayToMerge));

        Map<T, Integer> inputMap = new HashMap<>(inputList.size());
        int maxCount;
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
