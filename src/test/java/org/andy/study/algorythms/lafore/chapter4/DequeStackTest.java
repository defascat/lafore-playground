package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class DequeStackTest extends StackTest {

    @Override
    protected Stack<Character> createCharStack() {
        return new DequeStack<>();
    }

    @Override
    protected Stack<Integer> createIntStack() {
        return new DequeStack<>();
    }
    
}
