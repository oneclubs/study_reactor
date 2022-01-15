package com.oneclubs.step1;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class Sample03 {

    public static void main(String[] args) {

        Flux.range(1, 10)
            .log()
            .subscribe(new Subscriber<>() {
                Subscription s;
                int onNextAmount;

                @Override
                public void onSubscribe(Subscription s) {
                    this.s = s;
                    s.request(2);
                }

                @Override
                public void onNext(Integer integer) {
                    System.out.println("Subscribe onNext : " + integer);
                    onNextAmount ++;
                    if (onNextAmount % 2 == 0) {
                        s.request(2);
                    }
                }

                @Override
                public void onError(Throwable t) {}

                @Override
                public void onComplete() {}
            });
    }
}
