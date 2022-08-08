package third4;

import io.reactivex.rxjava3.core.Observable;
import third.CommonUtils;
import third.Log;

import java.util.concurrent.TimeUnit;

public class SkipUntilExample {
    public static void main(String[] args) {
        String[] data = { "1", "2", "3", "4", "5", "6" };

        Observable<String> source = Observable.fromArray(data)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (val, notUsed) -> val)
                .skipUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));

        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
    }
}
