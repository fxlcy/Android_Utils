package cn.fxlcy.util;

import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;

public class ViewCompat {
    private ViewCompat() {
        throw new RuntimeException("Stub");
    }

    /**
     * 获得view当前显示的size
     */
    public static Point getDisplaySize(View view) {
        Point size = new Point();
        Display display = android.support.v4.view.ViewCompat.getDisplay(view);

        if (display == null) {
            return size;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            display.getSize(size);
        } else {
            size.x = display.getWidth();
            size.y = display.getHeight();
        }

        return size;
    }
}
