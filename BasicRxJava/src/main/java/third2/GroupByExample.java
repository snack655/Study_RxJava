package third2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import third.CommonUtils;

public class GroupByExample {

    public static void main(String[] args) {
        String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
        Observable<GroupedObservable<String, String>> source =
                Observable.fromArray(objs).groupBy(CommonUtils::getShape);

        source.subscribe(obj -> {
            obj.subscribe(
                    val -> System.out.println("GROUP:" + obj.getKey() + "\t Value:" + val)
            );
        });
    }
}
