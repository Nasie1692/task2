package textEntities;

import java.util.List;
import textEntities.Symbol;

public class Word implements SentenceElement {
    private List<Symbol> symbols;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(symbols.size());
        for (Symbol symbol : symbols) {
            builder.append(symbol.getSymbol());
        }
        return " " + builder.toString();
    }

    public Word() {
        super();
    }

    public Word(List<Symbol> symbols) {
        super();
        this.symbols = symbols;
    }

    public List<Symbol> getChars() {
        return symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

}
