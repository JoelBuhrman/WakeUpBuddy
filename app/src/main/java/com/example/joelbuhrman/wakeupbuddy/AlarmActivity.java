package com.example.joelbuhrman.wakeupbuddy;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ListView buddiesList;
    String[] buddiesNames;

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    int choose_whale_sound;

    Context context;


    private static AlarmActivity inst;
    private com.erz.timepicker_library.TimePicker timePicker;

    Intent myIntent;
    private Calendar calendar;

    public AlarmActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        init();
    }

    private void init() {
        context= getApplicationContext();

        buddiesNames = new String[]{"Joel", "Izza", "Älskling", "baby", "bae", "Ice"};

        buddiesList = (ListView) findViewById(R.id.invitationListView);
        buddiesList.setAdapter(new BuddiesAdapter(getApplicationContext(), buddiesNames));
        timePicker = (com.erz.timepicker_library.TimePicker) findViewById(R.id.timePicker);


        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

         calendar = Calendar.getInstance();



    }




    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void setAlarm(View view) {

        /*Calendar calendar = Calendar.getInstance();
        int hour = Integer.parseInt(timePicker.getTime().toString().substring(11, 13));
        int minute = Integer.parseInt(timePicker.getTime().toString().substring(14, 16));
        Toast.makeText(getApplicationContext(), "Alarm set for "+hour+":"+minute, Toast.LENGTH_SHORT).show();
*/
        Calendar calendar = Calendar.getInstance();
        int hour = Integer.parseInt(timePicker.getTime().toString().substring(11, 13));
        int minute = Integer.parseInt(timePicker.getTime().toString().substring(14, 16));
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        Toast.makeText(getApplicationContext(), "Alarm set for "+hour+":"+minute, Toast.LENGTH_SHORT).show();
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        myIntent.putExtra("extra", "alarm on");
        myIntent.putExtra("whale_choice", choose_whale_sound);
        pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0,
                myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                pendingIntent);


    }

    private void cancelAlarm() {
        if (alarmManager!= null) {
            alarmManager.cancel(pendingIntent);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        choose_whale_sound = (int) l;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
