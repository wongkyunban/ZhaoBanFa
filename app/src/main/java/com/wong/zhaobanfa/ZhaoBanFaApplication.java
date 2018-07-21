package com.wong.zhaobanfa;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @author WongKyunban
 * description
 * created at 2018-07-21 上午10:12
 * @version 1.0
 */
public class ZhaoBanFaApplication extends TinkerApplication {

    public ZhaoBanFaApplication() {
        super(
                //tinkerFlags, which types is supported
                //dex only, library only, all support
                ShareConstants.TINKER_ENABLE_ALL,
                // This is passed as a string so the shell application does not
                // have a binary dependency on your ApplicationLifeCycle class.
                "com.wong.zhaobanfa.tinker");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }



}
