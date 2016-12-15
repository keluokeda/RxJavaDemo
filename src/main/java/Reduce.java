import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * 累计
 */
public class Reduce {
    public static void main(String[] strings) {
        Observable.range(1, 100).reduce((integer, integer2) -> integer + integer2).subscribe(System.out::println);
    }
}
