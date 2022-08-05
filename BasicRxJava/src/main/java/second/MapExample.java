package second;

import io.reactivex.rxjava3.core.Observable;

public class MapExample {

    public static void main(String[] args) {
        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(ball -> ball + " ㅁ");
        source.subscribe(System.out::println);
    }
}
