package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by xiangyongzhou on 18/6/21.
 */
public class IpConvertor {
    private static final long ERROR_FLAG = -1;
    public static void main(String[] args) {
        long result = convertIp(args[0]);
        if (result == ERROR_FLAG) {
            System.out.print("ERROR! non ipv4 format");
        } else {
            System.out.print(result);
        }
        //unit test
        testNonDigitChar();
        testOutOfBoundIp();
        testCorrectSpace();
        testWrongSpace();
        testIpTooLong();
        testIpTooShort();
    }

    private static long convertIp(String ip) {
        char[] ipChar = ip.toCharArray();
        int[] parsedInt = new int[4];
        int lengthCounter = 0;
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < ipChar.length; i++) {
            char c = ipChar[i];
            if ((c >='0' && c <= '9') || c == ' ' || c == '.') {
                if (c == ' ') {
                    if (i != ipChar.length - 1 && i != 0 && !(i + 1 <= ipChar.length - 1 && ipChar[i+1] == '.') & !(i - 1 >= 0 && ipChar[i-1] == '.')) {
                        return ERROR_FLAG;
                    }
                } else if(c == '.') {
                    if(temp.toString().isEmpty()) {
                        return ERROR_FLAG;
                    } else {
                        if (lengthCounter < 4) {
                            int block = Integer.parseInt(temp.toString());
                            if (block > 255 || block < 0) {
                                return ERROR_FLAG;
                            } else {
                                parsedInt[lengthCounter] = Integer.parseInt(temp.toString());
                            }
                            lengthCounter++;
                            temp = new StringBuilder();
                        } else {
                            return ERROR_FLAG;
                        }
                    }
                } else {
                    temp.append(c);
                }
            } else {
                return ERROR_FLAG;
            }
        }
        if (lengthCounter != 3 || temp.toString().isEmpty()) {
            return ERROR_FLAG;
        } else {
            int block = Integer.parseInt(temp.toString());
            if (block > 255 || block < 0) {
                return ERROR_FLAG;
            } else {
                parsedInt[lengthCounter] = Integer.parseInt(temp.toString());
            }
        }
        long result = 0;
        for (int i = 0; i < parsedInt.length; i++) {
            long power = 3 - i;
            result += parsedInt[i] * Math.pow(256, power);

        }
        return result;
    }

    @Test
    private static void testNonDigitChar() {
        long result = convertIp("17d.168.0.0");
        assertEquals(ERROR_FLAG, result);
    }

    @Test
    private static void testOutOfBoundIp() {
        long result = convertIp("999.168.0.0");
        assertEquals(ERROR_FLAG, result);
    }

    @Test
    private static void testCorrectSpace() {
        long result = convertIp("172. 168.5.1");
        assertEquals(2896692481L, result);
        long result2 = convertIp("172. 168.5.1 ");
        assertEquals(2896692481L, result2);
        long result3 = convertIp(" 172. 168.5.1 ");
        assertEquals(2896692481L, result3);
        long result4 = convertIp(" 172 . 168. 5 .1 ");
        assertEquals(2896692481L, result4);
    }

    @Test
    private static void testWrongSpace() {
        long result = convertIp("1 72. 168.5.1");
        assertEquals(ERROR_FLAG, result);
    }

    @Test
    private static void testIpTooLong() {
        long result = convertIp("172.168.5.1.1");
        assertEquals(ERROR_FLAG, result);
    }

    @Test
    private static void testIpTooShort() {
        long result = convertIp("172.168.5");
        assertEquals(ERROR_FLAG, result);
    }
}
