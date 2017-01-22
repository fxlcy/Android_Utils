package cn.fxlcy.util;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
 *          <p>
 *          网络状态
 */
@IntDef({NETWORK_NONE, NETWORK_WIFI, NETWORK_MOBILE, NETWORK_OTHER})
@Retention(RetentionPolicy.SOURCE)
public @interface NetworkState {
    int NETWORK_NONE = 0;
    int NETWORK_WIFI = 1;
    int NETWORK_MOBILE = 2;
    int NETWORK_OTHER = 3;
}
