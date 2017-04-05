package textEntities;

public class Punctuation implements SentenceElement {
    private char punctuationMark;

    public Punctuation(char punctuationMark) {
        super();
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuationMark);
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

}
