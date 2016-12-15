import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CombineLatest {

    protected static long time;

    private static long time1;

    public static void main(String[] strings) {
        Observable.combineLatest(Observable.range(10, 20, Schedulers.immediate()).delay(400, TimeUnit.MILLISECONDS, Schedulers.immediate()),
                Observable.range(100, 20, Schedulers.immediate()).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()), (integer, integer2) -> {
                    long currentTime = System.currentTimeMillis();
                    long interval = currentTime - time;
                    time = currentTime;
                    System.out.println("combine interval = " + interval);
                    return integer + integer2;
                }).subscribe(integer -> {
            long currentTime = System.currentTimeMillis();
            long interval = currentTime - time1;
            time1 = currentTime;
            System.out.println("interval = " + interval + ", result =" + integer);
        });
    }
}
