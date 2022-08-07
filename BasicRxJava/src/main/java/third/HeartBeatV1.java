package third;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class HeartBeatV1 {
    public static void main(String[] args) {
        CommonUtils.exampleStart();
        String serverUrl = "https://api.github.com/zen";

        // 2초 간격으로 서버에 ping 보내기.
        Observable.timer(2, TimeUnit.SECONDS)
                .map(val -> serverUrl)
                .map(OkHttpHelper::get)
                .repeat()
                .subscribe(res -> Log.it("Ping Result : " + res));
        CommonUtils.sleep(10000);
    }
}
