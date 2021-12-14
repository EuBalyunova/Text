package composite;

public class Symbol implements TextComponent {

    String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void print() {
        if (symbol.charAt(0)=='-') {
            System.out.print(" ");
        }
        if (symbol.charAt(0)!='-' && symbol.charAt(0)!=',') {
            System.out.print(symbol + " ");
        } else {
            System.out.print(symbol);
        }
    }
}