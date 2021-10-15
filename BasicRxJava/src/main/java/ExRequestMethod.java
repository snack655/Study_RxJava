import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ExRequestMethod {

    public static void main(String[] args) {
        Flowable
                // 인자 데이터를 통지한다.
                .just(1, 2, 3)
                // 구독한다.
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("onSubscribe START");
                        subscription.request(Long.MAX_VALUE);
                        System.out.println("onSubscribe END");
                    }

                    @Override
                    public void onNext(Integer data) {
                        System.out.println(data);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("에러=" + error);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("완료");
                    }
                });
    }

}
