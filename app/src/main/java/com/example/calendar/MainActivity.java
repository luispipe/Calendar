package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView date;
    CalendarView calendar;

    ImageButton calendarOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date= findViewById(R.id.date_view);
        calendar= findViewById(R.id.calendarView);
        calendarOn= findViewById(R.id.imageButton);
        calendar.setVisibility(View.INVISIBLE);


        calendarOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calendar.getVisibility()==View.INVISIBLE){
                    calendar.setVisibility(View.VISIBLE);
                    Log.i("ImageButton",calendar.getVisibility()+"");
                }else{
                    calendar.setVisibility(View.INVISIBLE);
                }
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth+"/"+month+"/"+year);
            }
        });
    }
}