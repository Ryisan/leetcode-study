package com.ryisan.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ruansm
 * @date 2022/5/31
 */
public class LongestCommonPrefix014 {

    public static void main(String[] args) {
        String[] array = new String[]{"abc","abc","accc"};
        System.out.println(longestCommonPrefix(array));

    }

    public static String longestCommonPrefix1(String[] array){
        int length = array.length;
        String res = null;
        for (int i = 0; i < length; i++) {
            String s = array[i];
            res = min(res, s);
        }

        int indexLen = res.length();
        Set<Character> set = new HashSet<>();
        StringBuffer resString = new StringBuffer();
        int next = 0;
        for (int i = 0; i < indexLen; i++) {
            set.clear();
            int count = 0;
            for (int j = 0; j < length; j++) {
                char c = array[j].charAt(i);
                set.add(c);
                count++;
                if(count == length &&  set.size() == 1){
                    if(next == i){
                        resString.append(c);
                        next++;
                        continue;
                    }else{
                        break;
                    }
                }
            }
        }
        return resString.toString();
    }

    public static String min(String a,String b){
        if(a == null){
            return b;
        }
        return a.length() <= b.length() ? a:b;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
