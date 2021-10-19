import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ExSingle {
    public static void main(String[] args) {
        // Single 생성
        Single<DayOfWeek> single = Single.create(emitter -> {
            emitter.onSuccess(LocalDate.now().getDayOfWeek());
        });

        // 구독
        single.subscribe(new SingleObserver<DayOfWeek>() {

            // 구독 준비가 됐을 때의 처리
            @Override
            public void onSubscribe(Disposable disposable) {
                // 아무것도 하지 않는다.
            }

            // 데이터를 통지 받았을 때의 처리
            @Override
            public void onSuccess(DayOfWeek value) {
                System.out.println(value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("에러=" + e);
            }
        });
    }
}
