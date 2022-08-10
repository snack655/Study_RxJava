package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;

public class SingleSchedulerExample {
    public static void main(String[] args) {
        Observable<Integer> numbers = Observable.range(100, 5);
        Observable<String> chars = Observable.range(0, 5)
                .map(CommonUtils::numberToAlphabet);


        numbers.subscribeOn(Schedulers.single())
                .subscribe(Log::i);

        chars.subscribeOn(Schedulers.single())
                .subscribe(Log::i);

        CommonUtils.sleep(500);
    }
}
