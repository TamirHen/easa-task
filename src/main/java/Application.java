package main.java;

import main.java.reader.FileReader;

public class Application {
    public static void main(String[] args) {
        FileReader basicTest = new FileReader("resources/basic-test.txt");
        FileReader spacesTest = new FileReader("resources/spaces-test.txt");
        FileReader longTest = new FileReader("resources/long-test.txt");

        basicTest.getReversedPairs().forEach(System.out::println);
        System.out.println("----------");
        spacesTest.getReversedPairs().forEach(System.out::println);
        System.out.println("----------");
        longTest.getReversedPairs().forEach(System.out::println);
    }
}