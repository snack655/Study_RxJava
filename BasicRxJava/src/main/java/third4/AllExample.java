package third4;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import third.Log;
import third3.Shape;

public class AllExample {
    public static void main(String[] args) {
        String[] data = { "1", "2", "3", "4" };

        Single<Boolean> source = Observable.fromArray(data)
                .map(Shape::getShape)
                .all(Shape.BALL::equals);

        source.subscribe(Log::it);
    }
}
