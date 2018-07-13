package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiangyongzhou on 18/7/10.
 */
public class MedianOfSortedArray {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return findMedian(nums1, nums2, (nums1.length + nums2.length) % 2 == 1);
        }

        public double findMedian(int[] nums1, int[] nums2, boolean isOdds) {
            if (nums1.length <= 2 || nums2.length <= 2) {
                if (isOdds) {
                    return Math.max(Math.max(nums1[0], nums2[0]), Math.min(nums1[1], nums2[2]));
                } else {
                    return (Math.max(nums1[0], nums2[0]) + Math.min(nums1[1], nums2[2])) / 2;
                }
            } else {
                int midIndex1 = (nums1.length + 1) / 2 ;
                int midIndex2 = (nums2.length + 1) / 2;
                if (nums1[midIndex1] == nums2[midIndex2]) {
                    return nums1[midIndex1];
                } else {
                    if (nums1[midIndex1] > nums2[midIndex2]) {
                        int[] new1 = Arrays.copyOfRange(nums1, 0, midIndex1 - 1);
                        int[] new2 = Arrays.copyOfRange(nums2, midIndex2, nums2.length - 1);
                        return  findMedian(new1, new2, isOdds);
//                        int[] new1 = Arrays.copyOfRange()
//                        return findMedian()
//                        int[] newArray = Arrays.copyOfRange(oldArray, startIndex, endIndex);
                    } else {
                        int[] new1 = Arrays.copyOfRange(nums1, midIndex1, nums1.length - 1);
                        int[] new2 = Arrays.copyOfRange(nums2, 0, midIndex2 - 1);
                        return  findMedian(new1, new2, isOdds);
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(3/2);
    }
}
