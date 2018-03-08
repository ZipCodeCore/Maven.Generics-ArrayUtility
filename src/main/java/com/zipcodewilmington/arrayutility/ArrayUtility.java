package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.lang.reflect.Array;
/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;

    public ArrayUtility(T[] array)
    {
        this.inputArray = array;
    }

    public T[] mergeArrays(T[]inputArray, T[] otherArray)
    {
        T[] finalArray = Arrays.copyOf(inputArray, inputArray.length + otherArray.length);

        System.arraycopy(otherArray, 0, finalArray, inputArray.length, otherArray.length);

        return finalArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate)
    {
        Integer count = 0;

        T[] newArray = mergeArrays(inputArray, arrayToMerge);

        for (int i = 0; i < newArray.length; i++)
        {
            if (newArray[i].equals(valueToEvaluate))
            {
                count++;
            }
        }

        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge)
    {
        Integer count = 0;
        T obj = null;

        T[] newArray = mergeArrays(inputArray, arrayToMerge);

        for (int i = 0; i < newArray.length; i++)
        {
            Integer n = getNumberOfOccurrences(newArray[i]);

            if (n > count)
            {
                count = n;
                obj = newArray[i];
            }

        }

        return obj;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate)
    {
        Integer count = 0;

        for (int i = 0; i < inputArray.length; i++)
        {
            if (inputArray[i].equals(valueToEvaluate))
            {
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T valueToRemove)
    {
        Integer size;
        size = inputArray.length - getNumberOfOccurrences(valueToRemove);

        T[] newArray;
        newArray = Arrays.copyOf(inputArray, size);

        int j = 0;

        for (int i = 0; i < inputArray.length; i++)
        {
            if (!inputArray[i].equals(valueToRemove))
            {
                newArray[j] = inputArray[i];
                j++;
            }
        }

        return newArray;
    }


}
