package edu.uniandes.arquitectura.servicios.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    
    private final AtomicInteger counter;
    
    public Counter() {
        counter = new AtomicInteger(0);
    }
    
    public Counter(int initialValue) {
        counter = new AtomicInteger(initialValue);
    }
    
    public int add() {
        return counter.incrementAndGet();
    }
    
    public int add(int value) {
        return counter.addAndGet(value);
    }
    
    public int subtract() {
        return counter.decrementAndGet();
    }
    
    public int subtract(int value) {
        return counter.addAndGet(value * -1);
    }
    
    public int get() {
        return counter.get();
    }
}