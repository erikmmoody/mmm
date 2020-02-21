package com.erik.mmm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<Integer> mode(List<Integer> list) {
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

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : freqMap.entrySet()) {
            if (pair.getValue() == max) {
                modes.add(pair.getKey());
            }
        }
        return modes;
    }
}