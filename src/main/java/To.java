import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class To {
    public static void main(String[] strings) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1() {
        //item 组合成 list
        Observable.from(Global.getIntegerList(10)).map(integer -> "item " + integer).toList().subscribe(System.out::println);
    }

    private static void test2() {
        //item 组合成 map
        Observable.from(Global.getIntegerList(10)).toMap(String::valueOf).subscribe(System.out::println);
    }

    private static void test3(){
        //item 组合成 map  map 的value 是包含 item 的list
        Observable.from(Global.getIntegerList(10)).toMultimap(integer -> "item"+integer).subscribe(System.out::println);
    }

    private static void test4(){
        Observable.just(2,1,4,8,6).toSortedList().subscribe(System.out::println);
    }
}
