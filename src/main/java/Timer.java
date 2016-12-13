import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Timer {

    public static void main(String[] strings) {
        /**
         * 定时器功能
         */
        Observable.timer(1000, TimeUnit.MILLISECONDS, Schedulers.immediate()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.println(aLong);
            }
        });
    }
}
