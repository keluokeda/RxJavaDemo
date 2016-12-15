import rx.Observable;
import rx.functions.Action1;

public class Empty {
    public static void main(String[] strings){
//        test1();
        test2();
    }

    private static void test2() {
        //判断是否是空 如果是空就发射指定的 item
        Observable.empty().defaultIfEmpty("hello").subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                System.out.println(o);
            }
        });
    }

    private static void test1() {
        //判定是不是 空的  源
        Observable.empty().isEmpty().subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                System.out.println(aBoolean);
            }
        });
    }

}
