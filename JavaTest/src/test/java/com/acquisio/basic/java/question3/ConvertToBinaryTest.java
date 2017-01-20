/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question3;

import com.acquisio.basic.java.question03.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author asalys
 */
public class ConvertToBinaryTest {
    
    @Test
    public void test17toBinary() {
        ConvertToBinary instance = new ConvertToBinary();
        assertEquals(instance.recBin(17), 10001);
    }
    
}
