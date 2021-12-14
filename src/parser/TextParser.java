package parser;

import composite.Paragraph;
import composite.Text;

public class TextParser {
    public static Text parsingText(String content) {
        Text text = new Text();

        int count=0;
        for (int i=0; i<content.length();) {
            if (content.substring(i).indexOf("    ")!=-1 && content.substring(i).indexOf("\r")!=-1) {
                if(content.substring(i).indexOf("    ") < content.substring(i).indexOf("\r")) {
                    count++;
                    i = i+content.substring(i).indexOf("    ")+4;
                } else {
                    count++;
                    i = i+content.substring(i).indexOf("\r")+1;
                }
            }
            if (content.substring(i).indexOf("    ")!=-1 && content.substring(i).indexOf("\r")==-1) {
                count++;
                i = i+content.substring(i).indexOf("    ")+4;
            }
            if (content.substring(i).indexOf("    ")==-1 && content.substring(i).indexOf("\r")!=-1) {
                count++;
                i = i+content.substring(i).indexOf("\r")+1;
            }
            if (content.substring(i).indexOf("    ")==-1 && content.substring(i).indexOf("\r")==-1) {
                count++;
                break;
            }
        }

        Paragraph[] paragraph = new Paragraph[count];
        count=0;

        for (int i=0; i<content.length();) {
            if (content.substring(i).indexOf("    ")!=-1 && content.substring(i).indexOf("\r")!=-1) {
                if(content.substring(i).indexOf("    ") < content.substring(i).indexOf("\r")) {
                    paragraph[count] = ParagraphParser.parsingParagraph(content.substring(i, i+content.substring(i).indexOf("    "))+" ");
                    text.add(paragraph[count]);
                    count++;
                    i = i+content.substring(i).indexOf("    ")+4;
                } else {
                    paragraph[count] = ParagraphParser.parsingParagraph(content.substring(i, i+content.substring(i).indexOf("\r"))+" ");
                    text.add(paragraph[count]);
                    count++;
                    i = i+content.substring(i).indexOf("\r")+1;
                }
            }
            if (content.substring(i).indexOf("    ")!=-1 && content.substring(i).indexOf("\r")==-1) {
                paragraph[count] = ParagraphParser.parsingParagraph(content.substring(i, i+content.substring(i).indexOf("    "))+" ");
                text.add(paragraph[count]);
                count++;
                i = i+content.substring(i).indexOf("    ")+4;
            }
            if (content.substring(i).indexOf("    ")==-1 && content.substring(i).indexOf("\r")!=-1) {
                paragraph[count] = ParagraphParser.parsingParagraph(content.substring(i, i+content.substring(i).indexOf("\r"))+" ");
                text.add(paragraph[count]);
                count++;
                i = i+content.substring(i).indexOf("\r")+1;
            }
            if (content.substring(i).indexOf("    ")==-1 && content.substring(i).indexOf("\r")==-1) {
                paragraph[count] = ParagraphParser.parsingParagraph(content.substring(i)+" ");
                text.add(paragraph[count]);
                count++;
                break;
            }
        }

        return text;
    }
}
