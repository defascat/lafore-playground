package org.andy.study.algorythms.lafore.chapter4;

import java.util.Arrays;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class PostfixTest {
    @Test
    public void testPostfix() {
        testNotation("A+B-C", "AB+C-");
        testNotation("A*B/C", "AB*C/");
        testNotation("A+B*C", "ABC*+");
        testNotation("A*B+C", "AB*C+");
        testNotation("A*(B+C)", "ABC+*");
        testNotation("A*B+C*D", "AB*CD*+");
        testNotation("(A+B)*(C-D)", "AB+CD-*");
        testNotation("((A+B)*C)-D", "AB+C*D-");
        testNotation("A+B*(C-D/(E+F))", "ABCDEF+/-*+");
    }
    
    @Test
    public void testPostfixCalculation() {
        testCalculation("1", 1);
        testCalculation("1+5-2", 4);
        testCalculation("3*5/5", 3);
        testCalculation("1+2*5", 11);
        testCalculation("3*2+5", 11);
        testCalculation("4*(2+5)", 28);
        testCalculation("3*2+5*4", 26);
        testCalculation("(1+2)*(6-4)", 6);
        testCalculation("((1+2)*5)-4", 11);
        testCalculation("1+2*(8-4/(0+2))", 13);
    }

    private void testNotation(String infix, String postfix) {
        String[] data = infix.split("");
        String[] result = new Postfix(data).process();
        Optional<String> resultConcatenated = Arrays.stream(result).reduce((a, b) -> {return a + b;});
        Assert.assertEquals(postfix, resultConcatenated.get());
    }

    private void testCalculation(String infix, int expectedResult) {
        String[] data = infix.split("");
        int result = new Postfix(data).calculate();
        Assert.assertEquals(expectedResult, result);
    }
}
