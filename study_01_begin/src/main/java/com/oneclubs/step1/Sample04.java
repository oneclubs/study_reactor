package com.oneclubs.step1;

import reactor.core.publisher.Flux;

public class Sample04 {

    public static void main(String[] args) {

        Flux.range(1, 10)
            .log()
            .map(i -> i * 2)
            .zipWith(
                Flux.range(1, 5),
                (v1, v2) -> "v1 : " + v1 + ", v2 : " + v2
            )
            .subscribe(System.out::println);
    }
}
