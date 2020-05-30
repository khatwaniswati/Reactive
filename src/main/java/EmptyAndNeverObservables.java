import io.reactivex.rxjava3.core.Observable;

public class EmptyAndNeverObservables {
    public static void main(String[] args) {
        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    /**
     * Creates Observable using the factory method called empty()
     * Which doesn't emit any item to onNext() and only completes immediately
     * So, we get the callback on onComplete()
     */
    private static void createObservableUsingEmpty() {
        System.out.println("createObservableUsingEmpty");
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    /**
     * Creates Observable using the factory method called never()
     * Which doesn't emit any item and never completes
     * So, it's Observers are keep waiting until the thread is running
     * Observable.never() is primarily used for testing purposes
     */
    private static void createObservableUsingNever() {
        System.out.println("createObservableUsingNever");
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        // Pause the main thread for the hope that it will print something
        pause(3000);
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
