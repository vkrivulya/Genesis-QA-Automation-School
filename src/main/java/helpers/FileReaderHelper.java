package helpers;

import pages.homework06.CustomException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderHelper {

    public void readFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("Incorrect filename : " + filename);
        }
    }
}
