package com.edgartest.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
//import org.junit.*;
import org.apache.log4j.Logger;

public class App 
{
    //private static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        long startTime = System.currentTimeMillis();
        if(args.length != 1){
            //logger.error("Incorrect number of arguments, provide just one argument with the name of the csv file");
        }
        else{
            String csvFile = args[0];
            if (!csvFile.matches("(.)*[.]csv")) {
                //logger.error("Incorrect filename or filetype");
            }
            else{
                //logger.debug("File name: " + csvFile);

                String line = "";
                String delimiter = ",";
                int mfCount = 0;

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    System.out.println("\nLines with Multi-Family token:");
                    while ((line = br.readLine()) != null) {
                        String[] fields = line.split(delimiter);
                        // I wanted to be explicit, it could be code in just one foreach loop though
                        for (String field : fields) {
                            String[] tokens = field.split(" ");
                            for (String token : tokens) {
                                if (token.contains("Multi-Family")) {
                                    mfCount++;
                                    System.out.println(line);
                                }
                            }
                        }
                    }
                    System.out.println("\nWordcount:" + mfCount);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nRunning Time (Seconds): " + totalTime/1000.0);
    }
}
