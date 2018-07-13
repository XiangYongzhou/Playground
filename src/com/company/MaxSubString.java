package com.company;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by xiangyongzhou on 18/7/10.
 */
public class MaxSubString {
     static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> characterSet = new HashSet<>();
            int maxLength = 0;
            int startIndex = 0;
            char[] chars = s.toCharArray();
            for (int endIndex = 0; endIndex < chars.length; endIndex++) {
                if (characterSet.contains(chars[endIndex])) {
                    while (true) {
                        if (chars[startIndex] == chars[endIndex]) {
                            startIndex++;
                            break;
                        } else {
                            characterSet.remove(chars[startIndex]);
                            startIndex++;
                        }
                    }
                } else {
                    characterSet.add(chars[endIndex]);
                    if ((endIndex - startIndex + 1) > maxLength) {
                        maxLength = endIndex - startIndex + 1;
                    }
                }
            }
            return maxLength;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        String a = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(a));
    }
}
