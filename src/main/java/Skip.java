import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Skip {

    public static void main(String[] strings) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1(){
        //跳过 list 中 前 n 个 item
        List<Integer> list=Global.getIntegerList(20);
        Observable.from(list).skip(10).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void test2(){
        //跳过 前 n 秒发射的数据
        List<Integer> list=Global.getIntegerList(20);
        Observable.from(list).delay(1000,TimeUnit.MILLISECONDS, Schedulers.immediate()).skip(3000,TimeUnit.MILLISECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void test3(){
        //跳过 list 中  后 n 个 item
        List<Integer> list=Global.getIntegerList(20);
        Observable.from(list).skipLast(10).subscribe(new Observer<Integer>() {
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

    private static void test4(){
        //跳过 前 n 秒发射的数据 跳过后直接执行 onComplete
        List<Integer> list=Global.getIntegerList(20);
        Observable.from(list).delay(1000,TimeUnit.MILLISECONDS, Schedulers.immediate()).skipLast(3000,TimeUnit.MILLISECONDS).subscribe(new Observer<Integer>() {
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
