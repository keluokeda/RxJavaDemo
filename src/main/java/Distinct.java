import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

public class Distinct {

    public static void main(String[] strings) {
        List<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
//        Observable.from(list)
//                .distinct()
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        System.out.println(integer);
//                    }
//                });
        /**
         * 过滤到相同的东西 可以指定 是否相同 规则
         */
        Observable.from(list)
                .distinct(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer%3;
            }
        })
                .subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });


    }
}
