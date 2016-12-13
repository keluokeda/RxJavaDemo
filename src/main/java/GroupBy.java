import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数据分组
 */
public class GroupBy {
    public static void main(String[] strings) {
        List<Integer> integers = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        Observable.from(integers).groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer % 3;
            }
        }).subscribe(new Action1<GroupedObservable<Integer, Integer>>() {
            @Override
            public void call(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                integerIntegerGroupedObservable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("key=" + integerIntegerGroupedObservable.getKey() + ",value =" + integer);
                    }
                });
            }
        });

    }
}
