package com.example.iolab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReverser {
    public static void main(String[] args) {
        /*
         * FileReader reader = null;
         * FileWriter writer = null;
         * 
         * try {
         * reader = new FileReader("resources/input.txt");
         * writer = new FileWriter("resources/output.txt");
         * 
         * int character;
         * while ((character = reader.read()) != -1) {
         * writer.write(Character.toUpperCase((char) character));
         * }
         * } catch (IOException e) {
         * System.out.println("Error with file operations: " + e.getMessage());
         * } finally {
         * try {
         * if (reader != null) reader.close();
         * if (writer != null) writer.close();
         * } catch (IOException e) {
         * System.out.println("Error closing resources: " + e.getMessage());
         * }
         * }
         */
        /*
         * try(FileReader reader = new FileReader("resources/input.txt");
         * FileWriter writer = new FileWriter("resources/output.txt");
         * FileWriter writer2 = new FileWriter("resources/output2.txt")) {
         * 
         * int character;
         * int charCount = 0;
         * while((character = reader.read()) != -1) {
         * writer.write(character);
         * charCount++;
         * }
         * writer2.write("Number of characters: " + charCount);
         * 
         * }catch(IOException e){
         * System.out.println("Error with file operation: " + e.getMessage());
         * }
         */

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("resources/output.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error with file operations: " + e.getMessage());
        }
    }
}
