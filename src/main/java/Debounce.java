import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 设置两次发送 item 的时间间隔
 */
public class Debounce {
    private static long currentTime;


    public static void main(String[] strings) {


        currentTime = System.currentTimeMillis();


        Observable.
                interval(300, TimeUnit.MILLISECONDS, Schedulers.immediate()).
                debounce(1000, TimeUnit.MILLISECONDS, Schedulers.immediate()).
                subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        long interval = System.currentTimeMillis() - currentTime;
                        currentTime = System.currentTimeMillis();
                        System.out.println("data = " + aLong + ". interval = " + interval);
                    }
                });
    }
}
