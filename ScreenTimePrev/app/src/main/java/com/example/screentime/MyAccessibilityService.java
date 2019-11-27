package com.example.screentime;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;




public class MyAccessibilityService extends android.accessibilityservice.AccessibilityService {
    private Context context;
    public static String[] myStrings = {"com.google.android.youtube", "com.google.android.gm", "com.google.android.apps.maps"};
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        //event type window change

        final int eventType = accessibilityEvent.getEventType();
        if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            if (accessibilityEvent.getPackageName().equals(myStrings[0])) {
                System.out.println("Youtube");

                Toast toast = Toast.makeText(getApplicationContext(), "Youtube", Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(MyAccessibilityService.this,AfterEvent.class);
                intent.putExtra("package_name",myStrings[0]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else if (accessibilityEvent.getPackageName().equals(myStrings[1])) {
                System.out.println("Gmail");

                Toast toast = Toast.makeText(getApplicationContext(), "Gmail", Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(MyAccessibilityService.this,AfterEvent.class);
                intent.putExtra("package_name",myStrings[1]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else if (accessibilityEvent.getPackageName().equals(myStrings[2])) {
                System.out.println("Google Map");

                Toast toast = Toast.makeText(getApplicationContext(), "Google Map", Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(MyAccessibilityService.this,AfterEvent.class);
                intent.putExtra("package_name",myStrings[2]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }
    @Override
    public void onInterrupt() {

    }
}
