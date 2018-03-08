package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] objects;
    private Integer valueToEvaluate;
    private ArrayList<E> list;

    public ArrayUtility(E[] theObject) {
        this.objects = theObject;
        list = new ArrayList<E>();
        Collections.addAll(list, this.objects);
    }


    public Integer countDuplicatesInMerge(E[]arrayToMerge, E valueToEvaluate) {
        Collections.addAll(list, arrayToMerge);
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public Integer getNumberOfOccurrences(E value) {
        Integer count = 0;
        for (E object : list) {
            if (object.equals(value)) {
                count++;
            }
        }
        return count;
    }


    public E getMostCommonFromMerge(E... arrayToMerge) {
        Collections.addAll(list, arrayToMerge);
        int total = 0;
        int temp = 0;
        E object = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            temp = getNumberOfOccurrences(list.get(i));
            if (total < temp) {
                total = temp;
                object = list.get(i);
            }
        }
        return object;
    }

    public E[] removeValue(E value) {
        for (E object : list) {
            if (object.equals(value)) {
              list.remove(object);
            }
        }
        @SuppressWarnings("unchecked")
        E[] object = (E[])list.toArray();
        return object;
    }
}



