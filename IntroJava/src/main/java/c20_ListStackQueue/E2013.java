/*(Postfix notation) Postfix notation is a way of writing expressions without
using parentheses. For example, the expression (1 + 2) * 3 would be
written as 1 2 + 3 *. A postfix expression is evaluated using a stack. Scan
a postfix expression from left to right. A variable or constant is pushed into
the stack. When an operator is encountered, apply the operator with the top
two operands in the stack and replace the two operands with the result. The
following diagram shows how to evaluate 1 2 + 3 *.*/
package c20_ListStackQueue;

import java.util.Stack;

public class E2013 {
    public static void main(String[] args) {
       /* if (args.length != 1) {
            System.out.println("Usage: java E2013.java \"expression\"");
            System.exit(1);
        }
*/
        try {
            System.out.println(evaluate("1 2 + 3 *"));
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
                if (token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*' || token.charAt(0) == '/') {
                    // Process all +, -, *, / in the top of the stack
                    operatorStack.push(token.charAt(0));
                    processAnOperator(operandStack, operatorStack);
                } else
                    operandStack.push(Integer.parseInt(token));
            }
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
