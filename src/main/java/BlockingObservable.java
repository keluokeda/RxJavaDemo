import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class BlockingObservable {

    public static void main(String[] strings) {
//        blockingQueue();
        Iterator<Integer> iterator = Observable.interval(500, TimeUnit.MILLISECONDS, Schedulers.immediate()).map(new Func1<Long, Integer>() {
            @Override
            public Integer call(Long aLong) {
                return aLong.intValue();
            }
        }).toBlocking().getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void blockingQueue() {
        Observable.just(1, 2, 3).flatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {

                return Observable.from(Global.getIntegerList(integer));
            }
        }).subscribe(integer -> System.out.println("thread name = " + Thread.currentThread().getName() + ", value = " + integer));
    }
}
