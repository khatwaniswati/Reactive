import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableExample {

    public static void main(String[] args) {

        // Observable.just(1,2,3,5).subscribe(System.out::println);

        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(item-> System.out.println(item));
    }

    private static void createObservableFromIterable() {
        List<Integer> lst = Arrays.asList(1,2,3,4,5);
        Observable<Integer> observable = Observable.fromIterable(lst);
        observable.subscribe(item -> System.out.println(item));
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(emitter -> {
        emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(null);
            emitter.onComplete();
        });
        observable.subscribe(item-> System.out.println(item),error-> System.out.println(error.getMessage()),()-> System.out.println("Completed"));
    }

}
