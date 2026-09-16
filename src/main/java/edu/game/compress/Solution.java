package edu.game.compress;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> compressNumbers(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        result.add(nums.get(0));

        for (int i = 1; i < nums.size(); i++) {
            int current = nums.get(i);
            if (current != result.get(result.size() - 1)) {
                result.add(current);
            }
        }

        return result;
    }
}