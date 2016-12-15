import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

import java.util.ArrayList;

/**
 * 把数据 收集在集合中
 */
public class Collect {
    public static void main(String[] strings) {
        Observable.from(Global.getIntegerList(10)).collect(ArrayList::new, (Action2<ArrayList<Integer>, Integer>) ArrayList::add).subscribe(System.out::println);
    }
}
