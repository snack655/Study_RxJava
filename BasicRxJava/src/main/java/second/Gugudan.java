package second;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

import java.util.Scanner;

// 구구단 프로그램
public class Gugudan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("GUgudan Input: ");
        int dan = Integer.parseInt(in.nextLine());

        Function<Integer, Observable<String>> gugudan = num ->
                Observable.range(1, 9).map(row -> num + " * " + row + " = " + dan*row);

        Observable<String> source = Observable.just(dan).flatMap(gugudan);
        source.subscribe(System.out::println);

        in.close();
    }
}
