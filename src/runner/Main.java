package runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import logic.*;
import textEntities.*;

public class Main {

    public static void main(String[] args) {
        String str = ReaderFromFile.read("someText.txt");
        System.out.println("------ ORIGINAL TEXT -------");
        System.out.println(str);
        List<Sentence> sentences = new ArrayList<>();
        sentences = Parser.parse(str);
        sort(sentences, new WordCountComparator());
    }

    public static void sort(List<Sentence> sentences, Comparator<Sentence> comparator) {
        Collections.sort(sentences, comparator);
        System.out.println("----- SORTED SENTENCES -----");
        for (Sentence aSentence : sentences) {
            System.out.println(aSentence.toString().trim());
        }
    }
}
