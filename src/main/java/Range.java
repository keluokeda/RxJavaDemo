import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 从指定位置开始 到发射指定数量的 item
 */
public class Range {
    public static void main(String[] s) {
        Observable.range(10,15).delay(1, TimeUnit.SECONDS, Schedulers.immediate()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
