package learnSelenium;

import org.junit.Assert;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Suite;

public class LearnAssertions {

    @Test
    public void testCompareStringValues() {
        String actual = "Mac";
        String expected = "Mac";

        Assert.assertEquals("The value of String b (" + expected + "), is not equal to String a (" + actual + ")", expected, actual);
//        Assert.assertNotEquals(unexpected, actual);

//        boolean flag = false;
//
//        if (actual.toLowerCase().equals(expected.toLowerCase())) {
//            flag = true;
//        }
//
//        Assert.assertTrue(flag);
    }

    @Test
    public void testCompareArrays() {
        int[] expected = {5, 2, 3, 5};
        int[] actual = {5, 2, 3, 5};

        Assert.assertArrayEquals(expected, actual);
    }

}
