package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;

import java.util.concurrent.TimeUnit;

public class ComputationSchedulerExample {
    public static void main(String[] args) {
        String[] orgs = { "1", "3", "5" };
        Observable<String> source = Observable.fromArray(orgs)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (a, b) -> a);

        // 구독(Subscription) #1
        source.map(item -> "<<" + item + ">>")
                .subscribeOn(Schedulers.computation())
                .subscribe(Log::i);

        // 구독 #2
        source.map(item -> "##" + item + "##")
                .subscribeOn(Schedulers.computation())
                .subscribe(Log::i);

        CommonUtils.sleep(1000);
    }
}
