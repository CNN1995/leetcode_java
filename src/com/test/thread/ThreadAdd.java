package com.test.thread;

import java.lang.*;
public class ThreadAdd {
    public static Object lock = new Object();
    public  static int sum = 0;
    public static  void main(String args[]) throws  InterruptedException
    {
        ThreadAdd add = new ThreadAdd();
        ThreadTest a = add.new ThreadTest(0,25);
        ThreadTest b = add.new ThreadTest(26,50);
        ThreadTest c = add.new ThreadTest(51,75);
        ThreadTest d = add.new ThreadTest(76,100);
        a.start();
        b.start();
        c.start();
        d.start();
        a.join();
        b.join();
        c.join();
        d.join();
        System.out.print("result: sum = " + sum);
    }


    public class ThreadTest extends Thread {
        private  int begin;
        private  int end;

        public ThreadTest(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        @Override
        public void run(){
            synchronized (lock){
                for(int i = begin; i <= end; i++){
                    sum+=i;
                }
                System.out.println("from " + begin + " to " + end);
            }

        }
    }

}
