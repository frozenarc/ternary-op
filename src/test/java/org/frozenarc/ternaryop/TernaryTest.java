package org.frozenarc.ternaryop;

import org.frozenarc.ternaryop.Ternary;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TernaryTest {

    private static WhenTest<String> optrStr() {
        return Ternary.optr();
    }

    private String test(ArrayList list) {
        return optrStr()
                .whn(() -> list.size() > 0)
                .thn(() -> optrStr()
                        .whn(() -> list.get(0) == null)
                        .thn(() -> "Null Element")
                        .els(() -> optrStr()
                                .whn(() -> list.get(0).equals("1"))
                                .thn(() -> "1")
                                .els(() -> "Other Number")))
                .els(() -> "Empty");
    }

    @Test
    public void testEmpty() {
        ArrayList list = new ArrayList();
        Assert.assertTrue(test(list).equals("Empty"));
    }

    @Test
    public void testNull() {
        ArrayList list = new ArrayList();
        list.add(null);
        Assert.assertTrue(test(list).equals("Null Element"));
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add("1");
        Assert.assertTrue(test(list).equals("1"));
    }

    @Test
    public void testOther() {
        ArrayList list = new ArrayList();
        list.add("2");
        Assert.assertTrue(test(list).equals("Other Number"));
    }
}
