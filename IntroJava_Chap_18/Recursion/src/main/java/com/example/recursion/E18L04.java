//Recursive helper method
package com.example.recursion;

public class E18L04 {
    public static void main(String[] args) {
        System.out.println("Is moon a palindrome? " + isPalindrome("moon"));
        System.out.println("Is moon a palindrome? " + isPalindrome("a"));
    }
    public static boolean isPalindrome(String s){
       return isPalindrome(s, 0, s.length()-1);
    }

//  instead of making new strings, use index to reuse the same string
    public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        else if (s.charAt(start) != s.charAt(end)) return false;
        else return isPalindrome(s,start+1, end-1);
    }
}
