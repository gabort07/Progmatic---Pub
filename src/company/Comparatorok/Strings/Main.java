package company.Comparatorok.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        String string1 = "naj4629 -i27v 9 ,3ndh12- 9df";
        String string2 = "naj4629 -i2fdc 5gj,33d214- 9";
        String text = "abcd";
//        countCharacters(string1);
//        countCharRepeat(string1);
//        countSameChars(string1, string2);
        printUnicodeSequence(128);
        System.out.println((char) 97);
//        decide('m');
//        ceasarDecode(text, 2, 'E');


    }

    public static void countCharacters(String string) {
        int number = 0;
        int letter = 0;
        int space = 0;
        int special = 0;

        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                number++;
            } else if (Character.isAlphabetic(c)) {
                letter++;
            } else if (c == ' ') {
                space++;
            } else {
                special++;
            }
        }
        System.out.println("Szomok: " + number);
        System.out.println("Betűk: " + letter);
        System.out.println("Szóköz" + space);
        System.out.println("Egyéb karakter: " + special);
    }

    public static void countCharRepeat(String string) {
        HashMap<Character, Integer> list = new HashMap<>();
        for (char c : string.toCharArray()) {
            if (list.containsKey(c)) {
                list.put(c, list.get(c) + 1);
            } else {
                list.put(c, 1);
            }
        }
        System.out.println(list);
    }

    public static void countSameChars(String string1, String string2) {
        int nr = 0;
        int length = Math.min(string1.length(), string2.length());
//        System.out.println(length);
        for (int i = 0; i < length; i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                nr++;
            }
        }
        System.out.println(nr);
    }

    public static void printUnicodeSequence(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(Arrays.toString(Character.toChars(i)) + " ");
        }
        System.out.println();
    }

    public static void decide(char c) {
        System.out.println(Character.isAlphabetic((int) c) ? "Alphabetic" : "Numeric");
    }

    public static void ceasarDecode(String text, int key, char toDo) {
        StringBuilder newText = new StringBuilder("");
        switch (toDo) {
            case 'E':
                for (char c : text.toCharArray()) {
                    newText.append(Character.toChars((int)c+key));
                }
                break;
            case 'D':
                for (char c : text.toCharArray()) {
                    newText.append(Character.toChars((int) c - key));
                }
                break;
        }
        System.out.println(newText.toString());
    }

}
