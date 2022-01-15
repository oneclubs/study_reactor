package com.oneclubs.step3;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

public class Sample01 {

    public static void main(String[] args) {

        generateFibonacciWithTuples()
//            .log()
            .subscribe(new BaseSubscriber<>() {


                @Override
                protected void hookOnSubscribe(Subscription subscription) {
                    subscription.request(10);
                }

                @Override
                protected void hookOnNext(Integer value) {
                    System.out.println(value);
                }
            });
    }

    static Flux<Integer> generateFibonacciWithTuples() {
        return Flux.generate(
            () -> Tuples.of(1, 1),
            (state, sink) -> {
                sink.next(state.getT1());
                return Tuples.of(
                    state.getT2(),
                    state.getT1() + state.getT2()
                );
            }
        );
    }
}
