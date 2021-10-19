import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ExMaybe {
    public static void main(String[] args) {
        // Maybe 생성
        Maybe<DayOfWeek> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(LocalDate.now().getDayOfWeek());
        });

        // 구독
        maybe.subscribe(new MaybeObserver<DayOfWeek>() {

            // 구독 준비가 됐을 때의 처리
            @Override
            public void onSubscribe(Disposable disposable) {
                // 아무것도 하지 않는다.
            }

            // 데이터 통지를 받을 때의 처리
            @Override
            public void onSuccess(DayOfWeek value) {
                System.out.println(value);
            }

            // 에러 통지를 받을 때의 처리
            @Override
            public void onError(Throwable e) {
                System.out.println("에러=" + e);
            }

            // 완료 통지를 받을 때의 처리
            @Override
            public void onComplete() {
                System.out.println("완료");
            }
        });
    }
}
