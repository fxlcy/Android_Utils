package cn.fxlcy.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by fxlcy on 2017/1/5.
 * 反射帮助类
 */

public class ReflectUtils {
    private static HashMap<String, Class<?>> sClassMap;
    private static HashMap<String, Field> sFieldMap;
    private static HashMap<String, Method> sMethodMap;

    static {
        sClassMap = new HashMap<>();
        sFieldMap = new HashMap<>();
        sMethodMap = new HashMap<>();
    }

    public static Object invokeMethod(String className, Object receiver, String methodName, Object[] objects, Class<?>... parameterTypes) throws Exception {
        return invokeMethod(findClass(className), receiver, methodName, objects, parameterTypes);
    }

    public static Object invokeMethod(Class<?> clazz, Object receiver, String methodName, Object[] objects, Class<?>... parameterTypes) throws Exception {
        return findMethod(clazz, methodName, parameterTypes).invoke(receiver, objects);
    }

    public static Object getFieldObject(Class<?> clazz, Object receiver, String name) throws Exception {
        return findField(clazz, name).get(receiver);
    }

    public static Object getFieldObject(String className, Object receiver, String name) throws Exception {
        return getFieldObject(findClass(className), receiver, name);
    }

    public static void setFieldObject(Class<?> clazz, Object receiver, String name, Object obj) throws Exception {
        findField(clazz, name).set(receiver, obj);
    }

    public static void setFieldObject(String className, Object receiver, String name, Object obj) throws Exception {
        setFieldObject(findClass(className), receiver, name, obj);
    }


    public static Class<?> findClass(String className) throws ClassNotFoundException {
        Class<?> clazz = sClassMap.get(className);

        if (clazz == null) {
            clazz = Class.forName(className);
        }

        return clazz;
    }


    public static Method findMethod(Class<?> clazz, String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        StringBuilder sb = new StringBuilder(clazz.getName());
        sb.append(".").append(name);
        if (parameterTypes != null && parameterTypes.length > 0) {
            sb.append("(");
            for (Class<?> c : parameterTypes) {
                sb.append(c.getName()).append(",");
            }
            sb.deleteCharAt(sb.length() - 1).append(")");
        }

        String methodKey = sb.toString();
        Method method = sMethodMap.get(methodKey);

        if (method == null) {
            Class<?> _clazz = clazz;
            while (clazz != null) {
                try {
                    method = clazz.getDeclaredMethod(name, parameterTypes);
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }

                    sMethodMap.put(methodKey, method);
                    return method;
                } catch (NoSuchMethodException var5) {
                    clazz = clazz.getSuperclass();
                }
            }

            throw new NoSuchMethodException("Method " + methodKey + " not found in " + _clazz);
        }

        return method;
    }

    public static Field findField(Class<?> clazz, String name) throws NoSuchFieldException {
        String fieldKey = clazz.getName() + "." + name;

        Field field = sFieldMap.get(fieldKey);
        if (field == null) {
            Class<?> _clazz = clazz;

            while (clazz != null) {
                try {
                    field = clazz.getDeclaredField(name);
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }

                    sFieldMap.put(fieldKey, field);

                    return field;
                } catch (NoSuchFieldException var4) {
                    clazz = clazz.getSuperclass();
                }
            }

            throw new NoSuchFieldException("Field " + fieldKey + " not found in " + _clazz);
        }

        return field;
    }

}
