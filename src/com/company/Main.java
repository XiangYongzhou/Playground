package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, -1, 2, 1, -1, -1, -1, 5, -1, -1, -1));
        List<Integer> action = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 3, 2, 3, 1, 3, 2, 2));
        MyQueue queue = new MyQueue();

        for (int i = 0; i < action.size(); i++) {
            int operation = action.get(i);
            if (operation == 1) { // enqueue
                queue.add(numbers.get(i));
            } else if (operation == 2) { // dequeue
                queue.remove();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
    }

    private static class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

    public void add(int x) {
    }

    public int remove() {
        return -1;
    }

    public int peek() {
        return -1;
    }

}
}
