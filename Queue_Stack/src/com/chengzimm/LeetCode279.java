package com.chengzimm;

class Solution279 {
    //四方定理：任何一个 自然数都可以用至多 四个数的平方来表示。  那么这道题就是变成了判断到底是用几个数表示
    public int numSquares(int n) {
        if(n <= 0){return 0;}
        if(check1(n)){
            return 1;
        }else if(check2(n)){
            return 2;
        }else if(check3(n)){
            return 3;
        }else{
            return 4;
        }
    }
    public boolean check1(int n){
        int tem = (int)Math.sqrt(n);
        return tem*tem == n;
    }
    public boolean check2(int n){
        for(int i = 1 ; i * i < n ; i++){
            if(check1(n - i * i))
                return true;
        }
        return false;
    }
    public boolean check3(int n){
        for(int i = 1 ; i * i < n ; i++){
            if(check2(n - i * i)){
                return true;
            }
        }
        return false;
    }

}
public class LeetCode279 {
    public static void main(String[] args) {
        int n = 13;
        Solution279 solution = new Solution279();
        int answer = solution.numSquares(n);
        System.out.println(answer);
    }
}
