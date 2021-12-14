package main;

import composite.*;
import parser.Parser;
import functionality.Functionality;

public class Main {
    public static void main(String[] args) throws Exception {
        Text a = Parser.parsing("d://NIITZI/Tasks/text.txt");
        a.print();

        System.out.println();

        a = Functionality.sortParagraph(a);
        a.print();

        System.out.println();

        Sentence c = Functionality.sentenceWithLongestWord(a);
        c.print();

        System.out.println();
        System.out.println();

        a = Functionality.deleteSentences(a, 14);
        a.print();

        System.out.println();
        System.out.println(Functionality.searchIdenticalWords(a));
    }
}