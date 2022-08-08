package third2;

import io.reactivex.rxjava3.core.Observable;
import third.CommonUtils;
import third.Log;

import java.util.concurrent.TimeUnit;

public class ConcatMapExample {
    public static void main(String[] args) {
        CommonUtils.exampleStart();

        String[] balls = { "1", "3", "5" };
        Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .concatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball + "<>")
                        .take(2)
                );
        source.subscribe(Log::it);
        CommonUtils.sleep(2000);

    }
}
