package composite;

public class Lexeme implements TextComponent {

    String lexeme;

    public Lexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public void print() {
//		System.out.print(lexeme);
    }
}