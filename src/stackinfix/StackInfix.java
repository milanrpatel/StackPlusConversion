/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackinfix;

import java.util.Stack;

/**
 *
 * @author MILAN PATEL
 */
public class StackInfix {

    /**
     * @param args the command line arguments
     */
    //infix to Postfix
    private static int getPriorityIndex(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infix2Postfix(String exp) {
        
        String result = new String("");     // init empty String 

        Stack<Character> stack = new Stack<>();     // init empty stack

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {     // if operand than add
                result += c;
            } // If ( than push
            else if (c == '(') {   
                stack.push(c);
            }
         
            else if (c == ')') {        //  If ) than  
                while (!stack.isEmpty() && stack.peek() != '(') {   //pop until (
                    result += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() != '(') {      //empty or ( than invailid
                    return "Invalid Expression";               
                } else {    //otherwise pop
                    stack.pop();
                }
            } else{ //op encountered
                while (!stack.isEmpty() && getPriorityIndex(c) <= getPriorityIndex(stack.peek())) { //check priority
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {  //pop until empty
            result += stack.pop();
        }

        return result;
    }

    //infix to prefix
    static String infix2Prefix(String exp) {
        String result = "";    //init with empty str
        Stack<Character> stack = new Stack<>();     //init with empty stack

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            if (Character.isDigit(c) || Character.isLetter(c)) {    //in operand than add
                result = (c) + result;
            } else if (isOperator(c)) { //if op
                while (!stack.isEmpty() && hasHighPrec(stack.peek(), c) && !hasOpening(stack.peek())) {     //check priority and not opening and not empty than add
                    result = stack.pop() + result;
                }

                stack.push(c);      //push lower
            } else if (hasClosing(c)) {
                stack.push(c);
            } else if (hasOpening(c)) {
                while (!stack.isEmpty() && !hasClosing(stack.peek())) {     //not empty and not closing
                    result = stack.pop() + result;      //add to string
                }
                stack.pop();    //pop
            }
        }

        while (!stack.isEmpty()) {  //add until not empty
            result = stack.pop() + result;
        }

        return result;
    }

    private static boolean hasOpening(char oper) {
        return (oper == '(' || oper == '{' || oper == '[');
    }

    private static boolean hasClosing(char oper) {
        return (oper == ')' || oper == '}' || oper == ']');
    }

    private static boolean hasHighPrec(char oper1, char oper2) {
        if (getPriorityIndex(oper1) >= getPriorityIndex(oper2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }
}
