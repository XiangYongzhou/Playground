package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangyongzhou on 17/8/1.
 */
public class playground {

    static class SolutionTemp {
        public List<String> covertIpToCider(String ip, int length) {
            List<String> ipSet = new ArrayList<>();
            String[] ipInfo = ip.split(".");
            int lastDigit = Integer.parseInt(ipInfo[3]);
            int temp = lastDigit;
            int counter = 0;
            int factorCounter = 0;
            if (temp == 0) {
                while (counter + Math.pow(2, factorCounter) < length) {
                    factorCounter++;
                }
                factorCounter--;
                counter += Math.pow(2, factorCounter);
                int digitInfo = 32 - factorCounter;
                String outputString = ipInfo[0] + "." + ipInfo[1] + "." + ipInfo[2] + "." + lastDigit + "/" + digitInfo;
                lastDigit += Math.pow(2, factorCounter);
                temp = lastDigit;
                ipSet.add(outputString);
            }

            for (; counter < length;) {
                factorCounter = 0;
                while (temp % 2 == 0) {
                    temp = temp / 2;
                    factorCounter++;
                }
                counter += Math.pow(2, factorCounter);
                int digitInfo = 32 - factorCounter;
                if (counter > length) {
                    break;
                }
                String outputString = ipInfo[0] + "." + ipInfo[1] + "." + ipInfo[2] + "." + lastDigit + "/" + digitInfo;
                lastDigit += Math.pow(2, factorCounter);
                temp = lastDigit;
                ipSet.add(outputString);
            }
            if (counter > length) {
                counter = counter - (int) Math.pow(2, factorCounter);
                while (counter < length) {
                    if (counter + Math.pow(2, factorCounter) > length) {
                        factorCounter--;
                    } else {
                        counter += Math.pow(2, factorCounter);
                        int digitInfo = 32 - factorCounter;
                        if (counter > length) {
                            break;
                        }
                        String outputString = ipInfo[0] + "." + ipInfo[1] + "." + ipInfo[2] + "." + lastDigit + "/" + digitInfo;
                        lastDigit += Math.pow(2, factorCounter);
                        ipSet.add(outputString);
                    }
                }
            }

            return ipSet;
        }
    }

    public static void main(String[] args) {
        // write your code here
        SolutionTemp solution = new SolutionTemp();
        String ip = "255,12,0,0";
        int length = 13;
        List<String> outputs = solution.covertIpToCider(ip, length);
        for (String output:outputs) {
            System.out.println(output);
        }
    }
}
