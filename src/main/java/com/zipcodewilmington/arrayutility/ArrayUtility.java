package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;

    public ArrayUtility(T[] anArray) {
        this.array = anArray;
    }


    public Integer countDuplicatesInMerge(T[] anotherArray, T aValue) {

        Integer countOfValue = 0;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(aValue)) {
                countOfValue++;
            }
        }

        for (int j = 0; j < anotherArray.length; j++) {
            if (anotherArray[j].equals(aValue)) {
                countOfValue++;
            }
        }

        return countOfValue;
    }

    public T getMostCommonFromMerge(T[] anArray) {

        Integer mostCommonCount = 0;
        T mostCommon = null;

        for (int i = 0; i < this.array.length; i++) {
            if (countDuplicatesInMerge(anArray, this.array[i]) > mostCommonCount) {
                mostCommon = this.array[i];
            }
        }

        return mostCommon;
    }


    public Integer getNumberOfOccurrences(T value) {

        Integer count = 0;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T value) {

        int resize = getNumberOfOccurrences(value);

        T[] another = Arrays.copyOf(this.array, this.array.length - resize);

        int secondIterator = 0;

        for (int i = 0; i < this.array.length; i++) {
            if (!this.array[i].equals(value)) {
                another[secondIterator] = this.array[i];
                secondIterator++;
            }
        }

        return another;
    }

}
