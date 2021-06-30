package com.pjhu.springsourcecode.test;

public class OKMP {

    public static void main(String[] args) {
        String ss = "aaaaabaaaaaf";
        String pp = "aaaaaf";
        System.out.println(solution1(ss, pp));
        System.out.println(solution2(ss, pp));
    }

    // 直观的解法的是：枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配：
    // 匹配成功：返回本次匹配的原串「发起点」。
    // 匹配失败：枚举原串的下一个「发起点」，重新尝试匹配。
    public static int solution1(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }

    // 首先匹配串会检查之前已经匹配成功的部分中里是否存在相同的「前缀」和「后缀」。如果存在，则跳转到「前缀」的下一个位置继续往下匹配：
    // originalString: 原串(string)  subString: 匹配串(pattern)
    // https://leetcode-cn.com/problems/implement-strstr/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
    public static void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i<s.length(); i++){
            while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                j=next[j];
            }

            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
    public static int solution2(String origin, String subString) {
        if(subString.length()==0){
            return 0;
        }

        int[] next = new int[subString.length()];
        getNext(next, subString);
        int j = -1;
        for(int i = 0; i<origin.length();i++){
            while(j>=0 && origin.charAt(i) != subString.charAt(j+1)){
                j = next[j];
            }
            if(origin.charAt(i)==subString.charAt(j+1)){
                j++;
            }
            if(j==subString.length()-1){
                return (i-subString.length()+1);
            }
        }
        return -1;
    }
}
