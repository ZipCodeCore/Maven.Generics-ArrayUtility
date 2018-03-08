package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {


    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] mergeArray(T[] arrayToMerge, T[] inputArray) {
        T[] result = Arrays.copyOf(arrayToMerge, arrayToMerge.length + inputArray.length);
        System.arraycopy(inputArray, 0, result, arrayToMerge.length, inputArray.length);
        return result;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] thisArray = mergeArray(arrayToMerge, inputArray);
        Map<T, Integer> map = new TreeMap<>();

        for (T mostCommon : thisArray) {
            //iterate through array to see if how many times entered.
            if (map.containsKey(mostCommon)) {
                map.put(mostCommon, map.get(mostCommon) + 1);
                //keep adding to value if you keep seeing it
            } else {
                map.put(mostCommon, 1);

            }

        }
        return (Collections.max(map.entrySet(), Map.Entry.comparingByValue())
                .getKey());
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int counter = 0;
        T[] thisArray = mergeArray(arrayToMerge, inputArray);
        for (int i = 0; i < thisArray.length; i++) {
            if (thisArray[i].equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToEvaluate))
                count++;
        }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        //create a copy of the array making its new length # of occurances -valueToremove
        T[] copyArray = Arrays.copyOf(inputArray, inputArray.length-(getNumberOfOccurrences(valueToRemove)));
        //have to declare the length of the new array...so keep count
        int lengthOfNewArray = 0;
        for(int i = 0; i < inputArray.length; i++){
            //put the values that arent the one to remove in new array
            if (!inputArray[i].equals(valueToRemove)){
                copyArray[lengthOfNewArray] = inputArray[i];
                lengthOfNewArray++;
            }
        }
          return copyArray;


        //CANT INSTANTIATE A GENERIC ARRAY!
//        ArrayList<T> list = new ArrayList<>(Arrays.asList(inputArray));
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals(valueToRemove)) {
//                list.remove(i);
//                return list.toArray(new <T> T[0]);
//            }
//        }
//        return list.toArray(new <T> T[0]);
    }
}

