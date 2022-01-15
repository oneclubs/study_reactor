package com.oneclubs.step1;

import java.time.Duration;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class Sample06 {

    public static void main(String[] args) {

        ConnectableFlux<Object> publisher = Flux.create(fluxSink -> {
                while (true) {
                    fluxSink.next(System.currentTimeMillis());
                }
            })
            .sample(Duration.ofSeconds(2))
            .log()
            .publish();

        publisher.subscribe(value -> System.out.println(Thread.currentThread().getName() + " : " + value));

        publisher.connect();
    }
}
