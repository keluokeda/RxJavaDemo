import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.List;

/**
 * 从 list 中找到最后一个符合条件的 item
 * 找不到就走 onError
 */
public class Last {

    public static void main(String[] strings) {
        List<Integer> list = Global.getIntegerList(100);
        Observable.from(list).last(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 18 == 0;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext");
            }
        });
    }
}
