package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiangyongzhou on 18/7/10.
 */
public class Permutation {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> returnList = new ArrayList<>();
            return rotation(returnList, nums, 0);
        }

        private List<List<Integer>> rotation(List<List<Integer>> returnList, int[] nums, int startIndex) {
            if (startIndex + 1 == nums.length) {
                System.out.println(startIndex + ":" + "-1");
                List<Integer> newList = new ArrayList<>(nums.length);
                for (int i:nums) {
                    newList.add(i);
                }
                returnList.add(newList);
            } else if (startIndex + 1 < nums.length) {
                int temp = 0;
                for (int i = startIndex; i< nums.length; i++) {
                    System.out.println(startIndex + ":" + i);
                    int[] newA = nums.clone();
                    temp = newA[i];
                    newA[i] = newA[startIndex];
                    newA[startIndex] = temp;
                    int newIndex = startIndex + 1;
                    rotation(returnList, newA, newIndex);
                    System.out.println("next");
                }
            }
            return returnList;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] i =  {1,2,3};
        List<List<Integer>> permuteList = solution.permute(i);
    }
}
