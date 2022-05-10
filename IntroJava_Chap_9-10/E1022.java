import java.math.BigInteger;

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
public class E1022 {
    public static void main(String[] args){
        
    }
}

class MyString1{
    //Data field
    private String s = "";
    private char[] chars;

    //Constructor
    public MyString1(char[] chars){
        this.chars = chars;
        for (int i = 0 ; i < chars.length; i++) {
            s += chars[i];
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
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chars[begin + i];
        }
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
