package org.md2k.utilities.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import org.md2k.utilities.BuildConfig;
import org.md2k.utilities.R;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static org.md2k.utilities.activity.ActivityBase.USE.CRASHLYTICS;
import static org.md2k.utilities.activity.ActivityBase.USE.FONT;
import static org.md2k.utilities.activity.ActivityBase.USE.ICON;

public abstract class ActivityBase extends AppCompatActivity {
    public enum USE{
        FONT, CRASHLYTICS, ICON
    }
    public ArrayList<USE> getPluginList(){
        ArrayList<USE> use=new ArrayList<>();
        use.add(USE.FONT);
        use.add(USE.CRASHLYTICS);
        use.add(USE.ICON);
        return use;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<USE> use = getPluginList();
        if(use.contains(ICON))
            LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        if(use.contains(USE.ICON))
            setupIconify();
        if(use.contains(USE.CRASHLYTICS))
            setupCrashLytics();
        if(use.contains(FONT))
            setupFont();
        }
    void setupCrashLytics(){
        Crashlytics crashlyticsKit = new Crashlytics.Builder()
                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                .build();
        // Initialize Fabric with the debug-disabled crashlytics.
        Fabric.with(this, crashlyticsKit, new Crashlytics());
    }

    void setupIconify(){
//        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    private void setupFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ubuntu/Ubuntu-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
