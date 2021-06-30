package com.pjhu.aopioc.test;

public class M62SearchRotatedArray {

    public static void main(String[] args) {
        Integer[] a  = new Integer[] {4,5,6,7,8,9,1,2,3};
        System.out.println(solution(a, 2));
        Integer[] b  = new Integer[] {7,8,9,1,2,3,4,5,6};
        System.out.println(solution(b, 7));
    }

    public static Integer solution(Integer[] a, Integer target) {
        Integer start = 0;
        Integer end = a.length - 1;

        while (start <= end)  {
            Integer mid = (end+start) / 2;
            if (a[mid].equals(target)) {
                return mid;
            }

            if (a[start] < a[mid]) {
                if(a[start] < target &&  target < a[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (a[mid] < target &&  target < a[end] ) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(a[start].equals(target)) {
            return start;
        }
        if (a[end].equals(target)) {
            return end;
        }
        return -1;
    }
}
