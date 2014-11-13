package org.andy.study.algorythms.lafore.chapter4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class StackTest {
    @Test
    public void testStack() throws IllegalAccessException {
        testStackOrder(0);
        testStackOrder(0, 1, 2, 3);
        testStackOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        try {
            testStackOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            fail();
        } catch(IllegalAccessException | IllegalStateException e) {
        }
        
        try {
            final Stack stack = createIntStack();
            assertTrue(stack.isEmpty());
            stack.pop();
            fail();
        } catch(IllegalAccessException | IllegalStateException e) {
        }
    }

    @Test
    public void reverseWord() throws IllegalAccessException {
        testWordReversed("hello", "olleh");
        testWordReversed("Andrey", "yerdnA");
    }

    @Test
    public void bracketsVerification() throws IllegalAccessException {
        testBrackets("c[d]", true);
        testBrackets("a{b[c]d}e", true);
        testBrackets("a{b(c]d}e", false);
        testBrackets("a[b{c}d]e}", false);
        testBrackets("a{b(c)", false);
    }

    private void testStackOrder(int... items) throws IllegalAccessException {
        final Stack<Integer> stack = createIntStack();
        for (int i = 0; i < items.length; i++) {
            final int item = items[i];
            stack.push(item);
            assertEquals(item, (int) stack.peek());
        }
        
        for (int i = items.length - 1; i >= 0 ; i--) {
            final int item = items[i];
            assertFalse(stack.isEmpty());
            assertEquals(item, (int) stack.peek());
            assertEquals(item, (int) stack.pop());
        }
    }

    private void testWordReversed(String original, String expected) throws IllegalAccessException {
        Stack<Character> stack = createCharStack();
        original.chars().forEachOrdered(ch -> {
            try {
               stack.push((char) ch);
            } catch (IllegalAccessException | IllegalStateException ex) {
                fail();
            }
        });
        
        char[] chars = new char[original.length()];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        assertEquals(expected, new String(chars));
    }

    private void testBrackets(String str, boolean valid) throws IllegalAccessException {
        Stack<Character> stack = createCharStack();
        boolean isValid = true;
        try {
            for(int i = 0; i < str.length(); i++) {
                char a = str.charAt(i);
                switch(a) {
                    case '[':
                    case '{':
                    case '(':
                        stack.push(a);
                        break;
                    case ']':
                        validateStack(stack, '[');
                        break;
                    case ')':
                        validateStack(stack, '(');
                        break;
                    case '}':
                        validateStack(stack, '{');
                        break;
                }
            }
            isValid = stack.isEmpty();
        } catch(IllegalStateException e) {
            isValid = false;
        }
        assertEquals(valid, isValid);
    }

    private void validateStack(Stack<Character> stack, char c) {
        try {
            final Character item = stack.pop();
            if(item != c) {
                throw new IllegalStateException("Expecting " + c);
            }
        } catch (IllegalAccessException ex) {
            throw new IllegalStateException("Stack is empty");
        }
    
    }

    protected Stack<Integer> createIntStack() {
        return new Stack<>();
    }

    protected Stack<Character> createCharStack() {
        return new Stack<>();
    }

}
