package logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderFromFile {
    public static String read(String fileName) {
        String readingString = null;
        try {
            readingString = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readingString;
    }

}
