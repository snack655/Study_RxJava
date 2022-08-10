package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;

import java.io.File;

public class IOSchedulerExample {
    public static void main(String[] args) {
        String root = "/Users/choiminjae/";
        File[] files = new File(root).listFiles();

        Observable<String> source = Observable.fromArray(files)
                .filter(f -> !f.isDirectory())
                .map(f -> f.getAbsolutePath())
                .subscribeOn(Schedulers.io());

        source.subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
