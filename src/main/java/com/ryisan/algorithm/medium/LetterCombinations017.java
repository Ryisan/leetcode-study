package com.ryisan.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ruansm
 * @date 2022/6/1
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *思路：
 * 1）首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作
 * 2）回溯四部曲：
 * 回溯参数
 * 终止条件
 * 单层递归逻辑
 * 选择其他分支（撤销选择 重置状态）
 * 3）回溯模板
 * result = [];
 * function backtrack (path, list) {
 *     if (满足条件) {
 *         result.push(path);
 *         return
 *     }
 *
 *     for () {
 *         // 单层逻辑
 *         backtrack (path, list)
 *         // 撤销选择 重置状态
 *     }
 * }
 */
public class LetterCombinations017 {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));

    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> letterCombinations = new ArrayList<>();
        backtrack(digits,0,phoneMap,new StringBuilder(),letterCombinations);
        return letterCombinations;
    }

    public static void backtrack(String digits,int index,Map<Character, String> phoneMap,StringBuilder combination,List<String> letterCombinations){
        if(index == digits.length()){
            letterCombinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lengthCount = letters.length();
            for (int i = 0; i < lengthCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(digits,index+1,phoneMap,combination,letterCombinations);
                combination.deleteCharAt(index);
            }
        }
    }
}
