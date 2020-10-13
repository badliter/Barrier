package com.company;

public class BarrierVar1 {
    private final int maxThreadCount;
    private int currentThreadCount;

    public BarrierVar1(int maxThreadCount){
        this.maxThreadCount = maxThreadCount;
        this.currentThreadCount = 0;
    }

    public void await(){
        synchronized(this){
            currentThreadCount++;
            while (currentThreadCount != maxThreadCount){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notifyAll();
        }
    }
}
