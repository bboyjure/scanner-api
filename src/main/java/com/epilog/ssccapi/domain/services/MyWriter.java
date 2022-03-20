package com.epilog.ssccapi.domain.services;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class MyWriter {

    public void writeToFile(String barcode){
        try {
            String file = System.getProperty("user.dir") + "/SSCC_out.txt";
//            System.out.println(file);

            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(barcode + System.lineSeparator());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
