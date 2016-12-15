import rx.Notification;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Do {
    public static void main(String[] strings) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        test8();
    }

    private static void test1() {
        //发射 item 之后 被使用之前 调用
        Observable.from(Global.getIntegerList(10)).doOnEach(notification -> System.out.println("do on each " + notification.getValue())).subscribe(System.out::println);
    }

    private static void test2() {
        //发射 item 之后 被使用之前 调用

        Observable.from(Global.getIntegerList(10)).doOnEach(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("do on each " + integer);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("subscribe on each " + integer);
            }
        });
    }

    private static void test3() {
        Observable.from(Global.getIntegerList(10)).doOnNext(integer -> {
            System.out.println("do on next value = " + integer);
        }).subscribe(integer -> System.out.println("final value = " + integer));
    }

    private static void test4() {
        Observable
                .from(Global.getIntegerList(10))
                .doOnSubscribe(() -> System.out.println("do on subscribe"))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("subscribe on each " + integer);
                    }
                });
    }

    private static void test5() {

        Subscription subscription;

        subscription = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .doOnUnsubscribe(() -> System.out.println("do on unSubscribe"))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println(aLong);
                    }
                });
        Observable.timer(5000, TimeUnit.MILLISECONDS, Schedulers.immediate()).subscribe(aLong ->
        {
            System.out.println("time over");
            subscription.unsubscribe();
        });
    }


    private static void test6() {
        Observable
                .from(Global.getIntegerList(10)).delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate())
                .doOnCompleted(() -> System.out.println("do on complete"))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }

    private static void test7() {
        Observable
                .from(Global.getIntegerList(10))
                .map(integer -> {
                    if (integer == 1) {
                        throw new RuntimeException("integer error");
                    }
                    return integer;
                })
                .doOnError(throwable -> System.out.println("do on error " + throwable.getMessage()))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }

    private static void test8() {
        //结束之前 被调用 不管是正常结束 还是 错误结束
        Observable
                .from(Global.getIntegerList(10))
                .doOnTerminate(() -> System.out.println("do on terminate"))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }


}
