package composite;

import java.util.List;
import java.util.ArrayList;

public class Text implements TextComponent {

    public List<TextComponent> text = new ArrayList<TextComponent>();

    @Override
    public void print() {
        for (TextComponent text : this.text) {
            text.print();
        }
    }

    public void add(Paragraph paragraph) {
        text.add(paragraph);
    }
}