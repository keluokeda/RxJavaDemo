import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 合并
 */
public class Merge {

    public static void main(String[] strings) {
        Observable.merge(Observable.from(Global.getIntegerList(20)).delay(1000, TimeUnit.MILLISECONDS, Schedulers.immediate()), Observable.just(100,1001,1002)).subscribe(System.out::println);
    }
}
