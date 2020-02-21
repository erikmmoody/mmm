package com.erik.mmm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

public class MeanMedianModeTest {
    String testFile = "src/test/resources/test.txt";
    ArrayList<Integer> data;

    @Test
    @Order(1)
    void testWithFile() throws IOException {
        DataInputStream reader = new DataInputStream(new FileInputStream(testFile));
        int bytesLeft = reader.available();
        String testData = null;
        if(bytesLeft > 0) {
            byte[] bytes = new byte[bytesLeft];
            reader.read(bytes);
            testData = new String(bytes);
        }
        reader.close();
        //String [] arr = testData.split(" ");
        this.data = new ArrayList<>(); 
        Arrays.stream(testData.split(" ")).mapToInt(st -> Integer.parseInt(st)).forEach(i -> data.add(i));
        double mean = MeanMedianMode.mean(data);
        assertEquals(mean, 49.7064, 0.0d);
        List<Integer> modes = MeanMedianMode.mode(data);
        assertEquals(modes.get(0), 65);

        double median = MeanMedianMode.median(data);
        assertEquals(median, 50.0, 0.0d);
       
    }  
}