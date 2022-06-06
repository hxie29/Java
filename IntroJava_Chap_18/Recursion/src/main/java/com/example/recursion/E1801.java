/* (Identifying anagrams) Two words are anagrams of each other if they contain the
same letters that are arranged in different orders. Write a recursive method that
can identify if two given words are anagrams of each other. */
package com.example.recursion;

public class E1801 {
    public static void main(String[] args) {
        String s1 = "cares";
        String s2 = "races";
        System.out.println(s1 + " and " + s2 + " is anagram? " + isAnagram(s1,s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        else if (s1.length() == 0) return true;
        else {
            int index = s2.indexOf(s1.charAt(0));
           if (index < 0)
               return false;
           else {
               StringBuilder str = new StringBuilder(s2);
               str.deleteCharAt(index);
               return isAnagram(s1.substring(1),str.toString());
           }
        }
    }

}
