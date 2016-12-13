import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Simple {
    private static long time;

    public static void main(String[] strings) {

        /**
         * 每隔 200ms 进行一次采样 ，并把采样的结果发送出去
         */
        Observable.range(1, 10, Schedulers.immediate()).delay(100, TimeUnit.MILLISECONDS, Schedulers.immediate()).
                sample(200, TimeUnit.MILLISECONDS).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                time = System.currentTimeMillis();
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                long interval = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                System.out.println("value = "+integer+", interval = "+interval);
            }
        });
//        value = 1, interval = 218
//        value = 3, interval = 193
//        value = 5, interval = 199
//        value = 7, interval = 202
//        value = 9, interval = 203
//        value = 10, interval = 141
    }
}
