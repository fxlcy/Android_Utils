package cn.fxlcy.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static cn.fxlcy.util.NetworkState.NETWORK_MOBILE;
import static cn.fxlcy.util.NetworkState.NETWORK_NONE;
import static cn.fxlcy.util.NetworkState.NETWORK_OTHER;
import static cn.fxlcy.util.NetworkState.NETWORK_WIFI;

/**
 * Created by fxlcy
 * on 2017/1/21.
 *
 * @author fxlcy
 * @version 1.0
 */

public class NetUtils {
    private static ConnectivityManager sConnectivityManager;

    /**
     * 检查网络状态
     *
     * @param context
     * @return
     */
    public synchronized static int getNetworkState(Context context) {
        if (sConnectivityManager == null) {
            sConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        }

        NetworkInfo netInfo = sConnectivityManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isAvailable()) {
            //网络连接
            if (netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                //WiFi网络
                if (netInfo.isConnectedOrConnecting()) {
                    return NETWORK_WIFI;
                }
            } else if (netInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                //有线网络
                if (netInfo.isConnectedOrConnecting()) {
                    return NETWORK_MOBILE;
                }
            } else if (netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                //3g网络
                if (netInfo.isConnectedOrConnecting()) {
                    return NETWORK_MOBILE;
                }
            } else {
                return NETWORK_OTHER;
            }
        }

        return NETWORK_NONE;
    }

}
