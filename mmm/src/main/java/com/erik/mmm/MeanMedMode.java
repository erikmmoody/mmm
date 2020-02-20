package com.erik.mmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

class MeanMedMode<N extends Number> {

    public static <N extends Number> BigDecimal bigMean(Collection<N> list, int precision) {
        ArrayList<BigDecimal> bigList = new ArrayList<>();
        for (N n : list) {
            bigList.add(new BigDecimal(n.toString()));
        }
        BigDecimal total = bigList.stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        BigDecimal mean = total.divide(BigDecimal.valueOf(bigList.size()), precision, RoundingMode.HALF_UP);
        return mean;
    }

    public static <N extends Number> double mean(Collection<N> list) {
        OptionalDouble average = list.stream().mapToDouble(n -> n.doubleValue()).average();
        return average.getAsDouble();
    }

    public static <N extends Number> double median(Collection<N> list) {
        ArrayList<Double> nlist = new ArrayList<>();
        for (N n : list) {
            nlist.add(n.doubleValue());
        }
        if (nlist.size() < 2) {
            return nlist.get(0);
        }
        int middle = nlist.size()/2;
        
         
        Collections.sort(nlist);
        double median;
        if (nlist.size() % 2 == 0) {
            median = (nlist.get(middle) + nlist.get(middle-1))/2;
        } else {
            median = nlist.get(middle);

        }
        return median;
    }

    public static <N extends Number> BigDecimal mode(Collection<N> list, int precision) {
        ArrayList<BigDecimal> bigList = new ArrayList<>();
        for (N n : list) {
            bigList.add(new BigDecimal(n.toString()).setScale(precision));
        }
        HashMap<BigDecimal, Integer> freqMap = new HashMap<>();
        return bigList.get(0);
    }

    public static <N extends Number> BigDecimal bigMedian(Collection<N> list) {
        ArrayList<BigDecimal> bigList = new ArrayList<>();
        for (N n : list) {
            bigList.add(new BigDecimal(n.toString()));
        }
        if (bigList.size() < 2) {
            return bigList.get(0);
        }
        int middle = bigList.size()/2;
        
         
        Collections.sort(bigList);
        BigDecimal median;
        if (bigList.size() % 2 == 0) {
            median = (bigList.get(middle)
                        .add(bigList.get(middle-1)))
                        .divide(BigDecimal.valueOf(2.0));
        } else {
            median = bigList.get(middle);

        }

        return median;

    }

    

}
