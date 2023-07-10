package org.zhl.dubbo.spring.boot.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.zhl.dubbo.spring.boot.demo.DemoService;

import java.util.Date;

/**
 * @author hailang.zhang
 * @since 2023-02-23
 */
@Component
public class Task implements CommandLineRunner {

    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        String hello = demoService.sayHello("Hello");
        System.out.println("Received result ====>" + hello);


        new Thread(() ->{
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + "Received result ====>" + demoService.sayHello("Hello"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}