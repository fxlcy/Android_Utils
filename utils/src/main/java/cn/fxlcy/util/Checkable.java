package cn.fxlcy.util;

/**
 * Created by fxlcy
 * on 2017/1/22
 *
 * @author fxlcy
 * @version 1.0
 */
public interface Checkable<T> {
    boolean check(T obj);
}
