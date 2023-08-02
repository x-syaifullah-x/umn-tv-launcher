package x96.mate.launcher.util.view.dialog;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.provider.Settings;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import x96.mate.launcher.util.CloseableHelper;
import x96.mate.launcher.util.MediaStorageHelper;
import x96.mate.launcher.util.ToastHelpers;

public class Download {

    private static DownloadDialog createDialog(Context context, File publicDirectory) {
        return new DownloadDialog(context, publicDirectory) {
            private ParcelFileDescriptor parcelFileDescriptor = null;

            @Override
            protected void onConnected(Header header) throws Throwable {
                super.onConnected(header);

                File destinationOutput = getDestinationOutput();

                ContentResolver cr = context.getContentResolver();

                String fileName = destinationOutput.getName();

                Uri insertUri = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q ?
                        MediaStore.Downloads.EXTERNAL_CONTENT_URI : MediaStore.Files.getContentUri("external");
                Uri exist = MediaStorageHelper.exist(cr, insertUri, fileName);
                if (exist != null) {
                    boolean deleteResult = cr.delete(exist, null, null) > 0;
                }

                ContentValues contentValues = new ContentValues();
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, fileName);
                contentValues.put(MediaStore.MediaColumns.SIZE, header.getContentLength());
                long now = System.currentTimeMillis();
                contentValues.put(MediaStore.MediaColumns.DATE_ADDED, now);
                contentValues.put(MediaStore.MediaColumns.DATE_MODIFIED, now);
                String relativePath = destinationOutput.getPath().replace(fileName, "");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    contentValues.put(MediaStore.MediaColumns.DATE_TAKEN, now);
                    contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, relativePath);
                }

                Uri uriResult = cr.insert(insertUri, contentValues);

                if (uriResult == null) {
                    /* REQUEST RESET MEDIA STORAGE */
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    String packageNameProviderMedia = "com.android.providers.media";
                    Uri uriProviderMedia = Uri.fromParts("package", packageNameProviderMedia, null);
                    intent.setData(uriProviderMedia);

                    getHandler().post(() ->
                            Toast.makeText(context, "Please clear data media storage and try again", Toast.LENGTH_LONG).show()
                    );
                    context.startActivity(intent);
                    disconnect();
                }

                parcelFileDescriptor = cr.openFileDescriptor(uriResult, "rw");

                setFileOutputStream(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
            }

            @Override
            protected void onDownloadFinish() throws IOException {
                super.onDownloadFinish();
                getHandler().post(() -> ToastHelpers.showLong(context, "Downloaded successfully"));
            }

            @Override
            protected void onFinally() {
                super.onFinally();
                CloseableHelper.close(parcelFileDescriptor);
            }
        };
    }

    private static void toPublicDirectory(Context context, String link, File publicDirectory) {
        createDialog(context, publicDirectory).open(link);
    }

    public static void toPublicDirectoryDownload(Context context, String link) {
        toPublicDirectory(
                context, link, new File(Environment.DIRECTORY_DOWNLOADS)
        );
    }
}