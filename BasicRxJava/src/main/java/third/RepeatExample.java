package third;

import io.reactivex.rxjava3.core.Observable;

public class RepeatExample {
    public static void main(String[] args) {
        String[] balls = { "1", "3", "5" };
        Observable<String> source = Observable.fromArray(balls)
                .repeat(3);
        source.doOnComplete(() -> Log.d("onComplete"))
                .subscribe(Log::i);
    }
}
