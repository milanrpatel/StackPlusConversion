/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackinfix;

/**
 *
 * @author MILAN PATEL
 */
public class Conversion {

    //infix to postfix
    public static String infixToPostfix(String str) {
        return (StackInfix.infix2Postfix(str));
    }

    //infix to prefix
    public static String infixToPrefix(String str) {
        return (StackInfix.infix2Prefix(str));
    }

    //postfix to infix
    public static String postfixToInfix(String str) {
        return (StackPostfix.postfix2Infix(str));
    }

    //prefix to postfix
    public static String prefixToPostfix(String str) {
        return (StackPrefix.prefix2Postfix(str));
    }

}
