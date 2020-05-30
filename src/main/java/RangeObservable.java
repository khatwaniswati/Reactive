import io.reactivex.rxjava3.core.Observable;

public class RangeObservable {
    public static void main(String[] args) {
//        Observable<Integer> observable = Observable.range(0, 10);
//        observable.subscribe(System.out::println);

        // it prints from start up to (start + count - 1)
        int start = 5, count = 2;
        Observable<Integer> observable = Observable.range(start, count);
        observable.subscribe(System.out::println);
    }
}
