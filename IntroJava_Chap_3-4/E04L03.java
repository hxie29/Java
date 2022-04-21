public class E04L03 {
    public static void main(String[] args) {
        
        //print the ASCII code for single character
        System.out.println((int) '1');
        System.out.println((int) 'A');
        
        //print character from ASCII decimal code
        System.out.println((char)49);

         //print character from ASCII hexadecimal code
         System.out.println((char)0X7A);

        // double quotation
        System.out.println("He said \"Java is fun\". ");

        // generate a random lower case letter
        char i =(char)('a' + Math.random() * ('z' - 'a' +1));
        System.out.println(i);

    }
}
