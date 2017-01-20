package com.acquisio.basic.java.question03;

/**
 * QUESTION 03: ToBinary
 * Write a recursive function that allows converting a
 * integer number into a binary number.
 * For example, with the value 22, the method should return "10110"
 * <p>
 * If you need more classes, simply define them inline.
 *
 * IMPORTANT: Add all missing javadoc that you think is necessary.
 */
public class ConvertToBinary {

    public static void main(String[] args) {
        ConvertToBinary instance = new ConvertToBinary();
        System.out.println(instance.convertToBinary(17));
    }
    
    public ConvertToBinary() {}
    

    private String convertToBinary(int val) {
        int binFormat = recBin(val);
        return Integer.toString(binFormat);
    }
    
    public int recBin(int dec) {
        int remainder=dec%2;
        if (dec==1 || dec==0) {
            return dec;
        } else {
            return remainder + (recBin(dec/2)*10);
        }
    }
}
