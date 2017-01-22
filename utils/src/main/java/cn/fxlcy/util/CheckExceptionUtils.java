package cn.fxlcy.util;

import java.lang.reflect.Constructor;

/**
 * Created by fxlcy
 * on 2017/1/22
 *
 * @author fxlcy
 * @version 1.0
 *          检查异常的帮助类
 */
public class CheckExceptionUtils {
    private CheckExceptionUtils() {
        throw new RuntimeException("Stub");
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }

        return obj;
    }

    public static <T> T requireNonNull(T obj, String msg) {
        if (obj == null) {
            throw new NullPointerException(msg);
        }

        return obj;
    }


    public static <T> T check(T obj, Checkable<T> checkable, Class<? extends Throwable> exType, String msg) {
        requireNonNull(obj, "check target is null");
        requireNonNull(checkable, "checkable is null");
        requireNonNull(exType, "exception type is null");

        if (checkable.check(obj)) {
            try {
                Constructor<? extends Throwable> constructor = exType.getConstructor(String.class);
                throwException(constructor.newInstance(msg));
            } catch (Exception e) {
                e.printStackTrace();
                throwException(e);
            }
        }

        return obj;
    }

    /**
     * 抛出异常
     */
    public static void throwException(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException) throwable;
        } else {
            throw new RuntimeException(throwable);
        }
    }
}
