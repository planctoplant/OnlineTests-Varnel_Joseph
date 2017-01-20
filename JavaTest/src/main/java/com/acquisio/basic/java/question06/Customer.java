package com.acquisio.basic.java.question06;

public abstract class Customer {
    String type; // enterprise, professional or private
    double monthlyFee;

    public Customer(String type, double monthlyFee) {
        this.type = type;
        this.monthlyFee = monthlyFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    
    abstract double getMonthlyMarginFees();
}





