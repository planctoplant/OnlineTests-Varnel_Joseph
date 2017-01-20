package com.acquisio.basic.java.question8;

import com.acquisio.basic.java.question08.Calculator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {
    Exception exceptionError;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void cleanUpStream() {
        System.setOut(null);
    }
    
    @Test
    public void testAdd() {
        Calculator instance = new Calculator();
        int result = instance.applyOperation(1, 1, '+');
        assertEquals(2, result);
    }
    
    @Test
    public void testSub() {
        Calculator instance = new Calculator();
        int result = instance.applyOperation(1, 1, '-');
        assertEquals(0, result);
    }
    
    @Test
    public void testDiv() {
        Calculator instance = new Calculator();
        int result = instance.applyOperation(1, 1, '/');
        assertEquals(1, result);
    }
    
    @Test
    public void testMul() {
        Calculator instance = new Calculator();
        int result = instance.applyOperation(1, 1, '*');
        assertEquals(1, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNoExceptionThrown() {
        Calculator instance = new Calculator();
        int result = instance.applyOperation(1, 1, 'a');
    }
}
