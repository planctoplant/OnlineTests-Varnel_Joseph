/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question4;


import com.acquisio.basic.java.question04.IssueResolving;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author asalys
 */
public class IssueResolvingTest {

    
    Exception exceptionError;
    
    @Test
    public void testFactorial1() {
        IssueResolving instance = new IssueResolving();
        assertEquals(instance.getFactorial(1), 1);
    }
    
    @Test
    public void testFactorial7() {
        IssueResolving instance = new IssueResolving();
        assertEquals(instance.getFactorial(7), 5040);
    }
    
    @Test
    public void testNoExceptionThrown() {
        try {
            IssueResolving instance = new IssueResolving();
            assertEquals(instance.getFactorial(9), 362880);
        } catch (Exception e) {
            exceptionError = e;
        }
        
        assertEquals(null, exceptionError);
    }
    
}
