import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Math {
    public static void main(String[] strings) {
//        test1();
        test2();
    }

    private static void test2() {
        //顺序连接两个observable
        Observable.from(Global.getIntegerList(10)).concatWith(Observable.just(100,1000,10000)).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void test1() {
        //统计 observable 发射的数据 的个数
        Observable.from(Global.getIntegerList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).count().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
