package com.toorak.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.toorak.utils.FileUtils;

public class TextFileDemo {
	 public static void main(String[] args) {
	        String filePath = "example.txt";
	        FileUtils fileUtils = new FileUtils();
	        fileUtils.writeIntoTextFile(filePath, "Apple", "1000");
	        
	        List<String> dd = fileUtils.readTextFile(filePath);
	        System.out.println("22222:::"+dd);
	       
	        System.out.println(dd.get(0));
	        System.out.println(dd.get(1));

	       /* // Writing to the file
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write("Hello, World!");
	            writer.newLine();
	            writer.write("This is a sample text file.");
	            writer.newLine();
	            writer.write("Goodbye!");
	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        }

	        // Reading from the file
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading from file: " + e.getMessage());
	        }
	    }*/
   }
}
