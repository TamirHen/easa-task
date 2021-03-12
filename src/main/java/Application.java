package main.java;

import main.java.model.FileReader;

public class Application {
    public static void main(String[] args) {
        FileReader fr = new FileReader("resources/file.txt");
        fr.getReversedPairs().forEach(pair -> System.out.println(pair));
    }
}