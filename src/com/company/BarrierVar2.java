package com.company;

import java.util.ArrayList;
import java.util.List;

public class BarrierVar2 {
    private List<Integer> b;
    private int currentThreadCount;
    private final int maxThreadCount;

    public BarrierVar2(int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
        currentThreadCount = 0;
        b = new ArrayList<>();
        for (int i = 0; i < maxThreadCount; i++) {
            b.add(0);
        }
    }

    public void await() {
        synchronized (this) {
            int currentThread = currentThreadCount;
            currentThreadCount++;
            if (currentThread + 1 == maxThreadCount) {
                for (int i = 0; i < b.size(); i++) {
                     b.set(i, 2);
                }
            } else {
                b.set(currentThread, 1);
                while (b.get(currentThread + 1) != 2) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.notifyAll();
        }
    }
}
