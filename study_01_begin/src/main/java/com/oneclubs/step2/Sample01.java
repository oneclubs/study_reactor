package com.oneclubs.step2;

import reactor.core.publisher.Flux;

public class Sample01 {

    public static void main(String[] args) {

        Flux.just("a", "b", "c", "d")
            .map(String::toUpperCase)
            .subscribe(System.out::println);


    }
}
