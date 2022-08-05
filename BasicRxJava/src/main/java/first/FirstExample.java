package first;

import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Future;

public class FirstExample {

    public void emit() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit();

        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(1000);
            return "Hello future";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(System.out::println);

        Publisher<String> publisher = (Subscriber<? super String> s) -> {
            s.onNext("Hello Observable.fromPublisher()");
            s.onComplete();
        };

        Observable<String> source2 = Observable.fromPublisher(publisher);
        source2.subscribe(System.out::println);
    }
}
