package four;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import third.CommonUtils;
import third.Log;

public class TrampolineSchedulerExample {
    public static void main(String[] args) {
        String[] orgs = { "1", "3", "5" };
        Observable<String> source = Observable.fromArray(orgs);

        // 구독 #1
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "<<" + data + ">>")
                .subscribe(Log::i);

        // 구독 #2
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "##" + data + "##")
                .subscribe(Log::i);

        CommonUtils.sleep(500);
    }
}
