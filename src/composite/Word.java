package composite;

public class Word implements TextComponent {

    public String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public void print() {
        System.out.print(word);
    }
}