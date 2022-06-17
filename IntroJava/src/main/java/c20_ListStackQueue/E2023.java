/*(Evaluate expression) Modify Listing 20.12, EvaluateExpression class to make
all operators (+−*,/) have equal precedence. For example, 4 + 3 − 2 * 10
is 50. Write a test program that prompts the user to enter an expression and
displays the result.*/
package c20_ListStackQueue;

import java.util.Stack;

public class E2023 {
    public static void main(String[] args) {
        try {
            System.out.println(evaluate("4 + 3 -2 * 10"));
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
                    while (!operatorStack.isEmpty()) {
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.push(token.charAt(0));
                }
                else
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
