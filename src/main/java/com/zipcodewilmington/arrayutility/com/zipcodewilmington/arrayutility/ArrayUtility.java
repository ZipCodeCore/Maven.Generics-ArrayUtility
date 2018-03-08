package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>{

    T[] array;


    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }


    public int getNumberOfOccurrences(T valueToEvaluate){
        int count = 0;
        for (int i = 0; i < array.length; i ++){
            if (array[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public int countDuplicatesInMerge(T[] inputArray, T valueToEvaluate){
        int count = 0;
        for (T element : inputArray){
            if (element.equals(valueToEvaluate)){
                count++;
            }
        }
        for (T element : this.array){
            if (element.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }
    public T getMostCommonFromMerge(T[] inputArray){
        int currentCount = 1;
        int mostCommonCount;

        T mostCommon = inputArray[0];
        T tempCount;

        for(int i = 1; i < inputArray.length-1; i++){
            tempCount = inputArray[i];
            mostCommonCount = 0;

            for (int j = 0; j < inputArray.length; j++){
                if (tempCount == inputArray[j]){
                    mostCommonCount++;
                }
                if (mostCommonCount > currentCount){
                    mostCommon = tempCount;
                }
            }

        }
        return mostCommon;
    }
    public T[] removeValue(T valueToRemove){
        int newSize = array.length - getNumberOfOccurrences(valueToRemove);

        T[] result = Arrays.copyOf(this.array, newSize);
        int index = 0;
        
        for (T value : this.array){
            if (!value.equals(valueToRemove)){

                result[index] = value;
                index++;
            }
        }
        return result;
    }
}

