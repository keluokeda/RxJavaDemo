import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import rx.schedulers.Timestamped;

import java.util.concurrent.TimeUnit;

/**
 * 把 item 变成 带有时间标签 的 item
 */
public class TimeStamp {
    public static void main(String[] strings) {
        Observable.from(Global.getIntegerList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate())
                .timestamp().subscribe(new Observer<Timestamped<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onComplete");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Timestamped<Integer> integerTimestamped) {
                System.out.println("value = "+integerTimestamped.getValue()+" time = "+integerTimestamped.getTimestampMillis());
            }
        });
    }
}
