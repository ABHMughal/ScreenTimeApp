package com.example.screentime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AfterEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_event);
        ImageView appLogo = findViewById(R.id.imgLogo);
        TextView appName = findViewById(R.id.txtBlockApp);
        Bundle bundle = getIntent().getExtras();
        Drawable icon = null;
        PackageManager packageManager = getPackageManager();



        if (bundle != null){
            String pkgName = bundle.getString("package_name");
            try {
                icon = getPackageManager().getApplicationIcon(pkgName);
                ApplicationInfo info = packageManager.getApplicationInfo(pkgName, PackageManager.GET_META_DATA);
                String name = (String) packageManager.getApplicationLabel(info);
                appName.setText("OOPS! "+name.toUpperCase()+ " is currently blocked on this phone");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            appLogo.setImageDrawable(icon);


        }
    }
}
