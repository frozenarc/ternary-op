package org.frozenarc.ternaryop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TernaryTest {

    private static WhenTest<String> optrStr() {
        return Ternary.optr();
    }

    private String test(ArrayList<String> list) {
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
        ArrayList<String> list = new ArrayList<>();
        Assert.assertEquals("Empty", test(list));
    }

    @Test
    public void testNull() {
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        Assert.assertEquals("Null Element", test(list));
    }

    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        Assert.assertEquals("1", test(list));
    }

    @Test
    public void testOther() {
        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        Assert.assertEquals("Other Number", test(list));
    }
}
