package com.pjhu.aopioc.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A544MaximumK {

    public static void main(String[] args) {

    }

    private static int[] solution1(int[] a, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1, Comparator.comparingInt(l -> l));
        PriorityQueue<Integer> q = new PriorityQueue<>(k+1, new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return v1 - v2;
            }
        });

        for (int i : a) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];

        for (int i=0; i<k;i++) {
            result[k-i-1] = queue.poll();
        }
        return result;
    }

    private static void solution2(int[] a, int start, int end, int k) {
        if (start > k) {
            return;
        }
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int mid = a[(start + end) / 2];

        while (left <= right) {
            while (left <= right && a[left] > mid) {
                left++;
            }

            while (left <= right && a[right] < mid) {
                right--;
            }

            if (left <= right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;

                left++;
                right--;
            }
        }

        solution2(a, start, right, k);
        solution2(a, left, end, k);
    }
}
