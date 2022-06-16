// Evaluate expressions using stack
package c20_ListStackQueue;

import java.util.Stack;

public class E20L12 {
    public static void main(String[] args) {
       /* if (args.length != 1) {
            System.out.println("Usage: java E20L12 \"expression\"");
            System.exit(1);
        }
*/
        try {
            System.out.println(evaluate("(1 + 3 * 3 -2) * (12 / 6 * 5)"));
        }
        catch (Exception ex) {
            System.out.println("Wrong expression");
        }
    }

    public static int evaluate(String s) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        s = insertBlanks(s);
        String[] tokens = s.split(" ");
        for (String token: tokens) {
            if (token.length() !=0) {
                if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                    // Process all +, -, *, / in the top of the stack
                    while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.push(token.charAt(0));
                } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                    // Process all *, / on top of the stack
                    while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.push(token.charAt(0));
                }
                // trim() Returns a string whose value is this string, with all leading and trailing space removed, where space is defined as any character whose codepoint is less than or equal to 'U+0020' (the space character).
                else if (token.trim().charAt(0) == '(')
                    operatorStack.push('(');
                else if (token.trim().charAt(0) == ')') {
                    while (operatorStack.peek() != '(') {
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.pop(); // pop the '(' out of the stack
                } else
                    operandStack.push(Integer.parseInt(token));
            }
        }

        // scanning over, Phase 2, finish processing the remaining operators
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        //return the result
        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int n1 = operandStack.pop();
        int n2 = operandStack.pop();
        switch (op) {
            case '+' -> operandStack.push (n1 + n2);
            case '-' -> operandStack.push (n2 - n1);
            case '*' -> operandStack.push (n1 * n2);
            case '/' -> operandStack.push(n2 / n1);
        }
    }

    private static String insertBlanks(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))){
                result.append(" ");
                result.append(s.charAt(i));
                result.append(" ");
            }
            else
                result.append(s.charAt(i));
        }
        return result.toString();
    }
}
