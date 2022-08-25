package com.java.leetcode;

/**
 * @author trayvonn
 * @date 2022/8/25 15:41
 */
public class Number26 {

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
     * 将最终结果插入nums 的前 k 个位置后返回 k 。
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * <p>
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     * <p>
     * int k = removeDuplicates(nums); // 调用
     * <p>
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     */

    private static int removeDuplicates(int[] nums) {
        int k = 1;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = point + 1; j < nums.length; j++) {
                point = j;

                if (nums[i] < nums[j]) {
                    nums[i + 1] = nums[j];
                    k = (i + 1) + 1;
                    break;
                }

            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
