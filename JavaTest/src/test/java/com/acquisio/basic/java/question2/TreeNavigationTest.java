/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question2;
import com.acquisio.basic.java.question02.Node;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author asalys
 */
public class TreeNavigationTest {
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
    public void testLeaf() {
        Node n = new Node("2");
        n.printTree();
        assertEquals("2\n", outContent.toString());
    }
    
    @Test
    public void testTree() {
        Node n = new Node("2", new Node("2"), new Node("3"));
        n.printTree();
        assertEquals("..2\n....2\n....3\n", outContent.toString());
    }
}
