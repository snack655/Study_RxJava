package second;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.function.Predicate;

public class FilterExample {
    public static void main(String[] args) {
        Predicate<String> filterCircle = obj -> obj.endsWith("Circle");
        String[] objs = { "1 Circle", "2 Diamond", "3 Triangle", "4 Diamond", "5 Circle", "6 Hexagon" };
        Observable<String> ex = Observable.fromArray(objs)
                .filter(filterCircle::test);
        ex.subscribe(System.out::println);

        Integer[] numbers = { 100, 200, 300, 400, 500 };
        Single<Integer> single;
        Observable<Integer> source;

        // 1. first
        single = Observable.fromArray(numbers).first(-1);
        single.subscribe(data -> System.out.println("first() value = " + data));

        // 2. last
        single = Observable.fromArray(numbers).last(999);
        single.subscribe(data -> System.out.println("last() value = " + data));

        // 3. take(N)
        source = Observable.fromArray(numbers).take(3);
        source.subscribe(data -> System.out.println("take(3) values = " + data));

        // 4. takeLast(N)
        source = Observable.fromArray(numbers).takeLast(3);
        source.subscribe(data -> System.out.println("takeLast(3) values = " + data));

        // 5. skip(N)
        source = Observable.fromArray(numbers).skip(2);
        source.subscribe(data -> System.out.println("skip(2) values = " + data));

        // 6. skipLast(N)
        source = Observable.fromArray(numbers).skipLast(2);
        source.subscribe(data -> System.out.println("skipLast(2) values = " + data));

    }
}
