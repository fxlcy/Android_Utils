package cn.fxlcy.util;

import java.util.Collection;
import java.util.List;

/**
 * Created by fxlcy on 2016/10/14.
 * 集合相关帮助类
 */

public final class ListUtils {
    private ListUtils() {
        throw new RuntimeException("Stub");
    }

    public static <T> boolean isEmpty(T[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(Collection<?> coll) {
        return null == coll || coll.size() == 0;
    }

    public static int size(Collection<?> coll) {
        return coll == null ? 0 : coll.size();
    }

    public static <T> int size(T[] arr) {
        return arr == null ? 0 : arr.length;
    }

    public static <T> boolean contains(T[] arr, Object item) {
        if (arr != null) {
            for (T anArr : arr) {
                if (anArr.equals(item)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static <T> T get(List<T> list, int index) {
        return list == null ? null : list.get(index);
    }
}
