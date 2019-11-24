package edu.uniandes.arquitectura.servicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

public class ScheduledTasks {

    private static boolean needToRunStartupMethod = true;
    
    @Autowired
    public ScheduledTasks() {
        // TODO Auto-generated constructor stub
        System.out.println("init");
        System.out.println("init");
        System.out.println("init");
    }

    @Scheduled(fixedRate = 5000)
    public void keepAlive() {
        // log "alive" every hour for sanity checks
        System.out.println("alive");
        System.out.println("alive");
        System.out.println("alive");
        System.out.println("alive");
        System.out.println("alive");
        System.out.println("alive");
        if (needToRunStartupMethod) {
            runOnceOnlyOnStartup();
            needToRunStartupMethod = false;
        }
    }

    public void runOnceOnlyOnStartup() {
        System.out.println("running startup job");
        System.out.println("running startup job");
        System.out.println("running startup job");
        System.out.println("running startup job");
        System.out.println("running startup job");
        System.out.println("running startup job");
    }

}