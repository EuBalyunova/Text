package parser;

import composite.Paragraph;
import composite.Sentence;

public class ParagraphParser {
    public static Paragraph parsingParagraph(String content) {
        Paragraph paragraph = new Paragraph();

        int count=0;

        for (int i=0; i<content.length(); i++) {
            if (content.charAt(i)=='.' && content.charAt(i+1)=='.' && content.charAt(i+2)=='.') {
                count++;
                i=i+4;
            }
            if (content.charAt(i)=='?' || (content.charAt(i)=='.' && content.charAt(i-1)!='.') || content.charAt(i)=='!') {
                count++;
                i=i+2;
            }
        }

        Sentence[] sentence = new Sentence[count];
        count=0;

        for (int i=1, b=0; i<content.length(); i++) {
            if (content.charAt(i)=='.' && content.charAt(i+1)=='.' && content.charAt(i+2)=='.') {
                sentence[count] = SentenceParser.createSentenceParser(content.substring(b, i+3));
                paragraph.add(sentence[count]);
                count++;
                i=i+4;
                b=i;
            }
            if (content.charAt(i)=='?' || content.charAt(i)=='.' && content.charAt(i-1)!='.' || content.charAt(i)=='!') {
                sentence[count] = SentenceParser.createSentenceParser(content.substring(b, i+1));
                paragraph.add(sentence[count]);
                count++;
                i=i+2;
                b=i;
            }
        }

        return paragraph;
    }
}
