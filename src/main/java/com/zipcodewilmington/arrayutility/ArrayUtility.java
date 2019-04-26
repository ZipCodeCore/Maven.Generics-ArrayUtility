package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * filename:
 * project: question1
 * author: https://github.com/vvmk
 * date: 3/5/18
 */
public class ArrayUtility<T> {
    private T[] base;

    public ArrayUtility(T[] base) {
        this.base = base;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToCheck) {
        mergeArrays(arrayToMerge);
        return getNumberOfOccurrences(valueToCheck);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommon = null;
        int mostOccurrences = 0;
        mergeArrays(arrayToMerge);
        for (T t : base) {
            int count = getNumberOfOccurrences(t);
            if (count > mostOccurrences) {
                mostCommon = t;
                mostOccurrences = count;
            }
        }
        return mostCommon;
    }

    public int getNumberOfOccurrences(T objectToCheck) {
        int sum = 0;
        for (T t : base) {
            if (objectToCheck.equals(t))
                sum++;
        }
        return sum;
    }

    public T[] removeValue(T objectToRemove) {
        T[] ret = base;
        for (int i = 0; i < base.length; i++) {
            if (base[i].equals(objectToRemove)) {
                ret = Arrays.copyOf(Arrays.copyOfRange(base, 0, i), base.length - 1);
                System.arraycopy(base, i + 1, ret, i, base.length - i - 1);
                base = ret;
            }
        }
        return ret;
    }

    protected void mergeArrays(T[] arrayToMerge) {
        int newSize = base.length + arrayToMerge.length;
        base = Arrays.copyOf(base, newSize); // base should be referenceing new array that is identical except length = newSize;
        System.arraycopy(arrayToMerge, 0, base, (newSize - arrayToMerge.length), arrayToMerge.length);
    }

    public T[] getBase() {
        return base;
    }
}

