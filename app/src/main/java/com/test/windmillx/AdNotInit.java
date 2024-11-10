package com.test.windmillx;


import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;





public class AdNotInit implements IXposedHookLoadPackage {

    public static String TAG = "xingtong";


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if(loadPackageParam.processName.equals("com.mfhd.ygj.p3")) {

            Class ActivityPluginBinding_clazz  = XposedHelpers.findClassIfExists("io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding",loadPackageParam.classLoader);

            if (ActivityPluginBinding_clazz!=null){
                XposedHelpers.findAndHookMethod("com.windmill.windmill_ad_plugin.WindmillAdPluginDelegate", loadPackageParam.classLoader, "onAttachedToActivity", ActivityPluginBinding_clazz, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        Log.d(TAG,"pass ad init");
                        return null;
                    }
                });
            }


        }
    }
}

