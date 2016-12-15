import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 把 item 变成一个 TimeInterval 包含 item 的value 和 发送间隔 interval
 */
public class TimeInterval {
    public static void main(String[] strings) {
        Observable.from(Global.getIntegerList(10)).delay(500,TimeUnit.MILLISECONDS,Schedulers.immediate())
                .timeInterval().subscribe(integerTimeInterval -> System.out.println("value = "+integerTimeInterval.getValue()+" , interval = "+integerTimeInterval.getIntervalInMilliseconds()));
    }
}
