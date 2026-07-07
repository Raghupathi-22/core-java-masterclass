package com.java.masterclass.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAlgorithmsTest {

    @Test
    void shouldSolveTwoSum() {
        int[] result = ArrayAlgorithms.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void shouldComputeMaxSubArray() {
        assertEquals(6, ArrayAlgorithms.maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
