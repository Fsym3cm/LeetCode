package com.chengzimm;

/**
 * 5. 最长回文子串
 *
 * @author CM
 * @date 2020/9/15 10:31
 */
public class leetCode5 {

    public String longestPalindrome(String s) {
        String str, target = "";
        if (s.length() < 2){
            return s;
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length() + 1; j++){
                str = s.substring(i,j);
                System.out.println(str);
                if (str.length() > target.length() && Palindrome(str)){
                    target = str;
                }
            }
        }
        return target;
    }
    public boolean Palindrome(String str){
        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划解题步骤
     *
     * 第 1 步：定义状态
     * dp[i][j] 表示子串 s[i..j] 是否为回文子串，这里子串 s[i..j] 定义为左闭右闭区间，可以取到 s[i] 和 s[j]。
     *
     * 第 2 步：思考状态转移方程
     * 在这一步分类讨论（根据头尾字符是否相等），根据上面的分析得到：
     * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     * 说明：
     * 「动态规划」事实上是在填一张二维表格，由于构成子串，因此 i 和 j 的关系是 i <= j ，因此，只需要填这张表格对角线以上的部分。
     * 看到 dp[i + 1][j - 1] 就得考虑边界情况。
     * 边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
     * 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
     *
     * 如果子串 s[i + 1..j - 1] 只有 1 个字符，即去掉两头，剩下中间部分只有 11 个字符，显然是回文；
     * 如果子串 s[i + 1..j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。
     * 因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下，直接可以下结论，dp[i][j] = true，否则才执行状态转移。
     *
     * 第 3 步：考虑初始化
     * 初始化的时候，单个字符一定是回文串，因此把对角线先初始化为 true，即 dp[i][i] = true 。
     * 事实上，初始化的部分都可以省去。因为只有一个字符的时候一定是回文，dp[i][i] 根本不会被其它状态值所参考。
     *
     * 第 4 步：考虑输出
     * 只要一得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，这是因为截取字符串也要消耗性能，记录此时的回文子串的「起始位置」和「回文长度」即可。
     *
     * 第 5 步：考虑优化空间
     * 因为在填表的过程中，只参考了左下方的数值。事实上可以优化，但是增加了代码编写和理解的难度，丢失可读和可解释性。在这里不优化空间。
     * 注意事项：总是先得到小子串的回文判定，然后大子串才能参考小子串的判断结果，即填表顺序很重要。
     * 大家能够可以自己动手，画一下表格，相信会对「动态规划」作为一种「表格法」有一个更好的理解。
     *
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0, maxLen = 1;
        boolean dp[][] = new boolean[len][len];
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for (int j = 0; j < len; j++){
            for (int i = 0; i < j; i++){
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                } else {
                    // 当 j - i < 3时（2 - 3个字符的字符串），如果前后两个字符相等，则字符串必为回文字符串
                    if (j - i < 3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "aa";
        leetCode5 leetCode5 = new leetCode5();
        System.out.println(leetCode5.longestPalindrome(s));
    }
}
