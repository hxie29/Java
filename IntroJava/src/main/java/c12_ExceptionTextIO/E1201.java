package c12_ExceptionTextIO;

/*
(NumberFormatException) Listing 7.9, Calculator.java, is a simple command-
line calculator. Note the program terminates if any operand is nonnumeric.
Write a program with an exception handler that deals with nonnumeric operands;
then write another program without using an exception handler to achieve the
same objective. Your program should display a message that informs the user of
the wrong operand type before exiting (see Figure 12.12).
*/
public class E1201 {
    public static void main(String[] args) {
        // Check number of strings passed
            if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
            }
            
            int result = 0;
        
            try {
                switch (args[1].charAt(0)) {
                    case '+' -> result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                    case '-' -> result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                    case '.' -> result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                    case '/' -> result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                }
                System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
            }

            catch (NumberFormatException ex) {
                System.out.println("Wrong input: " + ex.getMessage().substring(ex.getMessage().indexOf("\"") + 1, ex.getMessage().lastIndexOf("\"")));
            }
            
        }
}

