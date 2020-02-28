/*宝石与石头*/
package com.chengzimm;

import java.util.HashSet;

class Solution782 {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (char j : J.toCharArray()){
            set.add(j);
        }
        int sum = 0;
        for (char s : S.toCharArray()){
            if (set.contains(s))
                sum++;

        }
        return sum;
    }

    public int numJewelsInStones2(String J, String S) {
        int sum = 0;
        for(char j : J.toCharArray()){
            for (char s : S.toCharArray()){
                if (s == j)
                    sum++;
            }
        }
        return sum;
    }
}

public class LeetCode782 {
    public static void main(String[] args) {
        //aA  aAAbbbb
        String J = "z", S = "ZZ";
        Solution782 solution = new Solution782();
        int i = solution.numJewelsInStones(J, S);
        System.out.println(i);
    }
}
