package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public static List<String> readFromFile(String path) {

        if (path == null || path.isBlank()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException exception) {
            System.out.println("File not found!");
        }
        return result;
    }
}
