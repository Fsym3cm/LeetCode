/*反转字符串中的单词 III*/
package com.chengzimm;

class Solution557 {
    public String reverseWords(String s) {
        if (s.isEmpty()){
            return "";
        }
        String[] sp = s.split(" ");
        StringBuffer sb = new StringBuffer();
        //遍历每个单词
        for (int i = 0; i < sp.length; i++){
            if (sp[i].length() > 0) {
                //反转单词
                for (int j = sp[i].length() - 1; j >= 0; j--){
                    sb.append(sp[i].charAt(j));
                }
                //每个单词后添加空格
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString()/* + " "*/).append(" ");
        return res.toString().trim();
    }
}
public class LeetCode557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Solution557 solution = new Solution557();
        String answer = solution.reverseWords2(s);
        System.out.print(answer);
    }
}
