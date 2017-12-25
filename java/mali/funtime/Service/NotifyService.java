package mali.funtime.Service;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import mali.funtime.BeautifulSentences;

/**
 * This service is started when an Alarm has been raised
 *
 * We pop a notification into the status bar for the user to click on
 * When the user clicks the notification a new activity is opened
 *

 */
public class NotifyService extends Service {

    /**
     * Class for clients to access
     */
    public class ServiceBinder extends Binder {
        NotifyService getService() {
            return NotifyService.this;
        }
    }

    private static final int NOTIFICATION = 123;
    // Name of an intent extra we can use to identify if this service was started to create a notification
    public static final String INTENT_NOTIFY = "service.INTENT_NOTIFY";
    // The system notification manager
    private NotificationManager mNM;

    @Override
    public void onCreate() {
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFY, false))
            showNotification();

        // We don't care if this service is stopped as we have already delivered our notification
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    // This is the object that receives interactions from clients
    private final IBinder mBinder = new ServiceBinder();

    /**
     * Creates a notification and shows it in the OS drag-down status bar
     */
    private void showNotification() {
        //CharSequence title = "Alarm!!";
        int icon = R.drawable.sym_def_app_icon;
        //CharSequence text = "Your notification time is upon us.";
        long time = System.currentTimeMillis();
        // The PendingIntent to launch our activity if the user selects this notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, BeautifulSentences.class), 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(icon);
        builder.setContentTitle("Fun Time");
        builder .setContentText("Have a nice day :)");
        builder.setWhen(time);
        builder.setContentIntent(contentIntent);
        // Clear the notification when it is pressed
        builder.setAutoCancel(true);

        // Notification notification = intent.getParcelableExtra(NOTIFICATION);
        // Send the notification to the system.
        mNM.notify(NOTIFICATION, builder.build());

        // Stop the service when we are finished
        stopSelf();
    }
}