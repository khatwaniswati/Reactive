import io.reactivex.rxjava3.core.Observable;

public class ObservableError {
    public static void main(String[] args) {
        throwException();
        throwExceptionUsingCallable();
    }

    /**
     * This method uses Observable.error() to pass a new instance of exception directly
     * So their observers get the same exception instance everytime
     */
    private static void throwException() {
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

    /**
     * This method uses Observable.error() to pass a new Instance of Callable
     * which takes an Exception as it's return type through lambda
     * So their Observers gets a new instance of exception on onError() every time
     */
    private static void throwExceptionUsingCallable() {
        Observable observable = Observable.error(() -> {
            // We're printing this message to show that new instance gets created before
            // publishing the error to their Observers
            System.out.println("New Exception Created");
            return new Exception("An Exception");
        });
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }
}
