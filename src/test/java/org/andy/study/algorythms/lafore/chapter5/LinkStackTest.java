package org.andy.study.algorythms.lafore.chapter5;

import org.andy.study.algorythms.lafore.chapter4.Stack;
import org.andy.study.algorythms.lafore.chapter4.StackTest;
import org.junit.Ignore;

/**
 *
 * @author andy
 */
public class LinkStackTest extends StackTest {

    @Override
    protected Stack<Character> createCharStack() {
        return new LinkStack<>();
    }

    @Override
    protected Stack<Integer> createIntStack() {
        return new LinkStack<>();
    }
    
    @Ignore
    @Override
    public void testStackOverflow() {        
    }
    
}
