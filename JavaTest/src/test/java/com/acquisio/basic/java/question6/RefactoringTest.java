/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question6;

import com.acquisio.basic.java.question06.Customer;
import com.acquisio.basic.java.question06.CustomerEnterprise;
import com.acquisio.basic.java.question06.FeeCalculator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author asalys
 */
public class RefactoringTest {
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
    public void testMonthlyFeeMargin() {
        Customer c1 = new CustomerEnterprise(0.0d);
        Customer c2 = new CustomerEnterprise(0.0d);
        double monthlyFees = FeeCalculator.sumFeesWithMargin(c1, c2);
        assertEquals(0.0d, monthlyFees, 0);
        
    }
    
}
