package com.erik.mmm;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    void arrayList()
    {
        ArrayList<Double> input = new ArrayList<>();
        input.add(1.9);
        input.add(2.0);
        double mean = MeanMedMode.mean(input);
        assertEquals(mean, 1.95, 0.0f);
    }
    
    @Test
    void linkedList() {
        LinkedList<Double> input = new LinkedList<>();
        input.add(1.9);
        input.add(2.0);
        double mean = MeanMedMode.mean(input);
        assertEquals(mean, 1.95, 0.0f);
    }
    
    @Test
    void floating() {
        ArrayList<Double> input = new ArrayList<>();
        input.add(1.0);
        input.add(2.0);
        input.add(7.0);
        BigDecimal mean = MeanMedMode.bigMean(input, 4);
        assertEquals(mean.compareTo(BigDecimal.valueOf(3.3333)), 0);
    }

    @Test
    void median() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        double median = MeanMedMode.median(input);
        assertEquals(median, 3.0, 0.0f);
    }

    @Test
    void medianEven() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        double median = MeanMedMode.median(input);
        assertEquals(median, 3.5, 0.0f);
    }

    @Test
    void bigMean() {
        ArrayList<Double> input = new ArrayList<>(Arrays.asList(6.473343575064627, 25.074808132784444, 46.56863481297735, 
                                                                42.15683212179127, 38.66108248577888, 83.03051130301404, 13.476309649766883, 
                                                                54.80119585316232, 87.91815314181547, 71.15110877901036));
        BigDecimal mean = MeanMedMode.bigMean(input, 14);
        System.out.println("***********/*/*/*/**/*/*/*/*/*/*/");
        System.out.println(mean);
        assertEquals(mean.compareTo(BigDecimal.valueOf(46.93119798551656)), 0);

    }

    @Test
    void bigMeanInt() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        BigDecimal mean = MeanMedMode.bigMean(input, 2);
        assertEquals(mean.compareTo(BigDecimal.valueOf(5.5)), 0);
    }

    @Test
    void bigMedian() {
        ArrayList<Double> input = new ArrayList<>(Arrays.asList(6.473343575064627, 25.074808132784444, 46.56863481297735, 
                                                                42.15683212179127, 38.66108248577888, 83.03051130301404, 13.476309649766883, 
                                                                54.80119585316232, 87.91815314181547, 71.15110877901036));
        BigDecimal median = MeanMedMode.bigMedian(input);
        assertEquals(median.compareTo(BigDecimal.valueOf(44.36273346738431)), 0);
    }
}
