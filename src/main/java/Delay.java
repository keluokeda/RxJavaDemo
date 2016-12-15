import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Delay {
    private static long time;

    public static void main(String[] strings) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        //在 订阅者 接受每个 item 之前进行延迟
        time = System.currentTimeMillis();
        Observable.from(Global.getIntegerList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).doOnSubscribe(() -> {
            long interval = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            System.out.println(interval);
        }).subscribe(integer -> {
            long interval = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            System.out.println(interval);
        });
    }

    private static void test2() {
        //在被观察者 发送所有数据的时候进行延迟
        time = System.currentTimeMillis();
        Observable.from(Global.getIntegerList(10)).delaySubscription(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).doOnSubscribe(() -> {
            long interval = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            System.out.println(interval);
        }).subscribe(integer -> {
            long interval = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            System.out.println(interval);
        });
    }

    private static void test3() {
        Observable.from(Global.getIntegerList(20)).delay(integer -> Observable.just(integer * integer)).subscribe(System.out::println);
    }
}
