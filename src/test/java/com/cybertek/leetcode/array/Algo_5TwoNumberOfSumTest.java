package com.cybertek.leetcode.array;

import com.cybertek.leetcode.ALGO_QS.Algo5_TwoNumberOfSum;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class Algo_5TwoNumberOfSumTest extends TestCase {

    @Test
    public void testGetArray() {
        Assert.assertArrayEquals(Algo5_TwoNumberOfSum.getArray(new int[]{3, 5, -4, 8, 11, 1, -1}, 10), new int[]{-1, 11});
    }

    @Test
    public void testGetArray2() {
    }

    @Test
    public void testGetArray3() {
    }
}