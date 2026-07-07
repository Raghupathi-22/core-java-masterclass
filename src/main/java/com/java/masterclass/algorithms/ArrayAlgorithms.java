package com.java.masterclass.algorithms;

import java.util.HashMap;
import java.util.Map;

public final class ArrayAlgorithms {
    private ArrayAlgorithms() {}

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexByValue.containsKey(complement)) {
                return new int[] {indexByValue.get(complement), i};
            }
            indexByValue.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static int maxSubArraySum(int[] nums) {
        int best = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }
}
