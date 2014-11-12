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

    private void testNotation(String infix, String postfix) {
        String[] data = infix.split("");
        String[] result = new Postfix(data).process();
        Optional<String> resultConcatenated = Arrays.stream(result).reduce((a, b) -> {return a + b;});
        Assert.assertEquals(postfix, resultConcatenated.get());
    }
}
