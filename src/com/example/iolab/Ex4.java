package com.example.iolab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";
        String outputPath = "resources/output.txt";
        
        int vowelCount = 0;
        int charCount = 0;

        try (FileReader reader = new FileReader(inputPath);
             FileWriter writer = new FileWriter(outputPath)) {
            
            int character;
            while ((character = reader.read()) != -1) {
                charCount++;
                if("AEIOUaeiou".indexOf(character) != -1) {
                    vowelCount++;
                }
                writer.write(Character.toUpperCase((char) character));
            }
            writer.write("\nTotal characters: " + charCount);
            writer.write("\nTotal vowels: " + vowelCount);
            System.out.println("File copied and converted to uppercase.");
            //writer.write(character);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        
    }
}
