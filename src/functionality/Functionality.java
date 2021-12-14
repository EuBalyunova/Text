package functionality;

import java.util.ArrayList;
import java.util.List;

import composite.*;

public class Functionality {

    public static Text sortParagraph(Text text) {

        int[] quantity = new int[text.text.size()];
        TextComponent[] paragraph = new TextComponent[text.text.size()];
        Paragraph[] paragraphs = new Paragraph[text.text.size()];

        for (int i=0; i<text.text.size(); i++) {
            paragraph[i] = text.text.get(i);
            paragraphs[i] = (Paragraph) paragraph[i];
            quantity[i] = paragraphs[i].paragraph.size();
        }

        for (int i=0; i<text.text.size(); i++) {
            for (int j=text.text.size()-1; j>i; j--) {
                if (quantity[j-1]>quantity[j]) {
                    int temp = quantity[j-1];
                    quantity[j-1] = quantity[j];
                    quantity[j] = temp;
                    Paragraph tempParagraph = paragraphs[j-1];
                    paragraphs[j-1] = paragraphs[j];
                    paragraphs[j] = tempParagraph;
                }
            }
        }

        Text newText = new Text();

        for (int i=0; i<text.text.size(); i++) {
            newText.add(paragraphs[i]);
        }

        return newText;
    }


    public static Sentence sentenceWithLongestWord(Text text) {

        TextComponent[] paragraph = new TextComponent[text.text.size()];
        Paragraph[] paragraphs = new Paragraph[text.text.size()];

        for (int i=0; i<text.text.size(); i++) {
            paragraph[i] = text.text.get(i);
            paragraphs[i] = (Paragraph) paragraph[i];
        }

        Sentence s = null;
        int max=0;

        for (int i=0; i<text.text.size(); i++) {
            TextComponent[] sentence = new TextComponent[paragraphs[i].paragraph.size()];
            Sentence[] sentences = new Sentence[paragraphs[i].paragraph.size()];
            for (int j=0; j<paragraphs[i].paragraph.size(); j++) {
                sentence[j] = paragraphs[i].paragraph.get(j);
                sentences[j] = (Sentence) sentence[j];
                for (int g=0; g<sentences[j].sentence.size(); g++) {
                    if (sentences[j].sentence.get(g).getClass() == Word.class) {
                        TextComponent w = sentences[j].sentence.get(g);
                        Word word = (Word) w;
                        if (word.word.length() > max) {
                            max = word.word.length();
                            s = sentences[j];
                        }
                    }
                }
            }
        }

        return s;
    }


    public static Text deleteSentences(Text text, int number) {

        TextComponent[] paragraph = new TextComponent[text.text.size()];
        Paragraph[] paragraphs = new Paragraph[text.text.size()];

        for (int i=0; i<text.text.size(); i++) {
            paragraph[i] = text.text.get(i);
            paragraphs[i] = (Paragraph) paragraph[i];
        }

        for (int i=0; i<text.text.size(); i++) {
            TextComponent[] sentence = new TextComponent[paragraphs[i].paragraph.size()];
            Sentence[] sentences = new Sentence[paragraphs[i].paragraph.size()];
            for (int j=0, count; j<paragraphs[i].paragraph.size(); j++) {
                count=0;
                sentence[j] = paragraphs[i].paragraph.get(j);
                sentences[j] = (Sentence) sentence[j];
                for (int g=0; g<sentences[j].sentence.size(); g++) {
                    if (sentences[j].sentence.get(g).getClass() == Word.class) {
                        count++;
                    }
                }
                if (count < number) {
                    paragraphs[i].paragraph.remove(j);
                    j--;
                }
            }
        }

        Text newText = new Text();

        for (int i=0; i<text.text.size(); i++) {
            newText.add(paragraphs[i]);
        }

        return newText;
    }


    public static String searchIdenticalWords(Text text) {

        List<String> words1 = new ArrayList<String>(), words2 = new ArrayList<String>();

        TextComponent[] paragraph = new TextComponent[text.text.size()];
        Paragraph[] paragraphs = new Paragraph[text.text.size()];

        for (int i=0; i<text.text.size(); i++) {
            paragraph[i] = text.text.get(i);
            paragraphs[i] = (Paragraph) paragraph[i];
        }

        for (int i=0; i<text.text.size(); i++) {
            TextComponent[] sentence = new TextComponent[paragraphs[i].paragraph.size()];
            Sentence[] sentences = new Sentence[paragraphs[i].paragraph.size()];
            for (int j=0; j<paragraphs[i].paragraph.size(); j++) {
                sentence[j] = paragraphs[i].paragraph.get(j);
                sentences[j] = (Sentence) sentence[j];
                for (int g=0; g<sentences[j].sentence.size(); g++) {
                    if (sentences[j].sentence.get(g).getClass() == Word.class) {
                        TextComponent w = sentences[j].sentence.get(g);
                        Word word = (Word) w;
                        words1.add(word.word.toLowerCase());
                        words2.add(word.word.toLowerCase());
                    }
                }
            }
        }

        for (int i=0; i<words2.size(); i++) {
            if (i<words2.size()-1) {
                for (int j=i+1; j<words2.size(); j++) {
                    if (words2.get(i).equals(words2.get(j))) {
                        words2.remove(j);
                    }
                }
            }
        }

        int[] w11 = new int[words2.size()];
        for (int i=0; i<w11.length; i++) {
            w11[i]=0;
        }

        for (int i=0; i<words2.size(); i++) {
            for (int j=0; j<words1.size(); j++) {
                if (words2.get(i).equals(words1.get(j))) {
                    w11[i]++;
                }
            }
        }

        String str = "";

        for (int i=0; i<w11.length; i++) {
            if (w11[i]>1) {
                str = str + words2.get(i) + " - " + w11[i] + ";\n";
            }
        }

        return str;
    }
}
