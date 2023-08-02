package com.umntv.launcher.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;

import com.umntv.launcher.util.Preference;

public class AccessService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String reqEvent;
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    reqEvent = intent.getExtras().getString("REQ_event");
                    if (reqEvent.indexOf("access_event_back") == 0) {
                        performGlobalAction(GLOBAL_ACTION_BACK);
                    } else if (reqEvent.indexOf("access_event_home") == 0) {
                        performGlobalAction(GLOBAL_ACTION_HOME);
                    } else if (reqEvent.indexOf("access_event_quick_settings") == 0) {
                        performGlobalAction(GLOBAL_ACTION_QUICK_SETTINGS);
                    } else if (reqEvent.indexOf("access_event_recents") == 0) {
                        performGlobalAction(GLOBAL_ACTION_RECENTS);
                    } else if (reqEvent.indexOf("access_event_notifications") == 0) {
                        performGlobalAction(GLOBAL_ACTION_NOTIFICATIONS);
                    } else if (reqEvent.indexOf("access_event_power_dialog") == 0) {
                        Preference.exec_flag = performGlobalAction(GLOBAL_ACTION_POWER_DIALOG);
                    }
                    return super.onStartCommand(intent, flags, startId);
                }
            } catch (Exception ignored) {

            }
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
