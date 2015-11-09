package com.tao.chinachuclient.CastSupport;

import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.libraries.cast.companionlibrary.cast.BaseCastManager;
import com.google.android.libraries.cast.companionlibrary.cast.VideoCastManager;
import com.google.android.libraries.cast.companionlibrary.utils.Utils;

import android.app.Application;
import android.content.Context;

public class CastApplication extends Application{
    /** ボリューム増減値 */
    public static final double VOLUME_INCREMENT = 0.05;

    /** ReceiverアプリのID */
    private static String APPLICATION_ID = CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID;

    /** CastManager */
    private static VideoCastManager mCastMgr = null;

    @Override
    public void onCreate() {
        super.onCreate();

        // Receiverはデフォルトアプリを利用する
        APPLICATION_ID = CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID;

        // ボリュームの増減値をセット
        Utils.saveFloatToPreference(getApplicationContext(), "volume-increment", (float) VOLUME_INCREMENT);
    }

    /**
     * CastManagerを取得する。
     *
     * @param context
     * @return
     */
    public static VideoCastManager getCastManager(Context context) {
        if (null == mCastMgr) {
            mCastMgr = VideoCastManager.initialize(context, APPLICATION_ID,
                    null, null);
            mCastMgr.enableFeatures(
                    VideoCastManager.FEATURE_NOTIFICATION |
                            VideoCastManager.FEATURE_LOCKSCREEN |
                            VideoCastManager.FEATURE_DEBUGGING);

        }
        mCastMgr.setContext(context);

        String destroyOnExitStr = Utils.getStringFromPreference(context, "termination_plicy");
        mCastMgr.setStopOnDisconnect(null != destroyOnExitStr && "1".equals(destroyOnExitStr));
        return mCastMgr;
    }
}
