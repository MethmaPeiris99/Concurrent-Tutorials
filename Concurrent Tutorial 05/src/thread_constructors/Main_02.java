package thread_constructors;

import thread_constructors.MyThread_01;
import thread_constructors.MyThread_02;

public class Main_02 { //Demonstrate the use of different Thread constructors

    public static void main(String[] args) {
        //Thread() => Allocates a new Thread object
        Thread thread_one = new MyThread_01();
        thread_one.start(); //Thread Group two's parent => main

        //Thread(String name) => Allocates a new Thread object with a name
        Thread thread_two = new MyThread_01("Thread two"); //Thread Group two's parent => main
        thread_two.start();

        //Thread(ThreadGroup threadGroup, String name) => Allocates a new Thread objects which belongs to a thread group with a name
        ThreadGroup threadGroup_one = new ThreadGroup("Thread Group 01"); //Thread Group two's parent => Thread Group 01
        Thread thread_three = new MyThread_01(threadGroup_one, "Thread three");
        thread_three.start();

        //Thread(Runnable target) => Allocates a new Thread object that implements Runnable
        Runnable runnable_one = new MyThread_02();
        Thread thread_four = new Thread(runnable_one);
        thread_four.start();

        //Thread(Runnable target, String name) => Allocates a new Thread object that implements Runnable with a name
        Thread thread_five = new Thread(runnable_one, "Thread five");
        thread_five.start();

        //Thread(ThreadGroup threadGroup, Runnable target) => Allocates a new Thread object that implements Runnable
        //with a specified thread group
        Thread thread_six = new Thread(threadGroup_one, runnable_one);
        thread_six.start();

        //Thread(ThreadGroup threadGroup, Runnable target, String name) => Allocates a new Thread object that implements Runnable
        //with a specified thread group with a name
        Thread thread_seven = new Thread(threadGroup_one, runnable_one, "Thread seven");
        thread_seven.start();
    }
}
