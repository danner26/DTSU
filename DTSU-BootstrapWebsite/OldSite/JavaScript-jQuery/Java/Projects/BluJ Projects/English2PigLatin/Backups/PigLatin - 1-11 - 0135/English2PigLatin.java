import java.util.ArrayList;
import TerminalIO.KeyboardReader;

/**
 * This is a program that will turn any normal English word into a Pig Latin word and output the sentance to the console.
 * 
 * @DTSU Development Team - Daniel Anner
 * @v.1.0.0
 */
public class English2PigLatin
{
    public static void main(String args[]) {
        KeyboardReader reader = new KeyboardReader();
        String input = reader.readLine("\fWhat should be converted to pig latin:      ");
        String pigLatin = "";
        while (input.length() > 0) {
            int pos = 0;
            String word = "";
            String tempWord = "";
            String punctuation = "";
            for (int i = 0; !tempWord.contains(" "); i++) {
                //if (input.substring(i, i+1).equals(".") || input.substring(i, i+1).equals(",") || input.substring(i, i+1).equals("!") || input.substring(i, i+1).equals("?") || input.substring(i, i+1).equals(":") || input.substring(i, i+1).equals(";")) {
                //    punctuation = input.substring(i, i+1);
                //    break;
                //}
                if (i > input.length()) {
                    tempWord = tempWord + " ";
                    break;
                }
                tempWord = input.substring(0, i);
                pos = i;
            }
            word = tempWord.substring(0, tempWord.length() - 1);
            input = input.substring(pos);
            if (word.length() == 1) /*Cannot convert to pig latin*/ {
                pigLatin = (pigLatin +" " + word);
            } else /*can convert to pig latin*/{
                switch (tester.conOrVowel(word.substring(0,1))) {
                    case 1: //vowel - add way
                        word = word + "way";
                        pigLatin = pigLatin + " " + word;
                        break;
                    case 2: //consonant - test if double or vowel next
                        switch (tester.conOrVowel(word.substring(1,2))) {
                            case 1: // vowel - put first letter at end and add "ay"
                                String tWord = word;
                                word = tWord.substring(1);
                                word = word + tWord.substring(0,1);
                                word = word +"ay";
                                pigLatin = pigLatin + " " + word;
                                break;
                            case 2: // consonant - put both letters at end and add "ay"
                                String tWord1 = word;
                                word = word.substring(2);
                                word = word + tWord1.substring(0,2);
                                word = word + "ay";
                                pigLatin = pigLatin + " " + word;
                                break;
                        }
                        break;
                }
            }
            punctuation = "";
        }
        System.out.println("Here is your word in Pig Latin:   " + pigLatin);
    }
}
/*
 * First Letter : tester.conOrVowel(word.substring(0,1))
 * Second Letter : tester.conOrVowel(word.substring(1,2))
 */