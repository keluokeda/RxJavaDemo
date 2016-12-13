import rx.Observable;
import rx.functions.Action1;

import java.util.List;

/**
 * 获取 list 中指定位置的 item
 */
public class ElementAt {

    public static void main(String[] strings) {
        List<Integer> integers = Global.getIntegerList(10);
        Observable.from(integers).elementAtOrDefault(2, 10).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
