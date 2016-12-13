import java.util.ArrayList;
import java.util.List;

public class Global {

    public static List<String> getList(int count) {
        if (count < 0) {
            count = 0;
        }
        List<String> strings = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            strings.add(String.valueOf(i));
        }
        return strings;
    }

    public static List<Integer> getIntegerList(int count) {
        if (count < 0) {
            count = 0;
        }
        List<Integer> integers = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            integers.add(i);
        }
        return integers;
    }
}
