package com.oneclubs.step1;

import reactor.core.publisher.Flux;

public class Sample02 {

    public static void main(String[] args) {

        Flux.range(1, 10)
            .log()
            .subscribe(
                value -> System.out.println("Subscribe : " + value),
                e -> {},
                () -> System.out.println("on Complete")
            );
    }
}
