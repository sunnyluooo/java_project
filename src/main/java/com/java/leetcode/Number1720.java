package com.java.leetcode;

import java.util.Arrays;

/**
 * @author trayvonn
 * @date 2022/8/25 14:53
 */
public class Number1720 {

    /**
     *
     * 未知 整数数组 arr 由 n 个非负整数组成。
     * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
     * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
     * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
     *
     * ========
     *
     * 输入：encoded = [1,2,3], first = 1
     * 输出：[1,0,2,1]
     * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
     *
     * 输入：encoded = [6,2,7,3], first = 4
     * 输出：[4,2,0,7,4]
     *
     * @param encoded
     * @param first
     * @return
     */
    private static int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {

            // encoded[i] = arr[i] ^ arr[i+1]
            // 两边同时 添加 arr[i] => encoded[i] ^ arr[i] =  arr[i] ^ arr[i] ^ arr[i+1]
            // 根据 相同为0 ，不同为1 得出 encoded[i] ^ arr[i] = 0 ^ arr[i+1]
            // 再根据 0和任何数 XOR 等于他自身 得出 encoded[i] ^ arr[i] = arr[i+1]
            arr[i+1] = arr[i] ^ encoded[i];

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] encoded = {6,2,7,3};

        System.out.println(Arrays.toString(decode(encoded, 4)));
    }

}
