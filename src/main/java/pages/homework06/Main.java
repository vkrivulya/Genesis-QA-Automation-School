package pages.homework06;

import helpers.FileReaderHelper;

public class Main {

    public static final String fileName = "/Users/v.kryvulia/Desktop/file.txt";

    public static void main(String[] args) {
        FileReaderHelper fileReader = new FileReaderHelper();
        fileReader.readFile(fileName);
    }
}
