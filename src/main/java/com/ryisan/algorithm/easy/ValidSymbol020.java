package com.ryisan.algorithm.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ruansm
 * @date 2022/6/2
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 示例：
 * 输入：s = "()"
 * 输出：true
 * 思路：
 * 1）使用栈结构实现
 * 2）定义一个字符map，如果key包含右括号，则push进栈，如果不包含，则pop出栈比较
 *
 */
public class ValidSymbol020 {

    public static void main(String[] args) {
        String s = "}{";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        int length = s.length();
        if(length % 2 != 0 || length == 0){
            return false;
        }
        Map<Character,Character> symbolMap = new HashMap();
        symbolMap.put(')','(');
        symbolMap.put(']','[');
        symbolMap.put('}','{');
        Stack stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(symbolMap.containsKey(c)){
                if(stack.empty()){
                    return false;
                }
                Object pop = stack.pop();
                if(pop.equals(symbolMap.get(c))){
                    continue;
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
