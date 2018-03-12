package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }

    public int countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        int count = 0;
        E[] finalArray = mergeArrays(arrayToMerge);
        for (E element : finalArray) {
            if (element.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public E[] mergeArrays(E[] arrayToMerge) {
        ArrayList<E> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(inputArray));
        arrayList.addAll(Arrays.asList(arrayToMerge));
        return (E[]) arrayList.toArray();
    }

    public int getNumberOfOccurrences(E valueToEvaluate) {
        int count = 0;
        for (E element : inputArray) {
            if (element == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

//    public int getMostCommonFromMerge(E valueToEvaluate) {
//
//        Object mostCommonNum = null;
//        int mostOccurrences = 0;
//
//        HashMap<Object, Integer> hashMap = new HashMap<>();
//
//        for (Object object : objectArray) {
//            if (!hashMap.containsKey(object)) {
//                hashMap.put(object, 1);
//            } else {
//                hashMap.put(object, hashMap.get(object) + 1);
//            }
//
//            if (hashMap.get(object) > mostOccurrences) {
//                mostCommonNum = object;
//                mostOccurrences = hashMap.get(object);
//            }
//        }
//
//        System.out.println(mostCommonNum);
//        return mostCommonNum;
//    }

}
