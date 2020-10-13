package com.company;

public class TestBarrierVar1 {
    private BarrierVar1 barrier;
    public static int maxThreadCount = 5;

    public TestBarrierVar1(){
        barrier = new BarrierVar1(maxThreadCount);
    }

    public static void main(String[] args) {
        TestBarrierVar1 main = new TestBarrierVar1();

        for (int i = 0; i < maxThreadCount; i++) {
            new Thread(() -> main.run()).start();
        }
    }

    public void run(){
        foo();
        barrier.await();
        bar();
    }

    public void foo(){
        System.out.println("Start foo!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End foo!");
    }

    public void bar(){
        System.out.println("Start bar!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End bar!");
    }
}
