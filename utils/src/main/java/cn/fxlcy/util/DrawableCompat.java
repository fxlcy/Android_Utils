package cn.fxlcy.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;


/**
 * Created by fxlcy on 2016/8/9.
 */
public class DrawableCompat {
    private DrawableCompat(){}

    /**
     * 设置drawable着色器
     * */
    public static Drawable getTintList(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = android.support.v4.graphics.drawable.DrawableCompat.wrap(drawable);
        android.support.v4.graphics.drawable.DrawableCompat.setTintList(wrappedDrawable,colors);
        return wrappedDrawable;
    }

    public static Drawable getTintList(Context context, @DrawableRes int resId,@ColorRes int colorResId) {
        Drawable drawable = android.support.v4.content.ContextCompat.getDrawable(context,resId);
        return getTintList(drawable, android.support.v4.content.ContextCompat.getColorStateList(context,colorResId));
    }

    public static Drawable getTint(Drawable drawable, int color) {
        if(drawable == null)return null;
        final Drawable wrappedDrawable = android.support.v4.graphics.drawable.DrawableCompat.wrap(drawable);
        android.support.v4.graphics.drawable.DrawableCompat.setTint(wrappedDrawable,color);
        return wrappedDrawable;
    }

    public static Drawable getTint(Context context, @DrawableRes int resId,@ColorRes int colorResId) {
        Drawable drawable = android.support.v4.content.ContextCompat.getDrawable(context,resId);
        return getTint(drawable, android.support.v4.content.ContextCompat.getColor(context,colorResId));
    }
}
