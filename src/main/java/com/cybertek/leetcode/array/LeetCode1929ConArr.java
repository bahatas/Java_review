package com.cybertek.leetcode.array;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode1929ConArr {

    @Test
    public void test1(){

        int[] nums = {1,3,2,1};
        Assert.assertArrayEquals(new int[]{1,3,2,1,1,3,2,1}, getConcatenation(nums));
        System.out.println(getConcatenation(nums));
    }

    static int[] getConcatenation(int[] nums) {

        int ans[] = new int[nums.length*2];

        for (int i =0; i < ans.length ; i++) {
            ans[i+ nums.length-1]=nums[i];
        }

        return ans;
    }
}
