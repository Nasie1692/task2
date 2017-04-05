package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import textEntities.*;

public class Parser {
    public static List<Sentence> parse(String string) {

        List<Punctuation> punctuationMarks = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>();

        /*
         * Будем полагать, что предложение начинается с заглавной буквы и
         * заканчивается точкой и следующим за ней пробелом. Слова разделены
         * пробелом, после знаков препинания (точка, двоеточие и т.д.) следует
         * пробел. Дефис, коммерческое at знаками препинания не считаются.
         */
        Pattern p = Pattern.compile(
                "(^|(?<=[.!?]\\s))(\\d+\\.\\s?)*[А-ЯA-Z][^!?]*?[.!?](?=\\s*(\\d+\\.\\s)*[А-ЯA-Z]|$)",
                Pattern.MULTILINE);
        Matcher sentence = p.matcher(string);
        /* делим текст на предложения */
        while (sentence.find()) {
            List<SentenceElement> aSentence = new ArrayList<>();
            int index = 0;
            /* делим предложение на слова */
            for (String word : sentence.group().split("\\s")) {
                Punctuation pm = null;
                List<Symbol> symbols = new ArrayList<>();
                for (int i = 0; i < word.length(); i++) { // делим на символы
                    if (!(Character.isLetterOrDigit(word.charAt(i))) && (i == word.length() - 1)) {
                        pm = new Punctuation(word.charAt(i));
                        punctuationMarks.add(new Punctuation(word.charAt(i)));
                    } else {
                        symbols.add(new Symbol(word.charAt(i)));
                    }
                }
                /* собираем символы в слово и добавляем в предложение */
                aSentence.add(index, new Word(symbols));
                index++;
                if (pm != null) {
                    aSentence.add(index, pm); // добавляем знак препинания в предложение
                    index++;
                }
            }
            sentences.add(new Sentence(aSentence));
        }
        return sentences;
    }
}
