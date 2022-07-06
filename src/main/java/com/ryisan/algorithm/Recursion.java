package com.ryisan.algorithm;

/**
 * @author ruansm
 * @date 2022/5/30
 */
public class Recursion {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(lineRecursion(n));
        System.out.println(tailRecursion(n));
    }
    //线性递归
    public static int lineRecursion(int n){
        return (n == 1) ? 1 : n * lineRecursion(n - 1);
    }

    public static int tailRecursion(int n){
        return tailRecursion(n,1);
    }
    //尾部递归
    //当递归调用是整个函数体中最后执行的语句且它的返回值不属于表达式的一部分时，这个递归调用就是尾递归
    public static int tailRecursion(int n,int a){
        return (n == 1) ? a : tailRecursion(n - 1, a * n);
    }
}
