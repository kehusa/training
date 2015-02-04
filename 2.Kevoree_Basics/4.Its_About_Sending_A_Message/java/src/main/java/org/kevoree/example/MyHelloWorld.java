package org.kevoree.example;

import org.kevoree.annotation.*;
import org.kevoree.api.Port;
import org.kevoree.log.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ComponentType
public class MyHelloWorld {

    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

    @Param(defaultValue = "Hello, world1!")
    private String greetMessage;

    @Output
    private Port hello;

    @Start
    public void start() {
        Log.info(greetMessage);
        Log.info("Doing some initial stuffing");

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                hello.send(greetMessage, null);
                Log.info("Doing some stuffing");
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    @Stop
    public void stop() {
        Log.info("Bye, world!");
        scheduledThreadPool.shutdown();
    }

    @Update
    public void update() {
        Log.info("Update: {}", greetMessage);
    }
}
