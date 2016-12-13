import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.List;

/**
 * 过滤
 */
public class Filter {

    public static void main(String[] strings) {
        List<Integer> list=Global.getIntegerList(20);
        Observable.from(list).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer%3==0;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
