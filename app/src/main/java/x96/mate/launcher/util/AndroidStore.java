package x96.mate.launcher.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AndroidStore {

    public static void open(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException ignored) {
            intent.setData(Uri.parse("market://details?id=" + packageName));
            context.startActivity(intent);
        }
    }
}
