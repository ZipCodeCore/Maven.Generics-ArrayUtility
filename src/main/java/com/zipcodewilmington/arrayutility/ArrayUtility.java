package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] genericArray;

    public ArrayUtility(T[] inputArray) {
        this.genericArray = inputArray;
    }

    public Integer getNumberOfOccurrences(T valToCheck) {

        int numOfOccurrences = 0;

        for (T element: genericArray) {
            if (element.equals(valToCheck)){
                numOfOccurrences++;
            }
        }

        return numOfOccurrences;


    }

    public T[] removeValue(T valueToRemove) {

//        List<T> tempArrayList = new ArrayList<T>();
//
//        for (T element: genericArray){
//            if (!element.equals(valueToRemove)){
//                tempArrayList.add(element);
//            }
//        }

        T[] arrayWithValueRemoved = Arrays.copyOf(genericArray, 0);
        for (int i = 0; i < genericArray.length; i++) {
                if (!genericArray[i].equals(valueToRemove)) {
                    arrayWithValueRemoved = Arrays.copyOf(arrayWithValueRemoved, arrayWithValueRemoved.length + 1);
                    arrayWithValueRemoved[arrayWithValueRemoved.length - 1] = genericArray[i];
            }
        }
        return arrayWithValueRemoved;

    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToCheck) {

        Integer numOfDuplicates = 0;

        for (int i = 0; i < genericArray.length; i++) {
            if (genericArray[i].equals(valueToCheck)) {
                numOfDuplicates++;
            }
        }

        for (int j = 0; j < arrayToMerge.length; j++) {
            if (arrayToMerge[j].equals(valueToCheck)) {
                numOfDuplicates++;
            }
        }

        return numOfDuplicates;
    }

    public T getMostCommonFromMerge(T[] secondArray) {

        Integer largestWeveSeenSoFar = 0;
        T mostCommonObject = null;

        for (int i = 0; i < this.genericArray.length; i++) {
            if (countDuplicatesInMerge(secondArray, this.genericArray[i]) > largestWeveSeenSoFar) {
                mostCommonObject = this.genericArray[i];
            }
        }

        return mostCommonObject;
    }

}

//    public T[] mergeArrays(T[] arrayToAdd) {
//
//        List<T> amysList = new ArrayList<T>();
//
//        for (T element: genericArray){
//            amysList.add(element);
//        }
//        for (T element: arrayToAdd){
//            amysList.add(element);
//        }
//
//        T[] answerArray = Arrays.copyOf(genericArray, );
//        for (int i = 0; i < answerArray.length; i++){
//            answerArray[i] = amysList.get(i);
//        }
//        return answerArray;
//
//    }
//}

//    public T[] removeValue(T valueToRemove) {
//
//        T[] arrayWithValueRemoved = new T[genericArray.length];
//        for (int i = 0; i < arrayWithValueRemoved.length; i++){
//            arrayWithValueRemoved[i] = genericArray[i];
//        }
//        return arrayWithValueRemoved;
//
//    }



