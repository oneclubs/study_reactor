package com.oneclubs.step2;

import java.util.Arrays;
import reactor.core.publisher.Flux;

public class Sample02 {

    public static void main(String[] args) {

        Flux.fromIterable(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10)
            ))
            .flatMap(Flux::fromIterable)
            .subscribe(System.out::println);
    }
}
