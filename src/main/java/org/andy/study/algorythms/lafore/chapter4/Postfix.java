/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andy.study.algorythms.lafore.chapter4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 *
 * @author andy
 */
public class Postfix {
    private final Stream<String> data;
    private java.util.Queue<String> queue = new LinkedList<>();
    
    public Postfix(String[] data) {
        this.data = Arrays.stream(data);
    }

    public String[] process() {
        java.util.Stack<String> operations = new java.util.Stack<>();
        data.forEachOrdered((String str) -> {
            if(isSign(str) || isBracket(str)) {
                if(operations.isEmpty()) {
                    pushToStack(str, operations);
                } else {
                    int opPriorityOld = getPriority(operations.peek());
                    int opPriorityNew = getPriority(str) + 10 * (operations.peek().equals("(") ? 1 : 0);
                    if(opPriorityNew > opPriorityOld) {
                        operations.push(str);
                    } else {
                        repushStack(operations);
                        pushToStack(str, operations);
                    }
                }
            } else {
                queue.add(str);
            }
        });
        repushStack(operations);
        return queue.toArray(new String[]{});
    }    

    public int calculate() {
        String[] result = process();
        final Stack<String> stack = new Stack<>();
        for(int i = result.length - 1; i >= 0; i--) {
            stack.push(result[i]);
        }
        Stack<String> tmpStack = new Stack<>();
        while(!stack.isEmpty()) {
            final String str = stack.pop();
            if(isSign(str)) {
                int resultInt = calculate(str, tmpStack.pop(), tmpStack.pop());
                stack.push("" + resultInt);
                while(!tmpStack.isEmpty()) {
                    stack.push(tmpStack.pop());
                }
            } else {
                tmpStack.push(str);
            }
        }
        return Integer.parseInt(tmpStack.pop());
    }

    public int calculateFast() {
        String[] result = process();
        final Stack<Integer> stack = new Stack<>();
        for(String str : result) {
            if(isSign(str)) {
                final Integer v1 = stack.pop();
                final Integer v2 = stack.pop();
                stack.push(calculate(str, v2, v1));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private void pushToStack(String str, Stack<String> operations) {
        if(!str.equals(")")) {
            operations.push(str);
        }
    }

    private void repushStack(Stack<String> operations) {
        while(!operations.isEmpty()) {
            final String str = operations.pop();
            if(!str.equals("(")) {
                queue.add(str);
            }
        }
    }    
    
    private int getPriority(String sign) {
        switch(sign) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case ")":
                return 0;
            case "(":
                return 3;
            default:
                throw new IllegalArgumentException("Unknown sign: " + sign);
        }
    }
    
    private boolean isSign(String str) {
        return str.equals("+") || str.equals("-")
                || str.equals("*") || str.equals("/");
    }
    
    private boolean isBracket(String str) {
        return str.equals("(") || str.equals(")");
    }

    private int calculate(String str, String str1, String str2) {
        return calculate(str, Integer.parseInt(str2), Integer.parseInt(str1));
    }

    private int calculate(String str, int i2, int i1) throws IllegalArgumentException {
        switch(str) {
            case "+": return i2 + i1;
            case "-": return i2 - i1;
            case "*": return i2 * i1;
            case "/": return i2 / i1;
        }
        throw new IllegalArgumentException("Unsupported operation " + str);
    }
}
