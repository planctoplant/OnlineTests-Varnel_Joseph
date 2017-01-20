package com.acquisio.basic.java.question06;

public class FeeCalculator {
    public static double sumFeesWithMargin(Customer ... customers) {
        double monthlyFees = 0.0d;
        for (Customer c : customers) {
            monthlyFees += c.getMonthlyMarginFees();
        }

        return monthlyFees;
    }
}
