package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T [] myArray;
    private  ArrayList<T> myArrayList;

    public ArrayUtility(T[] myArray) {
        this.myArray = myArray;
        myArrayList = new ArrayList<>();
        Collections.addAll(myArrayList,myArray);
    }

    public Integer countDuplicatesInMerge(T[]arrayToMerge, T valueToEvaluate){

        Collections.addAll(myArrayList,arrayToMerge);
        Integer count =0;
        for(int i =0;i<myArrayList.size();i++){
                if(myArrayList.get(i)==valueToEvaluate){
                    count++;
                }
            }

        return count;
    }

    public T getMostCommonFromMerge(T[]arrayToMerge){

        Collections.addAll(myArrayList,arrayToMerge);
        T mostCommon =myArrayList.get(0);
        for(int i=0;i<myArrayList.size();i++){
            if(getNumberOfOccurrences(myArrayList.get(i))>getNumberOfOccurrences(mostCommon)){
                mostCommon=myArrayList.get(i);
            }
        }



        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        int count=0;
        for(int i=0;i<myArrayList.size();i++){
            if(myArrayList.get(i)==valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove){
        //gT[] resultArray = (T[])Array.newInstance(T[],0);
        return null;
    }
}
