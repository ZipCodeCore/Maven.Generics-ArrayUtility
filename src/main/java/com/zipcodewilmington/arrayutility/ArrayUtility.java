package com.zipcodewilmington.arrayutility;

import java.util.*;

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

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        E[] finalArray = this.mergeArrays(arrayToMerge);
        this.inputArray = finalArray;

        Map<E, Integer> hashMap = new HashMap<>();
        for (E key : this.inputArray) {
            if (hashMap.get(key) == null) {
                hashMap.put(key, getNumberOfOccurrences(key));
            }
        }
        int maxNumberOfOccurrences = Collections.max(hashMap.values());

        E mostCommon = null;
        for (Map.Entry<E, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxNumberOfOccurrences) {
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }

}
