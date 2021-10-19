import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExCompositeDisposable {

    public static void main(String[] args) throws Exception {
        // Disposable을 합친다
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(Flowable.range(1, 3)
                .doOnCancel(() -> System.out.println("No.1 canceled"))
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    Thread.sleep(100L);
                    System.out.println("No.1: " + data);
                }));

        compositeDisposable.add(Flowable.range(1, 3)
                .doOnCancel(() -> System.out.println("No.2 canceled"))
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    Thread.sleep(100L);
                    System.out.println("No.2: " + data);
                }));

        // 잠시 기다린다
        Thread.sleep(150L);

        // 한 번에 구독을 해지한다
        compositeDisposable.dispose();
    }
}
