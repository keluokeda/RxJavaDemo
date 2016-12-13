import rx.Observable;
import rx.functions.Action1;

/**
 * 重复
 */
public class Repeat {

    public static void main(String[] strings) {
        Observable.just("hello").repeat(10).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });


    }

}
