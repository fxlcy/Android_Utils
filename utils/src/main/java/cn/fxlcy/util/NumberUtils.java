package cn.fxlcy.util;

/**
 * Created by fxlcy on 2016/12/2.
 */

public final class NumberUtils {
    private NumberUtils() {
        throw new RuntimeException("Stub");
    }

    public static Integer[] intArrToIntegerArr(int[] arr) {
        int len = arr.length;
        Integer[] integers = new Integer[len];

        for (int i = 0; i < len; i++) {
            integers[i] = arr[i];
        }

        return integers;
    }
}
