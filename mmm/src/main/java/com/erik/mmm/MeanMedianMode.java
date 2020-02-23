package com.erik.mmm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeanMedianMode {

    public static double mean(List<Integer> list) {
        int total = list.stream().reduce(0, (a,b) -> a+b);
        double mean = (double) total / (double) list.size();
        return mean;
    }

    public static double median(List<Integer> list) {
        Collections.sort(list);
        int middle = list.size() / 2;
        if(list.size() % 2 == 0) {
            return ((double) list.get(middle) + (double) list.get(middle - 1)) / 2;
        } else {
            return (double) list.get(middle);
        }
    }
    /*
    I found conflicting information as to whether the mode is defined on a list in which
    all entries appear equally frequently. Some resources claim that mode is defined on
    any finite list, while others claim that if all numbers appear equally often in a list, that
    list has no mode. Since it would be pretty pathological for a list to have no mode,
    I chose to throw an exception in this case.
    */
    public static ArrayList<Integer> mode(List<Integer> list) throws IllegalArgumentException {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : list) {
            if (freqMap.containsKey(i)) {
                int count = freqMap.get(i);
                count ++;
                freqMap.put(i, count);
            } else {
                freqMap.put(i, 1);
            }
        }

        int max = 0;
        for (int v : freqMap.values()) {
            if (v > max) {
                max = v;
            }
        }
    
        ArrayList<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : freqMap.entrySet()) {
            if (pair.getValue() == max) {
                modes.add(pair.getKey());
            }
        }
        List<Integer> uniqueList = list.stream().distinct().collect(Collectors.toList());
        if (modes.size() == uniqueList.size()) {
            throw new IllegalArgumentException("Input list has no mode!");
        }
        return modes;
    }
}