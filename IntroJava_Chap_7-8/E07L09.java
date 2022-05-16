//Calculator
public class E07L09 {
   public static void main(String[] args) {
    // Check number of strings passed
        if (args.length != 3) {
        System.out.println("Usage: java Calculator operand1 operator operand2");
        System.exit(1);
        }
        
        int result = 0;
        
        switch (args[1].charAt(0)) {
        case '+': result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]); break;
        case '-': result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]); break;
        case '.': result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]); break;
        case '/': result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
        }
        
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    }
}
