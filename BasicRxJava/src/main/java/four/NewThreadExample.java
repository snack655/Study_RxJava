package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;

public class NewThreadExample {
    public static void main(String[] args) {
        String[] orgs = {"1", "3", "5"};
        Observable.fromArray(orgs)
                .doOnNext(data -> Log.v("Original data : " + data))
                .map(data -> "<<" + data + ">>")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);

        CommonUtils.sleep(500);

        Observable.fromArray(orgs)
                .doOnNext(data -> Log.v("Original data : " + data))
                .map(data -> "##" + data + "##")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);

        CommonUtils.sleep(500);
    }
}
