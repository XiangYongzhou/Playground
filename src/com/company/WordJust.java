package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangyongzhou on 18/7/12.
 */
public class WordJust {
    static class Solution {
         List<String> fullJustify(String[] words, int maxWidth) {
            int counter = 0;
            int wordLength = 0;
            int wordCount = 0;
            List<String> returnList = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            for (String word:words) {
                if (counter + word.length() <= maxWidth) {
                    temp.add(word);
                    wordCount++;
                    wordLength += word.length();
                    counter += word.length() + 1;
                } else {
                    int totalSpace = maxWidth - wordLength;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (wordCount > 1) {
                        int spaceBase = totalSpace / (wordCount - 1);
                        int spaceReminder = totalSpace % (wordCount - 1);
                        int counter2 = 0;
                        for (String singleWord : temp) {
                            counter2++;
                            stringBuilder.append(singleWord);
                            int spaceAdd = spaceBase;
                            if (counter2 < wordCount) {
                                if (spaceReminder > 0) {
                                    spaceAdd++;
                                    spaceReminder--;
                                }
                                for (int i = 0; i < spaceAdd; i++) {
                                    stringBuilder.append(" ");
                                }
                            }
                        }
                    } else {
                        stringBuilder.append(temp.get(0));
                        for (int i = 0; i < totalSpace; i++) {
                            stringBuilder.append(" ");
                        }
                    }
                    returnList.add(stringBuilder.toString());

                    wordCount = 1;
                    wordLength = word.length();
                    counter = word.length() + 1;
                    temp = new ArrayList<>();
                    temp.add(word);
                }
            }
            StringBuilder lastBuilder = new StringBuilder();
            counter = 0;
            for (String word:temp) {
                lastBuilder.append(word);
                counter += word.length();
                if(counter < maxWidth) {
                    lastBuilder.append(" ");
                    counter++;
                }
            }
            for (int i = counter; i < maxWidth; i++) {
                lastBuilder.append(" ");
            }
            returnList.add(lastBuilder.toString());
            return returnList;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        solution.fullJustify(words, 16);
    }
}
