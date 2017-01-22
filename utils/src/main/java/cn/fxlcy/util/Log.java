/*
**        DroidPlugin Project
**
** Copyright(c) 2015 Andy Zhang <zhangyong232@gmail.com>
**
** This file is part of DroidPlugin.
**
** DroidPlugin is free software: you can redistribute it and/or
** modify it under the terms of the GNU Lesser General Public
** License as published by the Free Software Foundation, either
** version 3 of the License, or (at your option) any later version.
**
** DroidPlugin is distributed in the hope that it will be useful,
** but WITHOUT ANY WARRANTY; without even the implied warranty of
** MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
** Lesser General Public License for more details.
**
** You should have received a copy of the GNU Lesser General Public
** License along with DroidPlugin.  If not, see <http://www.gnu.org/licenses/lgpl.txt>
**
**/

package cn.fxlcy.util;

public class Log {
    private static final int VERBOSE = android.util.Log.VERBOSE;
    private static final int DEBUG = android.util.Log.DEBUG;
    private static final int INFO = android.util.Log.INFO;
    private static final int WARN = android.util.Log.WARN;
    private static final int ERROR = android.util.Log.ERROR;
    private static final int ASSERT = android.util.Log.ASSERT;

    public static boolean sLoggable = true;

    private Log() {
    }

    public static void setLoggable(boolean loggable) {
        sLoggable = loggable;
    }

    public static boolean isLoggable(int i) {
        return sLoggable;
    }

    public static boolean isLoggable() {
        return sLoggable;
    }

    private static void println(final int level, final String tag, final String format, final Object[] args, final Throwable tr) {
        String message;
        if (args != null && args.length > 0) {
            message = String.format(format, args);
        } else {
            message = format;
        }

        if (tr != null) {
            message += android.util.Log.getStackTraceString(tr);
        }

        android.util.Log.println(level, tag, message);
    }

    public static void v(String tag, String format, Object... args) {
        v(tag, format, null, args);
    }

    public static void v(String tag, String format, Throwable tr, Object... args) {
        if (!isLoggable(VERBOSE)) {
            return;
        }

        println(VERBOSE, tag, format, args, tr);
    }


    public static void d(String tag, String format, Object... args) {
        d(tag, format, null, args);
    }

    public static void d(String tag, String format, Throwable tr, Object... args) {
        if (!isLoggable(DEBUG)) {
            return;
        }
        println(DEBUG, tag, format, args, tr);
    }

    public static void i(String tag, String format, Object... args) {
        i(tag, format, null, args);
    }

    public static void i(String tag, String format, Throwable tr, Object... args) {
        if (!isLoggable(INFO)) {
            return;
        }
        println(INFO, tag, format, args, tr);
    }

    public static void w(String tag, String format, Object... args) {
        w(tag, format, null, args);
    }

    public static void w(String tag, String format, Throwable tr, Object... args) {
        if (!isLoggable(WARN)) {
            return;
        }
        println(WARN, tag, format, args, tr);
    }

    public static void w(String tag, Throwable tr) {
        w(tag, "Log.warn", tr);
    }

    public static void e(String tag, String format, Object... args) {
        e(tag, format, null, args);
    }

    public static void e(String tag, String format, Throwable tr, Object... args) {
        if (!isLoggable(ERROR)) {
            return;
        }
        println(ERROR, tag, format, args, tr);
    }

    public static void wtf(String tag, String format, Object... args) {
        wtf(tag, format, null, args);
    }

    public static void wtf(String tag, Throwable tr) {
        wtf(tag, "wtf", tr);
    }

    public static void wtf(String tag, String format, Throwable tr, Object... args) {
        if (!isLoggable()) {
            return;
        }
        println(ASSERT, tag, format, args, tr);
    }



}
