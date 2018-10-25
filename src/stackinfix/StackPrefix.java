/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackinfix;

import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author MILAN PATEL
 */
public class StackPrefix {

    //prefix to postfix
    public static String prefix2Postfix(String input) {
        String output = "";     //init empty string
        Stack f = new Stack();  //
        Stack s = new Stack();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (StackInfix.isOperator(ch)) {
                s.push(ch);
                f.push('0');
            } else {
                output = output + ch;
                String c = "1";
                while (Objects.toString(f.peek()).equals(c)) {
                    output = output + s.pop();
                    f.pop();
                    if (f.isEmpty()) {
                        break;
                    }
                }
                if (!f.isEmpty()) {
                    f.pop();
                }
                f.push(c);
            }
        }
        return output;
    }

}
