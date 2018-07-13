package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pagination {
    class Node {
        int data;
        Node next;
    }

    static String[] paginate(int num, String[] results) {
        /*
         * Write your code here.
         */
        HashMap<Integer, LinkedList<Integer>> uidMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> allId = new LinkedHashMap<>();
        for (int i = 0; i < results.length; i++) {
            String[] info = results[i].split(",");
            Integer uid = Integer.parseInt(info[0]);
            if (uidMap.containsKey(uid)) {
                LinkedList<Integer> listingIds = uidMap.get(uid);
                listingIds.add(i);
            } else {
                LinkedList<Integer> listingIds = new LinkedList<>();
                listingIds.add(i);
                uidMap.put(uid, listingIds);
            }
            allId.put(i, uid);
        }

        ArrayList<String> outputString = new ArrayList<>();
        int counter = 0;
        while (allId.size() > 0) {
            LinkedList<Integer> uids = new LinkedList<>(uidMap.keySet()) ;
            HashMap<Integer, Integer> lookupMap = new HashMap<>();
            List<Integer> indexList = new ArrayList<>();
            for (int uid:uids) {
                Integer index = uidMap.get(uid).peek();
                lookupMap.put(index, uid);
                indexList.add(index);
            }
            Collections.sort(indexList);
            int stopCondition = uids.size() < num ? uids.size():num;
            while (counter < stopCondition) {
                int uid = lookupMap.get(indexList.get(counter));
                LinkedList<Integer> listingIds = uidMap.get(uid);
                Integer index = listingIds.pop();
                outputString.add(results[index]);
                if (listingIds.size() == 0) {
                    uidMap.remove(uid);
                }
                allId.remove(index);
                counter++;
            }
            if (counter < num) {
                List<Integer> removeList = new ArrayList<>();
                for (Integer index:allId.keySet()) {
                    outputString.add(results[index]);
                    removeList.add(index);
                    counter++;
                    if (counter >= num) {
                        break;
                    }
                }
                for (Integer index:removeList) {
                    int uid = allId.get(index);
                    LinkedList<Integer> listingIds = uidMap.get(uid);
                    listingIds.pop();
                    if (listingIds.size() == 0) {
                        uidMap.remove(uid);
                    }
                    allId.remove(index);
                }
            }
            if (counter == num && allId.size() > 0) {
                outputString.add("");
            }
            counter = 0;
        }
        return outputString.toArray(new String[outputString.size()]);
    }

    HashSet<Integer> hashSet = new HashSet<>();
    boolean hasCycle(Node head) {
        do {
            if(hashSet.contains(head.hashCode())) {
                return true;
            } else {
                hashSet.add(head.hashCode());
            }
        } while(head.next != null);
        return false;
    }
    // Complete the makeAnagram function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magMap = new HashMap<>();
        HashMap<String, Integer> noteMap = new HashMap<>();
        for (String word:magazine) {
            if (magMap.containsKey(word)) {
                magMap.put(word, magMap.get(word) + 1);
            } else {
                magMap.put(word, 1);
            }
        }

        for (String word:note) {
            if (noteMap.containsKey(word)) {
                noteMap.put(word, noteMap.get(word) + 1);
            } else {
                noteMap.put(word, 1);
            }
        }

        for (String key:noteMap.keySet()) {
            if (magMap.get(key) == null || magMap.get(key) < noteMap.get(key)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<String> info = new ArrayList<>();
        info.add("1,28,300.6,San Francisco");
        info.add("4,5,209.1,San Francisco");
        info.add("20,7,203.4,Oakland");
        info.add("6,8,202.9,San Francisco");
        info.add("6,10,199.8,San Francisco");
        info.add("1,16,190.5,San Francisco");
        info.add("6,29,185.3,San Francisco");
        info.add("7,20,180.0,Oakland");
        info.add("6,21,162.2,San Francisco");
        info.add("2,18,161.7,San Jose");
        info.add("2,30,149.8,San Jose");
        info.add("3,76,146.7,San Francisco");
        info.add("2,14,141.8,San Jose");
        String[] sorted = paginate(5, info.toArray(new String[info.size()]));
        for (String sentence:sorted) {
            System.out.println(sentence);
        }

        scanner.close();
    }
}
