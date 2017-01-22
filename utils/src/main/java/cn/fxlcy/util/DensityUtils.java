package cn.fxlcy.util;

import android.content.Context;

/**
 * 设备长度单位转换
 * */
public class DensityUtils {  
	private DensityUtils(){
	}
	
	private static float mDensity = -1;  
	
	public static float getDensity(Context context){
		if(mDensity == -1){
			mDensity = context.getResources().getDisplayMetrics().density;  
		}
		
		return mDensity;
	}
	
    /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dp2px(Context context, float dpValue) {  
        return (int) (dpValue * getDensity(context) + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dp(Context context, float pxValue) {  
        return (int) (pxValue / getDensity(context) + 0.5f);  
    }


	public static int sp2px(Context context, float spValue) {
		return (int)(spValue * getDensity(context) + 0.5F);
	}

	public static int px2sp(Context context, float pxValue) {
		return (int)(pxValue / getDensity(context) + 0.5F);
	}
}  