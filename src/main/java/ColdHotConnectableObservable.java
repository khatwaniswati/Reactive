import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class ColdHotConnectableObservable {
    public static void main(String[] args) {
        createColdObservable();
        createHotAndConnectableObservable();
    }

    private static void createHotAndConnectableObservable() {
        System.out.println("createHotAndConnectableObservable");
        ConnectableObservable<Integer> observable = Observable.just(1,2,3,4).publish();
        observable.subscribe(item-> System.out.println("Observable 1:"+item));
        //Connectable Observable starts it's emission when we call connect on it
        observable.connect();
        observable.subscribe(item-> System.out.println("Observable 2:"+item));
    }

    private static void createColdObservable() {
        System.out.println("createColdObservable");
        Observable<Integer> observable = Observable.just(1,2,3,4);
        observable.subscribe(item -> System.out.println("Observable 1: "+item));
        pause(1000);
        observable.subscribe(item-> System.out.println("Observable 2: "+item));
    }

    /**
     * This method sleep the main thread for specified duration
     *
     * @param duration Sleep Duration in Milliseconds
     */
    private static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
