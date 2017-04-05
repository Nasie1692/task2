package logic;

import java.util.Comparator;
import textEntities.*;

public class WordCountComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence sentence1, Sentence sentence2) {
        return sentence1.getWordCount() - sentence2.getWordCount();
    }
}
