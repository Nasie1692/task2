package textEntities;

import java.util.List;

public class Sentence {
    private List<SentenceElement> sentenceElements;

    public List<SentenceElement> getSentenceElements() {
        return sentenceElements;
    }

    public void setSentenceElements(List<SentenceElement> sentenceElements) {
        this.sentenceElements = sentenceElements;
    }

    public Sentence() {
        super();
    }

    public Sentence(List<SentenceElement> sentenceElements) {
        super();
        this.sentenceElements = sentenceElements;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(sentenceElements.size());
        for (SentenceElement sentenceElement : sentenceElements) {
            builder.append(sentenceElement.toString());
        }
        return builder.toString();
    }

    public int getWordCount() {
        int wordCount = 0;
        for (SentenceElement sentenseElement : getSentenceElements()) {
            if (sentenseElement instanceof Word) {
                wordCount++;
            }
        }
        return wordCount;
    }

}
