package cxl.study.orther;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        final String plus = "+", subract = "-", multiply = "*", divide = "/";
        int result = 0;
        Stack<Integer> stringStack = new Stack<>();
        int num1 , num2;
        for (String token : tokens) {
            switch (token) {
                case plus: {
                    result = stringStack.pop() + stringStack.pop();
                    stringStack.push(result);
                    break;
                }
                case subract: {
                    num1 = stringStack.pop();
                    num2 = stringStack.pop();
                    result = num2 - num1;
                    stringStack.push(result);
                    break;
                }
                case multiply: {
                    result = stringStack.pop() * stringStack.pop();
                    stringStack.push(result);
                    break;
                }
                case divide: {
                    num1 = stringStack.pop();
                    num2 = stringStack.pop();
                    result = num2 / num1;
                    stringStack.push(result);
                    break;
                }
                default: {
                    stringStack.push(Integer.parseInt(token));
                    break;
                }
            }
        }
        return stringStack.pop();
    }


        public static void main (String[] args){
            ReversePolishNotation polishNotation = new ReversePolishNotation();
            String[] strings = {"4", "3","-"};
            System.out.println(polishNotation.evalRPN(strings));
        }

    }
