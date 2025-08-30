package com.baginsky_3istyd_122.lab_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class PolishNotation {
	public static List<String> convertToPolishNotation(String[] expression) {
		
        List<String> result = new ArrayList<String>();
        if (expression == null || expression.length == 0) {
            return result;
        }

        Stack<String> opStack = new Stack<String>();

        // Iterate from right to left for Polish Notation
        for (int i = expression.length - 1; i >= 0; i--) {
            String token = expression[i];

            if (isNumber(token)) {
                result.add(token);
            } else if (token.equals("(")) { // Original ')' now acts as '('
                while (!opStack.isEmpty() && !opStack.peek().equals(")")) { // Pop until original '('
                    result.add(opStack.pop());
                }
                if (!opStack.isEmpty()) {
                    opStack.pop(); // Pop the original ')'
                }
            } else if (token.equals(")")) { // Original '(' now acts as ')'
                opStack.push(token);
            }  else { // Operator
                while (!opStack.isEmpty() && getPriority(opStack.peek()) > getPriority(token)) {
                    result.add(opStack.pop());
                }
                opStack.push(token);
            }
        }

        while (!opStack.isEmpty()) {
            result.add(opStack.pop());
        }

        Collections.reverse(result); // Reverse the final list for correct order
        return result;
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getPriority(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        } else if (op.equals("*") || op.equals("/")) {
            return 2;
        } else { // Parentheses have lower effective priority during stack operations
            return 0;
        }
    }

    public static Double evaluatePolishNotation(String[] tokens) {
        Stack<Double> stack = new Stack<>();
        
        // Iterate from right to left
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                // Pop operands (note the order for Polish Notation)
            	Double operand1 = stack.pop();
            	Double operand2 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2); // operand1 - operand2
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2); // operand1 / operand2
                        break;
                    case "^":
                        stack.push(Math.pow(operand1 , operand2)); // operand1 / operand2
                        break;
                }
            } else {
                // It's a number, push onto stack
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop(); // The final result
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")|| token.equals("^");
    }
}
