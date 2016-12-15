import rx.Observable;
import rx.functions.Action1;

/**
 * 判断两个 observable 是否发射相同的数据序列
 */
public class SequenceEqual {
    public static void main(String[] strings){
        Observable.sequenceEqual(Observable.from(Global.getIntegerList(10)),Observable.from(Global.getIntegerList(10))).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                System.out.println(aBoolean);
            }
        });
    }
}
