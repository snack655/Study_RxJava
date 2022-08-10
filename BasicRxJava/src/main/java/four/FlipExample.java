package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;
import third3.Shape;

public class FlipExample {
    public static void main(String[] args) {
        String[] objs = { "1-S", "2-T", "3-P" };

        Observable<String> source = Observable.fromArray(objs)
                .doOnNext(data -> Log.v("Original data = " + data))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .map(Shape::flip);

        source.subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
