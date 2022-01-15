package com.oneclubs.step1;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Sample07 {

    public static void main(String[] args) throws InterruptedException {

        Flux.range(1, 100)
            .log()
            .map(i -> i*2)
            .subscribeOn(Schedulers.parallel())
            .subscribe(System.out::println);

        Thread.sleep(3 * 1000);
    }
}
