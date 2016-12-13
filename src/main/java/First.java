import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.List;

/**
 * 从 list 中 找到第一个符合条件的
 */
public class First {

    public static void main(String[] strings) {
        List<Integer> integers = Global.getIntegerList(50);
        Observable.from(integers).first(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer != 0 && integer % 5 == 0;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
