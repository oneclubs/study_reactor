package com.oneclubs.step3;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

public class Sample02 {

    public static void main(String[] args) {

        new Fibonacci(100)
            .generate()
            .subscribe(System.out::println);
    }

    record Fibonacci(int limit) {

        public Flux<Integer> generate() {

            return Flux.generate(
                () -> Tuples.of(1, 1),
                (state, sink) -> {
                    Integer left = state.getT1();
                    Integer right = state.getT2();
                    if (right > limit) {
                        sink.complete();
                    }

                    sink.next(right);
                    return Tuples.of(right, left + right);
                }
            );
        }
    }
}
