import rx.Observable;
import rx.functions.Action1;

/**
 * 判断是否包含
 */
public class Contains {
    public static void main(String[] strings){

        Observable.from(Global.getIntegerList(10)).contains(1).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                    System.out.println(aBoolean);
            }
        });
    }
}
