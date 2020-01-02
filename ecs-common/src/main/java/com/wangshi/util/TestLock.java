package com.wangshi.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 一、用于解决多线程安全问题的方式：
 * synchronized:隐式锁
 * 1、同步代码块
 * 2、同步方法
 * jdk 1.5后
 * 3、同步锁 Lock
 * 注意：是一个显式锁，通过lock()方式上锁，必须通过unlock()方法释放锁
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}

class Ticket implements Runnable {
    private int tick = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tick > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票为：" + --tick);
                } else {
                    break;
                }
            } finally {
                lock.unlock();//释放锁一定要放在finally里，保证一定执行
            }
        }
    }

}