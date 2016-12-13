import rx.Observable;
import rx.functions.Action1;

public class Start {

    public static void main(String[] strings) {

        /**
         *在 ＊＊＊ 之前  添加一个 item
         */
        Observable.just("hello").startWith("han").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
        
    }
}
