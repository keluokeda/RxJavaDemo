import rx.Observable;
import rx.Observer;

import java.util.List;

/**
 * 不会调用 onNext
 */
public class IgnoreElement {

    public static void main(String[] strings) {
        List<Integer> list = Global.getIntegerList(20);
        Observable.from(list).ignoreElements().subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext "+integer);
            }
        });
    }
}
