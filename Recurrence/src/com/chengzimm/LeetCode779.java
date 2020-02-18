/*第K个语法符号*/
package com.chengzimm;

class Solution779 {
    /**
     * 第一行: 0
     * 第二行: 01
     * 第三行: 0110
     * 第四行: 01101001
     *
     * 第二层为0，1
     * 第三层为0，1，1，0
     * 第四层为0，1，1，0，1，0，0，1
     * 当K为奇数时，该语法符号就和上一层的(K+1)/2列保持一致
     * 当K为偶数时，该语法符号就和上一层的K/1列相反(若1则0，若0则1)
     */
    public int kthGrammar(int N, int K) {
        //画出二叉树
        //左子树的节点值和父节点相同，右子树的节点和父节点的值不同
        if (N == 1 && K == 1)
            return 0;
        if (K % 2 == 1)
            return kthGrammar(N - 1,(K + 1) / 2);
        else {
            int i = kthGrammar(N - 1, K / 2);
            if (i == 1)
                return 0;
            else
                return 1;
        }
    }

}
public class LeetCode779 {
    public static void main(String[] args) {
        int N = 4, K = 4;
        Solution779 solution = new Solution779();
        int i = solution.kthGrammar(N, K);
        System.out.println(i);
    }
}
