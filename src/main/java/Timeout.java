import rx.Observable;
import rx.Observer;


import java.util.concurrent.TimeUnit;

public class Timeout {
    public static void main(String[] strings) {
//       test1();
        test2();
    }

    private static void test1() {
        //超过指定 时长没发射 item  就 发送一个 TimeoutException 结束
        Observable.from(Global.getIntegerList(10)).map(integer -> {

            long interval;
            if (integer == 5) {
                interval = 1000;
            } else {
                interval = 500;
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return integer;
        }).timeout(600, TimeUnit.MILLISECONDS).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void test2() {
        //超时时  发送一个 指定的 item  然后 执行 onComplete
        Observable.from(Global.getIntegerList(10)).map(integer -> {

            long interval;
            if (integer == 5) {
                interval = 1000;
            } else {
                interval = 500;
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return integer;
        }).timeout(600, TimeUnit.MILLISECONDS, Observable.just(-1))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }
                });

    }


}
