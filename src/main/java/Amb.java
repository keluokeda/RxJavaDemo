import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 如果有多个发射器 只选择最早的那个 发射 其余的丢弃
 */
public class Amb {
    public static void main(String[] strings) {
        Observable.amb(
                Observable.from(Global.getIntegerList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()),
                Observable.from(Global.getIntegerList(5)).delay(600, TimeUnit.MILLISECONDS, Schedulers.immediate()))
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }
}
