/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question06;


public class CustomerPrivate extends Customer {
    public CustomerPrivate(double monthlyFee) {
        super("private", monthlyFee);
    }
    
    public double getMonthlyMarginFees() {
        return monthlyFee * 1.30d;
    }
}
