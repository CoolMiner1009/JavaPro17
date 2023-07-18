import java.util.ArrayList;
import java.util.List;

public class ArrayToListConverter {
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T item : array) {
            list.add(item);
        }
        return list;
    }
}