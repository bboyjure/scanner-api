package com.epilog.ssccapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    ScannerService scannerService;

    @Autowired
    MyWriter myFileWriter;


    @Override
    public void run(String... args) throws Exception {
        do{
            System.out.println("Enter code");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] lines = input.split(" ");
            Stream<String> stream = Arrays.stream(lines);
            stream.forEach(line -> {
                try{
                    scannerService.isValid(line);
                    scannerService.validateFormatAndCheckDigit(line);
                    myFileWriter.writeToFile(line);
                }
                catch (Exception ex) { System.out.println(ex.getMessage()); }
            });
        }while(true);

    }
}
