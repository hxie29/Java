package c11_InheritancePolymorphism;

import java.util.ArrayList;

/*
(ArrayList of Character) Write a method that returns an array list of Character
from a string using the following header:
public static ArrayList<Character> toCharacterArray(String s)
For example, toCharacterArray("abc") returns an array list that contains
characters 'a', 'b', and 'c'.
*/
public class E1118 {
    public static void main(String[]args){
        String s = "asdj1o30g;12 asluidh";
        System.out.println(toCharacterAraay(s));
    }

    public static ArrayList<Character> toCharacterAraay(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        return list;
    }
}
