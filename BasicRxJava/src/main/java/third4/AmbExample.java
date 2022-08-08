package third4;

import io.reactivex.rxjava3.core.Observable;
import third.CommonUtils;
import third.Log;

import java.util.Arrays;
import java.util.List;

public class AmbExample {
    public static void main(String[] args) {
        String[] data1 = { "1", "3", "5" };
        String[] data2 = { "2-R", "4-R" };

        List<Observable<String>> sources = Arrays.asList(
                Observable.fromArray(data1)
                        .doOnComplete(() -> Log.d("Observable #1 : onComplete()")),
                Observable.fromArray(data2)
                        .doOnComplete(() -> Log.d("Observable #2 : onComplete()"))
        );

        Observable.amb(sources)
                .doOnComplete(() -> Log.d("Result : onComplete()"))
                .subscribe(Log::i);
        CommonUtils.sleep(1000);
    }
}
