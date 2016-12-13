import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Interval {
    public static void main(String[] a) {
        List<String> strings = Global.getList(50);


        //一直发
        Observable.interval(1, TimeUnit.SECONDS, Schedulers.immediate()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.print(aLong);
            }
        });
    }
}
