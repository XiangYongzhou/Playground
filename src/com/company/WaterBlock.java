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
        int sum = getSum(x);
        int i= 1;
    }

    private static int getSum(List<Integer> x) {
        int sum = 0;
        for (int i=1; i<x.size();i++){
            if ((x.get(i) < x.get(i+1)) && (x.get(i) < x.get(i-1))) {
                //find the lowest pos,
                int left = i;
                int maxLeft = x.get(i);
                while (left-1 > 0) {
                    if (x.get(left) < x.get(left-1)) {
                        if (maxLeft < x.get(left)) {
                            maxLeft = x.get(left);
                        }
                        left--;
                    }
                    else {
                        break;
                    }
                }
                int right = i;
                int maxRight = x.get(i);
                while (right < x.size()) {
                    if (x.get(right) < x.get(right+1)) {
                        if (maxRight < x.get(right)) {
                            maxRight = x.get(right);
                        }
                        right++;
                    }
                    else {
                        break;
                    }
                }
                int max = maxLeft;
                if (maxLeft > maxRight) {
                    max = maxRight;
                }

                for (int k = maxLeft + 1; k < maxRight; k++) {
                    sum += (max - x.get(k));
                }

                i = maxRight ;
            }
        }


        return sum;
    }
}
