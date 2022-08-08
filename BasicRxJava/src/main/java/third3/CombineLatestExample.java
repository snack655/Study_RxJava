package third3;

import io.reactivex.rxjava3.core.Observable;
import third.CommonUtils;
import third.Log;

import java.util.concurrent.TimeUnit;

public class CombineLatestExample {
    public static void main(String[] args) {
        String[] data1 = { "6", "7", "8", "9" };
        String[] data2 = { "DIAMOND", "STAR", "PENTAGON" };

        Observable<String> source = Observable.combineLatest(
                Observable.fromArray(data1)
                        .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS),
                                (shape, notUsed) -> Shape.getColor(shape)),
                Observable.fromArray(data2)
                        .zipWith(Observable.interval(150L, 200L, TimeUnit.MILLISECONDS),
                                (shape, notUsed) -> Shape.getSuffix(shape)), (v1, v2) -> v1 +v2
        );

        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
    }
}
