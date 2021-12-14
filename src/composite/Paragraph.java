package composite;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {

    public List<TextComponent> paragraph = new ArrayList<TextComponent>();

    @Override
    public void print() {
        for (TextComponent paragraph : this.paragraph) {
            paragraph.print();
        }
        System.out.print("\r");
    }

    public void add(Sentence sentence) {
        paragraph.add(sentence);
    }
}