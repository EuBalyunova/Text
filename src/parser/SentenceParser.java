package parser;

import composite.Sentence;
import composite.Word;
import composite.Lexeme;
import composite.Symbol;

public class SentenceParser {
    public static Sentence createSentenceParser(String content) {
        Sentence sentence = new Sentence();

        int countWord=0, countLexeme=0, countSymbol=0;

        for (int i=0, b=0; i<content.length(); i++) {
            if (content.charAt(i)==' ') {
                if (checkLexeme(content.substring(b, i)) == true) {
                    countLexeme++;
                } else {
                    countWord++;
                }
                b=i;
            }
            if (content.charAt(i)==',' || content.charAt(i)=='?' || content.charAt(i)=='.' && content.charAt(i-1)!='.' || content.charAt(i)=='!') {
                if (checkLexeme(content.substring(b, i)) == true) {
                    countLexeme++;
                } else {
                    countWord++;
                }
                countSymbol++;
                i++;
                b=i;
            }
            if (i<content.length()-1) {
                if (content.charAt(i)=='-' && content.charAt(i+1)==' ') {
                    countSymbol++;
                    i++;
                }
            }
            if (i<content.length()-2) {
                if (content.charAt(i)=='.' && content.charAt(i+1)=='.' && content.charAt(i+2)=='.') {
                    if (checkLexeme(content.substring(b, i)) == true) {
                        countLexeme++;
                    } else {
                        countWord++;
                    }
                    countSymbol++;
                    i=i+3;
                    b=i;
                }
            }
        }

        Word[] word = new Word[countWord];
        Lexeme[] lexeme = new Lexeme[countLexeme];
        Symbol[] symbol = new Symbol[countSymbol];
        countWord=0; countLexeme=0; countSymbol=0;

        for (int i=0, b=0; i<content.length(); i++) {
            if (content.charAt(i)==' ') {
                if (checkLexeme(content.substring(b, i)) == true) {
                    if (content.charAt(b)==' ') {
                        lexeme[countLexeme] = new Lexeme(content.substring(b+1, i));
                    } else {
                        lexeme[countLexeme] = new Lexeme(content.substring(b, i));
                    }
                    sentence.add(lexeme[countLexeme]);
                    countLexeme++;
                } else {
                    if (content.charAt(b)==' ') {
                        word[countWord] = new Word(content.substring(b+1, i));
                    } else {
                        word[countWord] = new Word(content.substring(b, i));
                    }
                    sentence.add(word[countWord]);
                    countWord++;
                }
                b=i;
            }
            if (content.charAt(i)==',' || content.charAt(i)=='?' || content.charAt(i)=='.' && content.charAt(i-1)!='.' || content.charAt(i)=='!') {
                if (checkLexeme(content.substring(b, i)) == true) {
                    if (content.charAt(b)==' ') {
                        lexeme[countLexeme] = new Lexeme(content.substring(b+1, i));
                    } else {
                        lexeme[countLexeme] = new Lexeme(content.substring(b, i));
                    }
                    sentence.add(lexeme[countLexeme]);
                    countLexeme++;
                } else {
                    if (content.charAt(b)==' ') {
                        word[countWord] = new Word(content.substring(b+1, i));
                    } else {
                        word[countWord] = new Word(content.substring(b, i));
                    }
                    sentence.add(word[countWord]);
                    countWord++;
                }
                symbol[countSymbol] = new Symbol(content.substring(i, i+1));
                sentence.add(symbol[countSymbol]);
                countSymbol++;
                i++;
                b=i;
            }
            if (i<content.length()-1) {
                if (content.charAt(i)=='-' && content.charAt(i+1)==' ') {
                    symbol[countSymbol] = new Symbol(content.substring(i, i+1));
                    sentence.add(symbol[countSymbol]);
                    countSymbol++;
                    i++;
                    b=i;
                }
            }
            if (i<content.length()-2) {
                if (content.charAt(i)=='.' && content.charAt(i+1)=='.' && content.charAt(i+2)=='.') {
                    if (checkLexeme(content.substring(b, i)) == true) {
                        if (content.charAt(b)==' ') {
                            lexeme[countLexeme] = new Lexeme(content.substring(b+1, i));
                        } else {
                            lexeme[countLexeme] = new Lexeme(content.substring(b, i));
                        }
                        sentence.add(lexeme[countLexeme]);
                        countLexeme++;
                    } else {
                        if (content.charAt(b)==' ') {
                            word[countWord] = new Word(content.substring(b+1, i));
                        } else {
                            word[countWord] = new Word(content.substring(b, i));
                        }
                        sentence.add(word[countWord]);
                        countWord++;
                    }
                    symbol[countSymbol] = new Symbol(content.substring(i, i+3));
                    sentence.add(symbol[countSymbol]);
                    countSymbol++;
                    i=i+2;
                    b=i;
                }
            }
        }

        return sentence;
    }

    public static boolean checkLexeme(String str) {
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i)=='0' || str.charAt(i)=='1' || str.charAt(i)=='2' || str.charAt(i)=='3' || str.charAt(i)=='4' ||
                    str.charAt(i)=='5' || str.charAt(i)=='6' || str.charAt(i)=='7' || str.charAt(i)=='8' || str.charAt(i)=='9') {
                return true;
            }
            if (str.charAt(i)=='(' || str.charAt(i)==')' || str.charAt(i)=='<' || str.charAt(i)=='>' ||
                    str.charAt(i)=='~' || str.charAt(i)=='&' || str.charAt(i)=='^' || str.charAt(i)=='|' || str.charAt(i)=='\'') {
                return true;
            }
        }
        return false;
    }
}
