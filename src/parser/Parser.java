package parser;

import java.io.FileReader;
import java.util.Scanner;

import composite.Text;

public class Parser {
    public static Text parsing(String path) throws Exception {

        FileReader fr = new FileReader(path);
        Scanner sc = new Scanner(fr);

        String content = sc.nextLine();

        while (sc.hasNextLine()) {
            content = content + "\r" + sc.nextLine();
        }

        sc.close();
        fr.close();

        Text text = TextParser.parsingText(content);
        return text;
    }
}
