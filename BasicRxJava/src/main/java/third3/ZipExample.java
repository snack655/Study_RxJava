package third3;

import io.reactivex.rxjava3.core.Observable;
import third.Log;

import java.awt.*;

public class ZipExample {

    public static void main(String[] args) {
        String[] shapes = { "BALL", "PENTAGON", "STAR" };
        String[] coloredTriangles = { "2-T", "6-T", "4-T" };

        Observable<String> source = Observable.zip(
                Observable.fromArray(shapes).map(Shape::getSuffix),
                Observable.fromArray(coloredTriangles).map(Shape::getColor),
                (suffix, color) -> color + suffix
        );

        source.subscribe(Log::i);
    }
}
