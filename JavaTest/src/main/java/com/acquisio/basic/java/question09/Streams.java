package com.acquisio.basic.java.question09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * QUESTION 09: Streams
 * Add the code to transform the input file to apply those rules.
 * 1- Filter out lines where the amount is lower than 50$
 * 2- Add a Taxes column right after the Amount column, which is 15% of the Amount.
 * 3- Add a Total column right after the Taxes column, which is the sum of Amount and Taxes.
 * 4- Remove the ShoppingCartTitle columns.
 * <p>
 * The input file contains those columns
 * User,Amount,ShoppingCartTitle,NbItems
 * <p>
 * IMPORTANT: Add all missing javadoc that you think is necessary.
 */
public class Streams {
    
    double filterAmount = 50.00d;
    double taxAmount = 0.15d;
    int amountPosition = 1;
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        Streams instance = new Streams();
        File input = new File(Thread.currentThread().getContextClassLoader().getResource("./carts.csv").toURI());
        File output = new File("./carts_output.csv");
        output.delete();

        instance.convertCarts(input, output);

        if (output.exists()) {
            Files.lines(output.toPath()).forEachOrdered(line -> System.out.println(line));
        }
    }

    private void convertCarts(File input, File output) throws IOException {
        // TODO: Insert your code here.
        String delimiter = ",";
        String line;
        InputStream iFileStream = new FileInputStream(input);
        InputStreamReader iStreamReader = new InputStreamReader(iFileStream, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(iStreamReader);
        
        OutputStream oOutputStream = new FileOutputStream(output);
        
        try {
        
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] data = line.split(delimiter);
                String[] newData = new String[data.length + 2];

                for(int col=0; col<data.length; col++) {

                    if (Double.parseDouble(data[1]) > filterAmount) {

                        if (col == amountPosition) {
                            double amount  = Double.parseDouble(data[col]);
                            newData[col+1] = String.format("%.2f", amount * taxAmount);
                            newData[col+2] = String.format("%.2f", amount * (1+taxAmount));
                        }

                        if (col > amountPosition) {
                            newData[col+2] = data[col];
                        } else {
                            newData[col] = data[col];
                        }
                    }

                }

                if (newData[0] != null) {

                    String newLine = newData[0];
                    for(int col=1; col<newData.length; col++) {
                        newLine += delimiter + newData[col];
                    }

                    oOutputStream.write(newLine.getBytes(Charset.forName("UTF-8")));

                }
            }
        } finally {

            br.close();
            iFileStream.close();
            iStreamReader.close();
            oOutputStream.close();
        }

    }

}
