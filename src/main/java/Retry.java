import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.functions.Func2;

public class Retry {
    public static void main(String[] strings) {
//        test1();
        test2();
    }

    private static void test1() {
        //出现错误 重新尝试 超过失败上限就不再尝试
        Observable.from(Global.getIntegerList(20)).map(integer -> {
            if (integer == 10) {
                throw new RuntimeException("integer error");
            }
            return integer;
        }).retry(10).subscribe(new Observer<Integer>() {
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
                System.out.println(integer);
            }
        });
    }

    private static int times = 0;

    private static void test2() {
        //判读是否 需要 retry
        Observable.from(Global.getIntegerList(20)).map(integer -> {
            if (integer == 10) {
                throw new RuntimeException("integer error");
            }
            return integer;
        }).retry((integer, throwable) -> {
            times++;
            return times != 5;
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
                System.out.println(integer);
            }
        });
    }


}
