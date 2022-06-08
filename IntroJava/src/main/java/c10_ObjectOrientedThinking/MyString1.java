package c10_ObjectOrientedThinking;

/* (Implement the String class) The String class is provided in the Java library.
Provide your own implementation for the following methods (name the new class MyString1):
public MyString1(char[] chars);
public char charAt(int index);
public int length();
public MyString1 substring(int begin, int end);
public MyString1 toLowerCase();
public boolean equals(MyString1 s);
public static MyString1 valueOf(int i);
*/

public class MyString1{
    private final char[] chars;

    //Constructor
    public MyString1(char[] chars){
        this.chars = chars;
        for (char aChar : chars) {
            //Data field
            String s = "";
        }
    }

    //Methods
    public char charAt(int index) {
        return chars[index];
    }

    public int length(){
        return chars.length;
    }

    public MyString1 substring(int begin, int end){
        char[] temp = new char[end - begin];
        System.arraycopy(chars, begin, temp, 0, temp.length);
        return new MyString1(temp);
    }

    public MyString1 toLowerCase(){
        char[] temp = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            temp[i] = Character.toLowerCase(chars[i]);
        }
        return new MyString1(temp);
    }

    public boolean equals(MyString1 s) {
        if (s.length() != this.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != this.charAt(i)) return false;
        }
        return true;
    }

    public static MyString1 valueOf(int i){
        char[] temp = {(char)i};
        return new MyString1(temp);
    }
}
