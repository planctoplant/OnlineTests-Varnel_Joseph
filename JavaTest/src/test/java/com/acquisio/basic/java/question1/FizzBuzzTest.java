/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question1;
import com.acquisio.basic.java.question01.FizzBuzz;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author asalys
 */
public class FizzBuzzTest {
    FizzBuzz fizzBuzz;
    
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
    public void testEmpty() {
        FizzBuzz main = new FizzBuzz(0);
        assertEquals("", outContent.toString());
    }
    
    @Test
    public void test50() {
        FizzBuzz main = new FizzBuzz(50);
        assertEquals("5050Fizz5050BuzzFizz505050Fizz50Buzz50Fizz505050FizzBuzz5050Fizz5050BuzzFizz505050Fizz50Buzz50Fizz505050FizzBuzz5050Fizz5050BuzzFizz505050Fizz50Buzz50Fizz505050FizzBuzz5050Fizz5050Buzz", outContent.toString());
    }
    
    @Test
    public void testDiv3() {
        FizzBuzz main = new FizzBuzz(3);
        assertEquals("33Fizz3", outContent.toString());
    }
    
    
}