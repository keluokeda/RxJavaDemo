import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 必需两个 都发射了数据才会压缩
 */
public class Zip {
    private static long time;

    public static void main(String[] strings) {
        Observable.zip(
                Observable.from(Global.getList(10)).delay(400, TimeUnit.MILLISECONDS, Schedulers.immediate()),
                Observable.from(Global.getList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()),
                new Func2<String, String, String>() {
                    @Override
                    public String call(String s, String s2) {
                        return s+s2;
                    }
                }
        ).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                long interval = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                System.out.println("result = "+s+" , interval = "+interval);
            }
        });
    }
}
