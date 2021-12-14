package composite;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {

    public List<TextComponent> sentence = new ArrayList<TextComponent>();

    @Override
    public void print() {
        for (TextComponent sentence : this.sentence) {
            if (sentence!=this.sentence.get(0) && sentence.getClass() != Symbol.class) {
                System.out.print(" ");
            }
            sentence.print();
        }
    }

    public void add(Word word) {
        sentence.add(word);
    }

    public void add(Lexeme lexeme) {
        sentence.add(lexeme);
    }

    public void add(Symbol symbol) {
        sentence.add(symbol);
    }
}