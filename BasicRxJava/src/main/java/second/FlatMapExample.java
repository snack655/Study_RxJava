package second;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class FlatMapExample {

    public static void main(String[] args) {
        Function<String, Observable<String>> getDoubleDiamonds =
                ball -> Observable.just(ball + "ㅅ", ball + "ㅁ");
        String[] balls = { "1", "2", "5" };

        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds);

        source.subscribe(System.out::println);

        Observable<String> source2 = Observable.fromArray(balls)
                .flatMap(ball -> Observable.just(ball + "<>", ball + "<>"));
    }
}
