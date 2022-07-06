package com.ryisan.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruansm
 * @date 2022/6/2
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 思路：
 * dfs(depth first search深度优先搜索算法)
 */
public class GenerateParenthesis022 {

    public static void main(String[] args) {
       int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, n, "",res);
        return res;
    }

    private static void generate(int left, int right, String curStr,List<String> res ) {
       if(left == 0 && right == 0){
           res.add(curStr);
           return;
       }
       if(left > 0){
           generate(left-1,right,curStr+"(",res);
       }
       if(right>left){
           generate(left,right-1,curStr+")",res);
       }
    }

}
