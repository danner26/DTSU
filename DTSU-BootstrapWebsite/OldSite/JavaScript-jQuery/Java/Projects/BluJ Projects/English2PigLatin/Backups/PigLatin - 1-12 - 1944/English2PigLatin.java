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
            boolean conPunc = false;
            boolean end = false;
            for (int i = 1; !tempWord.contains(" "); i++) {
                if (i-1 > input.length()) {
                    tempWord = tempWord + " ";
                    end = true;
                    System.out.println("I AM AT THE END");
                    
                    break;
                }
                System.out.println(i);
                System.out.println("." +input);
                if (input.substring(i-1, i).equals(".") || input.substring(i-1, i).equals(",") || input.substring(i-1, i).equals("!") || input.substring(i-1, i).equals("?") || input.substring(i-1, i).equals(":") || input.substring(i-1, i).equals(";")) {
                    /* problem start */ if (i > input.length()) {
                        System.out.println(input.substring(0));
                        end = true;
                        punctuation = input.substring(i-1, i);
                        tempWord = tempWord + " ";
                        conPunc = true;
                    } /* problem end */ else {
                        punctuation = input.substring(i-1, i);
                        tempWord = tempWord + " ";
                        conPunc = true;
                    }
                    break;
                } else {
                    tempWord = input.substring(0, i);
                    pos = i;
                }
                //tempWord = input.substring(0, i);
                //pos = i;
            }
            if (end) {
                if (conPunc) {
                    pigLatin = pigLatin + punctuation;
                } else {
                    if (word.length() == 1) /*Cannot convert to pig latin*/ {   
                        pigLatin = (pigLatin + " " + word + punctuation);
                    } else /*can convert to pig latin*/{
                        if (conPunc) {
                            word = tempWord.substring(0, tempWord.length() - 1);
                            
                            input = input.substring(pos+2);
                        } else {
                            word = tempWord.substring(0, tempWord.length() - 1);
                            input = input.substring(pos);
                        }
                        System.out.println("Made it: ." + word);
                        switch (tester.conOrVowel(word.substring(0,1))) {
                            case 1: //vowel - add way
                                word = word + "way";
                                pigLatin = pigLatin + " " + word + punctuation;
                                pigLatin = pigLatin + punctuation;
                                break;
                            case 2: //consonant - test if double or vowel next
                                switch (tester.conOrVowel(word.substring(1,2))) {
                                    case 1: // vowel - put first letter at end and add "ay"
                                        String tWord = word;
                                        word = tWord.substring(1);
                                        word = word + tWord.substring(0,1);
                                        word = word +"ay";
                                        pigLatin = pigLatin + " " + word + punctuation;
                                        break;
                                    case 2: // consonant - put both letters at end and add "ay"
                                        String tWord1 = word;
                                        word = word.substring(2);
                                        word = word + tWord1.substring(0,2);
                                        word = word + "ay";
                                        pigLatin = pigLatin + " " + word + punctuation;
                                        break;
                                }
                                break;
                        }
                    }
                        System.out.println("Word."+ word);
                }
                break;
            } else {
                if (conPunc) {
                    word = tempWord.substring(0, tempWord.length() - 1);
                    
                    input = input.substring(pos+2);
                } else {
                    word = tempWord.substring(0, tempWord.length() - 1);
                    input = input.substring(pos);
                }
                System.out.println("Word: ." + word);
                
                if (word.length() == 1) /*Cannot convert to pig latin*/ {   
                    pigLatin = (pigLatin + " " + word + punctuation);
                } else /*can convert to pig latin*/{
                    System.out.println("Made it: ." + word);
                    switch (tester.conOrVowel(word.substring(0,1))) {
                        case 1: //vowel - add way
                            word = word + "way";
                            pigLatin = pigLatin + " " + word + punctuation;
                            pigLatin = pigLatin + punctuation;
                            break;
                        case 2: //consonant - test if double or vowel next
                            switch (tester.conOrVowel(word.substring(1,2))) {
                                case 1: // vowel - put first letter at end and add "ay"
                                    String tWord = word;
                                    word = tWord.substring(1);
                                    word = word + tWord.substring(0,1);
                                    word = word +"ay";
                                    pigLatin = pigLatin + " " + word + punctuation;
                                    break;
                                case 2: // consonant - put both letters at end and add "ay"
                                    String tWord1 = word;
                                    word = word.substring(2);
                                    word = word + tWord1.substring(0,2);
                                    word = word + "ay";
                                    pigLatin = pigLatin + " " + word + punctuation;
                                    break;
                            }
                            break;
                    }
                }
                System.out.println("PigLatin: ." + pigLatin);
            }          
            
            word = "";
            tempWord = "";
            punctuation = "";
            pos = 0;
            conPunc = false;
        }
        System.out.println("Here is your word in Pig Latin:   " + pigLatin);
    }
}
/*
 * First Letter : tester.conOrVowel(word.substring(0,1))
 * Second Letter : tester.conOrVowel(word.substring(1,2))
 * 
 * if (conPunc) {
                    word = tempWord.substring(0, tempWord.length() - 1);
                    
                    input = input.substring(pos+2);
                } else {
                    word = tempWord.substring(0, tempWord.length() - 1);
                    input = input.substring(pos);
                }
                System.out.println("Word: ." + word);
                
                if (word.length() == 1) //Cannot convert to pig latin
                {   
                pigLatin = (pigLatin + " " + word + punctuation);
                } else //can convert to pig latin
                {
                    System.out.println("Made it: ." + word);
                    switch (tester.conOrVowel(word.substring(0,1))) {
                        case 1: //vowel - add way
                            word = word + "way";
                            pigLatin = pigLatin + " " + word + punctuation;
                            pigLatin = pigLatin + punctuation;
                            break;
                        case 2: //consonant - test if double or vowel next
                            switch (tester.conOrVowel(word.substring(1,2))) {
                                case 1: // vowel - put first letter at end and add "ay"
                                    String tWord = word;
                                    word = tWord.substring(1);
                                    word = word + tWord.substring(0,1);
                                    word = word +"ay";
                                    pigLatin = pigLatin + " " + word + punctuation;
                                    break;
                                case 2: // consonant - put both letters at end and add "ay"
                                    String tWord1 = word;
                                    word = word.substring(2);
                                    word = word + tWord1.substring(0,2);
                                    word = word + "ay";
                                    pigLatin = pigLatin + " " + word + punctuation;
                                    break;
                            }
                            break;
                    }
                }
 */