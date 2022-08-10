package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;
import third.OkHttpHelper;

import static four.HttpGetExample.*;

public class CallbackHeaven {

    public static void main(String[] args) {
        CommonUtils.exampleStart();
        Observable<String> source = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get)
                .concatWith(Observable.just(SECOND_URL)
                        .map(OkHttpHelper::get));
        source.subscribe(Log::it);
        CommonUtils.sleep(5000);
    }
}
