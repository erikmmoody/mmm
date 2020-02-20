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

class MeanMedMode<N extends Number> {

    public static <N extends Number> BigDecimal bigMean(Collection<N> list, int points) {
        ArrayList<BigDecimal> bigList = new ArrayList<>();
        for (N n : list) {
            bigList.add(new BigDecimal(n.toString()));
        }
        BigDecimal total = bigList.stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        BigDecimal mean = total.divide(BigDecimal.valueOf(bigList.size()));
        return mean.setScale(points, RoundingMode.HALF_UP);
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

}
