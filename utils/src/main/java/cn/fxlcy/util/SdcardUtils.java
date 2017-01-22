package cn.fxlcy.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class SdcardUtils {
    /**
     * 检查是否存在SD卡
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }


    /**
     * 获得缓存路径
     */
    public static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath = null;

        if (hasSdcard()
                || !Environment.isExternalStorageRemovable()) {
            //如果SD卡存在通过getExternalCacheDir()获取路径，
            File cacheDirFile = context.getExternalCacheDir();
            if (cacheDirFile != null) {
                cachePath = cacheDirFile.getPath();
            }
        }

        if (cachePath == null) {
            //如果SD卡不存在通过getCacheDir()获取路径，
            cachePath = context.getCacheDir().getPath();
        }

        //放在路径 /.../data//cache/uniqueName
        return new File(cachePath + File.separator + uniqueName);
    }
}
