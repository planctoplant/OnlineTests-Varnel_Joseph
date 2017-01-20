/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acquisio.basic.java.question06;


public class CustomerProfessional extends Customer {
    public CustomerProfessional(double monthlyFee) {
        super("professional", monthlyFee);
    }
    
    public double getMonthlyMarginFees() {
        return monthlyFee * 1.20d;
    }
}
