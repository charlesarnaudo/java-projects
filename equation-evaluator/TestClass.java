import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Charles Arnaudo
 * @author Bryce Reinhard
 * @author Patrick Dunbar
 */


public class TestClass {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("infixSingleDigit.txt"));

        while (fileScanner.hasNext()) {
            String s = fileScanner.next();
            System.out.print(s + " = ");
            String postfix = (convertToPostfix(s));
            System.out.print(postfix + " = ");
            System.out.println(evaluatePostfix(postfix));
        }
    }

    /**
     * Implements algorithm from Data Structures and Abstraction with Java (p. 165)
     * to convert parameter string s to a postfix expression.
     *
     * @param s
     * @return s into postfix expression
     */
    private static String convertToPostfix(String s) {
        VectorStack<Character> operatorStack = new VectorStack();
        StringBuilder postfix = new StringBuilder("");
        char nextChar;

        for (int i = 0; i < s.length(); i++) {
            nextChar = s.charAt(i);

            switch (nextChar) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    postfix.append(nextChar);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty() && lowerPrecedence(nextChar, operatorStack.peek())) {
                        postfix.append(operatorStack.pop());
                    }
                    operatorStack.push(nextChar);
                    break;
                case '(':
                    operatorStack.push(nextChar);
                    break;
                case ')':
                    char topOperator = operatorStack.pop();
                    while (!(topOperator == 40) && !operatorStack.isEmpty()) {
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        while (!operatorStack.isEmpty()) {
            char topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }
        return postfix.toString();
    }

    /**
     * Implements algorithm from Data Structures and Abstraction with Java (p. 170)
     * to evaluate a postfix expression.
     *
     * @param postfix
     * @return value of postfix expression
     */
    private static int evaluatePostfix(String postfix) {
        VectorStack<Integer> valueStack = new VectorStack();
        int result = 0;
        for (int i = 0; i < postfix.length(); i++) {
            char nextChar = postfix.charAt(i);
            switch (nextChar) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    //System.out.println(Character.getNumericValue(nextChar));
                    valueStack.push(Character.getNumericValue(nextChar));
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    if (getOperator(nextChar) == 0) {
                        result = operandOne + operandTwo;
                    } else if (getOperator(nextChar) == 1) {
                        result = operandOne - operandTwo;
                    } else if (getOperator(nextChar) == 2) {
                        result = operandOne / operandTwo;
                    } else if (getOperator(nextChar) == 3) {
                        result = operandOne * operandTwo;
                    }
                    //System.out.print(result);
                    valueStack.push(result);
                    break;
                default:
                    break;
            }
        }
        return valueStack.peek();
    }

    /**
     * Determines what the passed operator is, and passes a flag integer value
     * to determine what operation to do.
     *
     * @param nextChar
     * @return flag value for determining operator
     */
    private static int getOperator(char nextChar) {
        if (nextChar == '+') {
            return 0;
        } else if (nextChar == '-') {
            return 1;
        } else if (nextChar == '/') {
            return 2;
        } else if (nextChar == '*') {
            return 3;
        } else {
            return -1;
        }
    }


    //Utility methods

    /**
     * Determines if the param nextChar is of lower precedence compared to peekChar.
     * Adapted from http://stackoverflow.com/questions/26699089/infix-to-postfix-using-stacks-java
     *
     *
     * @param nextChar
     * @param peekChar
     * @return boolean value determining if lower precedence
     */
    private static boolean lowerPrecedence(char nextChar, char peekChar) {
        switch (nextChar) {
            case '+':
                return !(43 == peekChar || 40 == peekChar);
            case '-':
                return !(45 == peekChar || 40 == peekChar);

            case '*':
                return !(47 == peekChar || 40 == peekChar);
            case '/':
                return !(42 == peekChar || 40 == peekChar);

            case '(':
                return false;

            default:
                return false;
        }
    }
}

