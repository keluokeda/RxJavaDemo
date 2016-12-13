import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Throttle {

    public static void main(String[] strings) {

        /**
         * 每隔 ＊秒 进行一次 采样 ，只取时间范围内的第一个
         */
        Observable.interval(1000, TimeUnit.MILLISECONDS,Schedulers.immediate()).throttleFirst(3000,TimeUnit.MILLISECONDS, Schedulers.immediate()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.println(aLong);
            }
        });
    }
}
