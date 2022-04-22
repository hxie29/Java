import java.util.Scanner;

public class E04L445 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first string: ");
        String s1 = input.nextLine();
        System.out.println("Please enter the first string: ");
        String s2 = input.nextLine();

        boolean equal = s1.equals(s2);
        System.out.println("s1 equals to s2 is " + equal);

        boolean equal2 = s1.equalsIgnoreCase(s2);
        System.out.println("s1 equals to s2 (ignore cases) is " + equal2);

        int compare1 = s1.compareTo(s2);
        System.out.println("s1 compares to s2 is " + compare1);

        int compare2 = s1.compareToIgnoreCase(s2);
        System.out.println("s1 compares to s2 (ignore cases) is " + compare2);

        boolean aaa = s1.startsWith("AAA");
        System.out.println("Starts with AAA is " + aaa);
        
        boolean aaa2 = s1.endsWith("AAA");
        System.out.println("Ends with AAA is " + aaa2);

        int length = s1.length();
        System.out.println("The length of string 1 is " + length);

        char s1a1 = s1.charAt(0);
        System.out.println("S1 starts with " + s1a1);

        String s3 = s1 + s2;
        System.out.println(s3);

        String s101 = s1.substring(1);
        System.out.println(s101);
        String s102 = s1.substring(1,4);
        System.out.println(s102);

        String s3n = s1.toLowerCase();
        System.out.println(s3n);
        String s3n2 = s1.toUpperCase();
        System.out.println(s3n2);
        String s3n3 = s1.trim();
        System.out.println(s3n3);

        int x = s1.indexOf("e");
        System.out.println("The index of the first e in s1 is " + x);
        int y = s1.lastIndexOf("abc");
        System.out.println("The index of the last abc in s1 is " + y);

        input.close();

    }
}
