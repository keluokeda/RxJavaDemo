import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class All {
    public static void main(String[] strings){
        //item 全部满足指定条件
        Observable.from(Global.getIntegerList(10)).all(integer -> integer<50).subscribe(System.out::println);
    }
}
