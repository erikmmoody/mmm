package com.erik.mmm;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MeanMedianModeTest {
    String uniformDist = "src/test/resources/uniformDist.txt";
    String normalDist = "src/test/resources/normalDist.txt";

    @Test
    @Order(1)
    void testUniformDist() throws IOException {
        DataInputStream reader = new DataInputStream(new FileInputStream(uniformDist));
        int bytesLeft = reader.available();
        String testData = null;
        if(bytesLeft > 0) {
            byte[] bytes = new byte[bytesLeft];
            reader.read(bytes);
            testData = new String(bytes);
        }
        reader.close();
        ArrayList<Integer> data = new ArrayList<>(); 
        Arrays.stream(testData.split(" ")).mapToInt(st -> Integer.parseInt(st)).forEach(i -> data.add(i));
        
        double mean = MeanMedianMode.mean(data);
        assertEquals(mean, 49.7064, 0.0d);
        
        List<Integer> modes = MeanMedianMode.mode(data);
        assertEquals(modes.get(0), 65);

        double median = MeanMedianMode.median(data);
        assertEquals(median, 50.0, 0.0d);
       
    } 
    
    @Test
    void testNormalDist() throws IOException {
        DataInputStream reader = new DataInputStream(new FileInputStream(normalDist));
        int bytesLeft = reader.available();
        String testData = null;
        if(bytesLeft > 0) {
            byte[] bytes = new byte[bytesLeft];
            reader.read(bytes);
            testData = new String(bytes);
        }
        reader.close();
        ArrayList<Integer> data = new ArrayList<>(); 
        Arrays.stream(testData.split(" ")).mapToInt(st -> Integer.parseInt(st)).forEach(i -> data.add(i));
        
        double mean = MeanMedianMode.mean(data);
        assertEquals(mean, -0.196, 0.0d);
        
        List<Integer> modes = MeanMedianMode.mode(data);
        assertEquals(modes.get(0), -5);

        double median = MeanMedianMode.median(data);
        assertEquals(median, 0.0, 0.0d);
    }

    @Test 
    void singleNumber() {
        ArrayList<Integer> testData = new ArrayList<>();
        testData.add(1);

        double mean = MeanMedianMode.mean(testData);
        assertEquals(mean, 1.0, 0.0d);

        double median = MeanMedianMode.median(testData);
        assertEquals(median, 1.0, 0.0d);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MeanMedianMode.mode(testData);
        });

        String expectedMessage = "Input list has no mode!";
        assertTrue(expectedMessage.contains(exception.getMessage()));

    }
    
    @Test
    void noMode() {
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(1,1,2,2,3,3));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MeanMedianMode.mode(testData);
        });

        String expectedMessage = "Input list has no mode!";
        assertTrue(expectedMessage.contains(exception.getMessage()));
    }

    @Test
    void multiMode() {
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3,4,5,6,7,8,9));
        List<Integer> modes = MeanMedianMode.mode(testData);
        assertEquals(modes.size(), 3);

        assertTrue(modes.contains(1));

        assertTrue(modes.contains(2));

        assertTrue(modes.contains(3));
    }

    @Test
    void medianEvenList() {
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        double median = MeanMedianMode.median(testData);
        assertEquals(median, 3.5, 0.0d);
    }

    void medianOddList() {
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        double median = MeanMedianMode.median(testData);
        assertEquals(median, 3.0, 0.0d);
    }
}