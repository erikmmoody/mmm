package com.erik.mmm;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        double mean = MeanMedMode.mean(input);
        assertEquals(mean, 10.0/3.0, 0.0f);
    }
}
