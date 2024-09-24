package com.toorak.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	public static void writeIntoTextFile(String filePath,String productName,String productPrice) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write(productName);
	            writer.newLine();
	            writer.write(productPrice);
	          } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        }
	}
	
	public static List<String> readTextFile(String filePath) {
		///StringBuilder sb = null;
		List<String> lst = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
             //sb = new StringBuilder();
             lst = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                //sb.append(line+" ");
                lst.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
		return lst;
    }

	

}
