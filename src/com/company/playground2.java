package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xiangyongzhou on 18/7/13.
 */
public class playground2 {
    static HashSet<String> seenSituation = new HashSet<>();

    static class Situation {
        int[][] value = new int[3][3];
        int blackI = -1;
        int blackJ = -1;
        public Situation(int[][] value) {
            this.value = value;
            for (int i=0; i < 3; i++) {
                for (int j=0; j < 3; j++) {
                    if (value[i][j] == -1) {
                        blackI = i;
                        blackJ = j;
                        break;
                    }
                }
            }
        }

        List<Situation> nextMove = new ArrayList<>();

        public void initializeSituation() {
            seenSituation.add(this.toString());
            //System.out.println(seenSituation.size());

            if (blackJ + 1 < 3) {
                int[][] newV = new int[3][3];
                for (int i=0; i < 3; i++) {
                    for (int j=0; j < 3; j++) {
                        newV[i][j] = value[i][j];
                    }
                }
                newV[blackI][blackJ + 1] = -1;
                newV[blackI][blackJ] = value[blackI][blackJ + 1];
                Situation newS = new Situation(newV);
                if (!seenSituation.contains(newS.toString())) {
                    seenSituation.add(newS.toString());
                    nextMove.add(newS);
                }
            }
            if (blackI + 1 < 3) {
                int[][] newV = new int[3][3];
                for (int i=0; i < 3; i++) {
                    for (int j=0; j < 3; j++) {
                        newV[i][j] = value[i][j];
                    }
                }
                newV[blackI + 1][blackJ] = -1;
                newV[blackI][blackJ] = value[blackI + 1][blackJ];
                Situation newS = new Situation(newV);
                if (!seenSituation.contains(newS.toString())) {
                    seenSituation.add(newS.toString());
                    nextMove.add(newS);
                }
            }
            if (blackI - 1 > -1) {
                int[][] newV = new int[3][3];
                for (int i=0; i < 3; i++) {
                    for (int j=0; j < 3; j++) {
                        newV[i][j] = value[i][j];
                    }
                }
                newV[blackI - 1][blackJ] = -1;
                newV[blackI][blackJ] = value[blackI - 1][blackJ];
                Situation newS = new Situation(newV);
                if (!seenSituation.contains(newS.toString())) {
                    seenSituation.add(newS.toString());
                    nextMove.add(newS);
                }
            }
            if (blackJ - 1 > -1) {
                int[][] newV = new int[3][3];
                for (int i=0; i < 3; i++) {
                    for (int j=0; j < 3; j++) {
                        newV[i][j] = value[i][j];
                    }
                }
                newV[blackI][blackJ - 1] = -1;
                newV[blackI][blackJ] = value[blackI][blackJ - 1];
                Situation newS = new Situation(newV);
                if (!seenSituation.contains(newS.toString())) {
                    seenSituation.add(newS.toString());
                    nextMove.add(newS);
                }
            }
        }

        public boolean checkCorrect() {
            initializeSituation();
            boolean isCorrect = true;
            for (int i=0; i < 3; i++) {
                int base = 3*i;
                for (int j=0; j < 3; j++) {
                    if (value[i][j] == base + j + 1 || (i==2 && j==2 && value[i][j] == -1)) {

                    } else {
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (isCorrect) {
                return true;
            } else {
                for (Situation nextSituation : nextMove) {
                    if(nextSituation.checkCorrect()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i=0; i < 3; i++) {
                for (int j=0; j < 3; j++) {
                    builder.append(value[i][j]);
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        int[][] initialSituation = new int[3][3];
        initialSituation[0][0] = 1;
        initialSituation[0][1] = 2;
        initialSituation[0][2] = 3;
        initialSituation[1][0] = 4;
        initialSituation[1][1] = 5;
        initialSituation[1][2] = 6;
        initialSituation[2][0] = 7;
        initialSituation[2][1] = -1;
        initialSituation[2][2] = 8;
        Situation initSituation = new Situation(initialSituation);
        boolean result = initSituation.checkCorrect();
        System.out.println(result);
    }
}
