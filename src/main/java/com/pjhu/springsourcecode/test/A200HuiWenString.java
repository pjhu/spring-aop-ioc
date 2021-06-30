package com.pjhu.springsourcecode.test;

// 200-查找字符串中的最长回文字符串
// 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可
// 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心
public class A200HuiWenString {

    public static void main(String[] args) {
        System.out.println(solution1("9912333321456"));
        System.out.println(solution2("9912333321456"));
    }

    // 回文字符串: solution 1, O(n^2)
    private static String solution1(String s) {
        String max = "";
        for(int i=0;i<s.length();i++) {
            String s1 = extend(s,i,i), s2=extend(s,i,i+1);
            if(s1.length() > max.length()) max=s1; // longest is odd
            if(s2.length() > max.length()) max=s2; // longest is even
        }
        return max;
    }

    private static String extend(String s, int i, int j) {
        System.out.println("start: " + i + " - " + j);
        for(; 0<=i && j< s.length();i--,j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        System.out.println(i);
        System.out.println(j);
        return s.substring(i+1,j);
    }

    // 回文字符串: solution 2, O(n^2)
    private static String solution2(String s) {
        if (s == null) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            String palindrome = intermediatePalindrome(s, i, i);
            assert palindrome != null;
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //even cases like 1221
            palindrome = intermediatePalindrome(s, i, i + 1);
            assert palindrome != null;
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }
    private static String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
