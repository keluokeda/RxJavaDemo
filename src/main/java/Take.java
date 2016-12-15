import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Take {
    public static void main(String[] strings) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();

    }

    private static void test7() {
        //取 前 n 条数据 直到 call 条件不成立
        Observable.from(Global.getIntegerList(10)).takeWhile(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer != 5;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void test6() {
        //取前 n条数据 直到 指定的observable 发射了数据
        Observable.from(Global.getIntegerList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).takeUntil(Observable.timer(2000, TimeUnit.MILLISECONDS))
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }

    private static void test5() {
        //取 前 n 条数据 直到条件成立
        Observable.from(Global.getIntegerList(10)).takeUntil(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer == 5;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void test1() {
        //只要 list 中的前n 个
        List<Integer> list = Global.getIntegerList(20);
        Observable.from(list).take(5).subscribe(System.out::println);
    }

    private static void test2() {
        //只要前 n 秒发射的数据
        Observable.range(0, 20, Schedulers.immediate()).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).take(2000, TimeUnit.MILLISECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }

    private static void test3() {
        //只要 list 中的 后 n 个
        List<Integer> list = Global.getIntegerList(20);
        Observable.from(list).takeLast(5).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });


    }

    private static void test4() {
        //只要后 n 秒发射的数据
        Observable.range(0, 20, Schedulers.immediate()).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).takeLast(2000, TimeUnit.MILLISECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });


    }
}
