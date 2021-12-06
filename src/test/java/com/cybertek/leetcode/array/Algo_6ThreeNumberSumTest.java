package com.cybertek.leetcode.array;

import com.cybertek.leetcode.ALGO_QS.Algo6_ThreeNumberSum;
import org.junit.Assert;
import org.junit.Test;

public class Algo_6ThreeNumberSumTest {

    @Test
    public void threeNumSum() {

        Assert.assertArrayEquals("Expected Message", Algo6_ThreeNumberSum.threeNumSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0), new int[][]{{-8, 2, 6}, {-8, 3 - 5}, {-6, 1, 5}});
    }
}