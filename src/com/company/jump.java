package com.company;

import java.io.IOException;
import java.util.List;

/**
 * Created by xiangyongzhou on 18/7/10.
 */
public class jump {
    public static int jump(int[] nums) {
        int counter = 0;
        int lengthGain = 0;
        while(lengthGain + 1 < nums.length) {
            int currentView = nums[lengthGain];
            if (lengthGain + currentView + 1 > nums.length) {
                counter++;
                break;
            }
            int currentMax = 0;
            int maxIndex = 0;
            for (int i = 1; i <= currentView; i++) {
                if (i+lengthGain < nums.length) {
                    if (currentMax < nums[i+lengthGain] + i) {
                        currentMax = nums[i+lengthGain] + i;
                        maxIndex = i;
                    }
                }
            }
            lengthGain += maxIndex;
            counter++;
        }
        System.out.println(counter);
        return counter;
    }

    public static void main(String[] args) throws IOException {

        int[] i =  {3,2,1};
        jump(i);
    }
}
