package com.chengzimm;

public class TailRecursion {
    private int helper_non_tail_recursion(int start, int [] ls) {
        if (start >= ls.length) {
            return 0;
        }
        // not a tail recursion because it does some computation after the recursive call returned.
        return ls[start] + helper_non_tail_recursion(start+1, ls);
    }

    //求和
    public int sum_non_tail_recursion(int [] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_non_tail_recursion(0, ls);
    }

    //---------------------------------------------

    private int helper_tail_recursion(int start, int [] ls, int acc) {
        if (start >= ls.length) {
            return acc;
        }
        // this is a tail recursion because the final instruction is the recursive call.
        return helper_tail_recursion(start+1, ls, acc+ls[start]);
    }

    public int sum_tail_recursion(int [] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_tail_recursion(0, ls, 0);
    }

    public static void main(String[] args) {
        //{'h', 'e', 'l', 'l', 'o'}
        int[] s = {1, 2, 3, 4, 5, 6};
        TailRecursion tailRecursion = new TailRecursion();
        int i1 = tailRecursion.sum_tail_recursion(s);
        System.out.println(i1);
    }
}
