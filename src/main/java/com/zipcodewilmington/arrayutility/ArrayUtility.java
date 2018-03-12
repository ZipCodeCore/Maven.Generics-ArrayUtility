package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

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
        return 0;
    }




}
