import rx.Observable;
import rx.functions.Action1;

import java.util.List;

public class Window {
    public static void main(String[] strings) {

        //buffer 返回的是 list  window 返回的是 observers
        List<Integer> list = Global.getIntegerList(20);
        Observable.from(list).window(2).subscribe(new Action1<Observable<Integer>>() {
            @Override
            public void call(Observable<Integer> integerObservable) {
                integerObservable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("observable=" + integerObservable + "value=" + integer);
                    }
                });
            }
        });


    }
}
