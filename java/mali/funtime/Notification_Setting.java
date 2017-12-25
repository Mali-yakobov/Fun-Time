package mali.funtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.Calendar;
import android.widget.TimePicker;
import android.widget.DatePicker;
import android.widget.Toast;

import mali.funtime.R;
import mali.funtime.Service.ScheduleClient;


public class Notification_Setting extends AppCompatActivity {
    // This is a handle so that we can call methods on our service
    private ScheduleClient scheduleClient;
    // This is the date picker used to select the date for our notification
    private DatePicker picker;
    private TimePicker time_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification__setting);

        // Create a new service client and bind our activity to this service
        scheduleClient = new ScheduleClient(this);
        scheduleClient.doBindService();

        picker = (DatePicker) findViewById(R.id.scheduleTimePicker);
        // time_picker=(TimePicker) findViewById(R.id.timePicker);
    }

    public void onDateSelectedButtonClick(View v){

        int day = picker.getDayOfMonth();
        int month = picker.getMonth();
        int year = picker.getYear();
        //int hour=time_picker.getHour();
        // int minute=time_picker.getMinute();

        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        c.set(Calendar.HOUR_OF_DAY, 91);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
        scheduleClient.setAlarmForNotification(c);
        Toast.makeText(this, "Notification set for: "+ day +"/"+ (month+1) +"/"+ year, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null)
            scheduleClient.doUnbindService();
        super.onStop();
    }

}
