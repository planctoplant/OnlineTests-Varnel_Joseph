package com.acquisio.basic.java.question08;

/**
 * QUESTION 08: Unit Test
 * Add Unit Test method(s) to test this method.
 * Add your tests to the CalculatorTest class to see the result of
 * your test.
 *
 * IMPORTANT: Add all missing javadoc that you think is necessary.
 */
public class Calculator {
    public static Integer applyOperation(int x, int y, char operator) {
        if (operator == '+') {
            return x + y;
        } else if (operator == '-') {
            return x - y;
        } else if (operator == '*') {
            return x * y;
        } else if (operator == '/') {
            if (y != 0) {
                return x / y;
            } else {
                return null;
            }
        } else {
            throw new IllegalArgumentException(
                    String.format("Operator '%s' not supported", operator));
        }
    }

}
