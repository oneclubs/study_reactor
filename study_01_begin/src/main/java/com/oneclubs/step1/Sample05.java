package com.oneclubs.step1;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class Sample05 {

    public static void main(String[] args) {

        // hot stream
        ConnectableFlux<Object> publisher = Flux.create(fluxSink -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fluxSink.next("Sink : " + i);
                }
            })
            .log()
            .publish();

        publisher.subscribe(s -> System.out.println("Subscriber1 : " + s));
        publisher.subscribe(s -> System.out.println("Subscriber2 : " + s));

        publisher.connect();
    }
}
