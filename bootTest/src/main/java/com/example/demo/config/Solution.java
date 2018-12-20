package com.example.demo.config;

import javax.xml.crypto.Data;

/**
 * @Auther fanhanxi
 * @Date 2018/12/18
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = solution.reverse(-2147483648);
    }

    int reverse(int num) {
        Long test = Long.valueOf(num);

        Boolean flag = test >= 0 ? true : false;

        if (!flag) {
            test = test * (-1);
        }

        char[] nums = String.valueOf(test).toCharArray();

        for (int i = 0, j = nums.length; i < j / 2; i++) {
            char temp = nums[i];
            nums[i] = nums[j - 1 - i];
            nums[j - 1 - i] = temp;
        }

        Double max = Math.pow(2, 31) - 1;
        Double min = Math.pow(-2, 31);

        Long result = Long.valueOf(String.valueOf(nums));
        if (!flag) {
            result = 0 - result;
        }
        if (result > max || result < min) {
            return 0;
        } else {
            return result.intValue();
        }
    }
}
