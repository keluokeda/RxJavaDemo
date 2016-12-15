import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public class Catch {
    public static void main(String[] strings) {
//        test1();
        test2();
    }

    private static void test1() {
        //遇到错误发射一个 item  跳过后面的 并执行 onComplete
        Observable.from(Global.getList(20)).map(s -> {
            if ("10".equals(s)) {
                throw new RuntimeException("error");
            }
            return s;
        }).onErrorReturn(Throwable::getMessage).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }

    private static void test2() {
        //遇到错误 重新发射一个新的list
        Observable.from(Global.getIntegerList(20)).map(integer -> {
            if (integer==10){
                throw  new RuntimeException("error");
            }
            return integer;
        }).onErrorResumeNext(Observable.from(Global.getIntegerList(30)))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(Integer s) {
                        System.out.println(s);
                    }
                });
    }


}
