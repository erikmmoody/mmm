package com.erik.mmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Collection;

class MeanMedMode<N extends Number> {

    public static <N extends Number> double mean(Collection<N> list) {
        OptionalDouble average = list.stream().mapToDouble(n -> n.doubleValue()).average();
        return average.getAsDouble();
    }
    
    public static <N extends Number> double median(Collection<N> list) {
        ArrayList<N> nlist = new ArrayList<>(list);
        int middle = nlist.size()/2;
        return 2.0;
    }

}
