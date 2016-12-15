import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 判断是否包含 指定 的元素
 */
public class Exists {
    public static void main(String[] strings) {
        Observable.from(Global.getIntegerList(10)).exists(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer == 5;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                System.out.println(aBoolean);
            }
        });
    }
}
