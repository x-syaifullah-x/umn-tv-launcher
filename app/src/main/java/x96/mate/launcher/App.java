package x96.mate.launcher;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
//            Executors.newSingleThreadExecutor().execute(new Runnable() {
//                @Override
//                public void run() {
//                    StringWriter stringWriter = new StringWriter();
//                    PrintWriter printWriter = new PrintWriter(stringWriter);
//                    e.printStackTrace(printWriter);
//
//                    System.out.println(stringWriter);
//
//                    Intent intent = new Intent(getBaseContext(), ExceptionActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    getBaseContext().startActivity(intent);
//                    System.;
//                }
//            });
//        });
    }
}
