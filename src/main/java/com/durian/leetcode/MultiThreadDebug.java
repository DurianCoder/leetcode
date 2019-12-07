package com.durian.leetcode;

/**
 * @author ying.jiang
 * @define
 * @date 2019-12-07-16:47:00
 */
public class MultiThreadDebug {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread name:" + Thread.currentThread().getName());
        }, "Thread1").start();


        new Thread(() -> {
            System.out.println("Thread name:" + Thread.currentThread().getName());
        }, "Thread2").start();

        new Thread(() -> {
            System.out.println("Thread name:" + Thread.currentThread().getName());
        }, "Thread3").start();


        System.out.println("Thread name:" + Thread.currentThread().getName());
    }

}
