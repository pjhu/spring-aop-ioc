package com.pjhu.springsourcecode.test;

public class A65ZhongWeiShu {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {8, 9, 10, 11, 12, 13};

        int length1 = a.length, length2 = b.length;
        int totalLength = length1 + length2;

        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = solution(a, b, midIndex + 1);
            System.out.println(median);
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (solution(a, b, midIndex1 + 1) + solution(a, b, midIndex2 + 1)) / 2.0;
            System.out.println(median);
        }
    }

    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    private static int solution(int[] a, int[] b, int k) {

        int length1 = a.length, length2 = b.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return b[index2 + k - 1];
            }
            if (index2 == length2) {
                return a[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(a[index1], b[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = a[newIndex1], pivot2 = b[newIndex2];
            if (pivot1 <= pivot2) {
                System.out.printf("index=%d,ni=%d, k=%d\n", index1, newIndex1, k);
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
                System.out.printf("index=%d,ni=%d, k=%d,h=%d\n\n", index1, newIndex1, k, half);
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}



