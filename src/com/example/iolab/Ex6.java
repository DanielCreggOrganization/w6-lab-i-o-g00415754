package com.example.iolab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex6 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";

        // Reading and counting words
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long wordCount = lines.flatMap(line->Arrays.stream(line.split("\\s+"))).count();
            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // counting lines that contain specific word
        String specificword = "Java";
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long count = lines.filter(line->line.contains(specificword)).count();
            System.out.println("Number of lines that contain " + specificword  + ": " + count);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        // Filtering lines
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long nonEmptyLines = lines
                .filter(line -> !line.trim().isEmpty())
                .count();
            System.out.println("Non-empty lines: " + nonEmptyLines);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        //word frequency
        try  (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            Map<String, Long> wordFreq = lines.flatMap(line->Arrays.stream(line.split("\\s+"))).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            wordFreq.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(5).forEach(entry->System.out.println(entry.getKey() + ": " + entry.getValue()));;
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
