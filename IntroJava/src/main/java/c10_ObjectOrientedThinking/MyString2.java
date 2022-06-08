package c10_ObjectOrientedThinking;

/* (Implement the String class) The String class is provided in the Java library.
Provide your own implementation for the following methods (name the new class MyString2):
public MyString2(String s);
public int compare(String s);
public MyString2 substring(int begin);
public MyString2 toUpperCase();
public char[] toChars();
public static MyString2 valueOf(boolean b);
*/

public class MyString2{
    //Data field
    private final String s;
    

    //Constructor
    public MyString2(String s){
        this.s = s;
    }

    //Methods
    public String getString(){
        return s;
    }
    public int compare(String s) {
        return s.compareTo(this.getString());
    }


    public MyString2 substring(int begin){
        return new MyString2 (s.substring(begin));
    }

    public MyString2 toUpperCase(){
        return new MyString2(s.toUpperCase());
    }

    public char[] toChars(){
        return s.toCharArray();
    }

    public static MyString2 valueOf(boolean b){
        return new MyString2(b + "");
    }
}
