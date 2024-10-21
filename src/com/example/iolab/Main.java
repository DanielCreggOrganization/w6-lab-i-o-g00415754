package com.example.iolab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, Java I/O!");

        Path projectRoot = Paths.get(System.getProperty("user.dir"));

        Path inputFilePath = 
        projectRoot.resolve("resources").resolve("input.txt");

        if(Files.exists(inputFilePath)) {
            System.out.println("input.txt found at: " + 
            inputFilePath.toAbsolutePath()); 
        }else{
            System.out.println("input.txt not found!");
        }


    }
}
