package main.java.model;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class FileReader {
    private File file;
    private Scanner scanner;

    public FileReader(@NotNull String pathname) {
        file = new File(pathname);
        scan();
    }

    private void scan() {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getReversedPairs() {
        StringBuilder sb = new StringBuilder();
        // Using HashMap for optimized search efficiency:
        Map<String, String> wordsAndReversed = new HashMap<>();
        // Using HashSet to remove duplicates:
        Set<String> pairs = new HashSet<>();
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            // Remove unnecessary spaces:
            currentLine = currentLine.trim().replaceAll(" +", " ");
            String[] words = currentLine.split(" ");
            for (String word : words) {
                String reversed = sb.append(word).reverse().toString();
                if (wordsAndReversed.containsValue(word)) pairs.add(reversed + ", " + word);
                else wordsAndReversed.put(word, reversed);
                // Clear the StringBuilder:
                sb.setLength(0);
            }
        }
        return pairs.stream().sorted(Comparator.comparingInt(String::length)).collect(toCollection(ArrayList::new));
    }

}
