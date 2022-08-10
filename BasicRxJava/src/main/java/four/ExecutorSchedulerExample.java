package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorSchedulerExample {
    public static void main(String[] args) {
        final int THREAD_NUM = 10;

        String[] data = { "1", "3", "5" };
        Observable<String> source = Observable.fromArray(data);
        Executor executor = Executors.newFixedThreadPool(THREAD_NUM);

        source.subscribeOn(Schedulers.from(executor))
                .subscribe(Log::i);

        source.subscribeOn(Schedulers.from(executor))
                .subscribe(Log::i);

        CommonUtils.sleep(500);

    }
}
