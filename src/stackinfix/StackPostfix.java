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
public class StackPostfix {

    public static String postfix2Infix(String postfix) {
        Stack<String> s = new Stack<>();    //init empty stack

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (StackInfix.isOperator(c)) {     //if op
                String b = s.pop();     //last element
                String a = s.pop();     //second last element
                s.push("(" + a + c + b + ")");  //push whole string with ( and )
            } else {
                s.push("" + c);     //operand than push
            }
        }

        return s.pop();
    }

}
