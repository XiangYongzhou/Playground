package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiangyongzhou on 17/7/31.
 */
public class WaterBlock {
    public static void main(String[] args) {
        // write your code here
        List<Integer> x = new ArrayList<>(Arrays.asList(3,5,2,1,4,6,2,5,3,4,1));
        getSum(x);
    }

    private static int getSum(List<Integer> x) {
        int[] leftMax = new int[x.size()];
        int[] rightMax = new int[x.size()];
        int currentMax = 0;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) > currentMax) {
                currentMax = x.get(i);
            }
            leftMax[i] = currentMax;
        }
        System.out.println("");
        currentMax = 0;
        for (int i = x.size() - 1; i >=0; i--) {
            if (x.get(i) > currentMax) {
                currentMax = x.get(i);
            }
            rightMax[i] = currentMax;
        }
        int result = 0;
        for (int i = 0; i < x.size(); i++) {
            if (leftMax[i] > x.get(i) && rightMax[i] > x.get(i)) {
                result += (leftMax[i] > rightMax[i]? (rightMax[i] - x.get(i)):(leftMax[i]) - x.get(i));
            }
        }
        System.out.println(result);
        return result;
    }
}
