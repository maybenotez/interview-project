package com.win.app.queue;

public class AppTest {


    public static void main(String[] args) {
        Queue<Integer> queue = new CustomerQueue<>();

        for (int i = 0; i < 100; i++) {
            queue.push(i);
        }
        System.out.println(queue);
        for (int i = 0; i < 100; i++) {
            System.out.println("index:" + queue.pop() + "result:" + queue.isEmpty());
        }
    }
}
