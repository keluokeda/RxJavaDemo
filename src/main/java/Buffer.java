import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Buffer {


    public static void main(String[] strings) {
        List<String> stringList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            stringList.add(String.valueOf(i));
        }
//        bufferCount(stringList);


    }

    /**
     * 根据时间来把 item 进行包装组合
     */
    private static void bufferTime(List<String> stringList){
        Observable.from(stringList).buffer(1000, TimeUnit.MILLISECONDS).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> result) {
                System.out.println(result);
            }
        });
    }

    /**
     * 可以认为是把一些分散的item组合成一个 list
     */
    private static void bufferCount(List<String> stringList) {

        Observable.from(stringList).buffer(5).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> result) {
                System.out.println(result);
            }
        });
    }
}
