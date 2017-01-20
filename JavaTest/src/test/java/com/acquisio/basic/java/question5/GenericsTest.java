/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question5;

import com.acquisio.basic.java.question05.Generics;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author asalys
 */
public class GenericsTest {
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
    public void testInventory() {
        Generics instance = new Generics();
        instance.printStockInventory();
        assertEquals("Apple [red] : 50 units\n" +
                "Apple [green] : 45 units\n" +
                "Banana [yellow] : 150 units\n" +
                "Pineapple [yellow] : 10 units\n" +
                "Salad [Iceberg] : 19 units\n" +
                "Salad [Boston] : 18 units\n" +
                "Salad [Iceberg] : 17 units\n", outContent.toString()
        );
    }
}

