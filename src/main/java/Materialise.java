import rx.Notification;
import rx.Observable;
import rx.functions.Action1;

public class Materialise {
    public static void main(String[] strings) {
//        test1();
        test2();
    }

    private static void test1() {
        //item to notification
        Observable.just(1).materialize().subscribe(integerNotification ->
                {
                    System.out.println(integerNotification.getKind().name());
                    System.out.println(integerNotification.getValue());
                }
        );
    }

    private static void test2() {
        Observable.just(1).materialize().subscribe(new Action1<Notification<Integer>>() {
            @Override
            public void call(Notification<Integer> integerNotification) {
                
            }
        });

    }
}
