package cn.fxlcy.util;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by fxlcy on 2016/12/2.
 */

public class ViewUtils {
    private ViewUtils() {
    }

    public static ViewGroup getViewParent(View view) {
        ViewParent vp = view.getParent();
        if (vp != null && vp instanceof ViewGroup) {
            return (ViewGroup) vp;
        }

        return null;
    }


    public static int getDefaultSize(int size, int measureSpec) {
        int result = size;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case View.MeasureSpec.UNSPECIFIED:
            case View.MeasureSpec.AT_MOST:
                result = size;
                break;
            case View.MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }

    public static boolean textIsEmpty(android.widget.EditText text) {
        Editable editable = text.getText();
        return editable == null || editable.toString().length() <= 0;
    }
}
