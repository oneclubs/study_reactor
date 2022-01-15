package com.oneclubs.step1;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Sample01 {

    public static void main(String[] args) {

        Flux.just("foo", "bar", "foobar")
            .subscribe(System.out::println);

        Mono.just("1")
            .subscribe(System.out::println);
    }
}
