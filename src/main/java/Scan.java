import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

import java.util.List;

/**
 * 持续对 一个 list 的item 进行操作，累加
 */
public class Scan {
    public static void main(String[] strings) {
        List<Integer> integers = Global.getIntegerList(10);
        Observable.from(integers).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
