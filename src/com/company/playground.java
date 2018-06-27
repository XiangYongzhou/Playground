package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiangyongzhou on 17/8/1.
 */
public class playground {

    public static void main(String[] args) {
        // write your code here
        try {
            FileInputStream fstream = new FileInputStream("yourMesh.obj");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            PrintWriter writer = new PrintWriter("result.obj", "UTF-8");
            while ((strLine = br.readLine()) != null) {

            }
            br.close();
            writer.close();
        } catch (Exception e) {

        }
    }
}
