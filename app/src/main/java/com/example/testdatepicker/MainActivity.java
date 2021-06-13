package com.example.testdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);

        Button btnDate = findViewById(R.id.date);
        Button btnTime = findViewById(R.id.time);
        TextView dateMonitor = findViewById(R.id.disp);


        calendar.setTimeInMillis(System.currentTimeMillis());
        dateMonitor.setText(calendar.getTime().toString());

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int setYear, int setMonth, int setDay) {
                                calendar.set(setYear,setMonth,setDay);
                                dateMonitor.setText(calendar.getTime().toString());
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR,hourOfDay);
                                calendar.set(Calendar.MINUTE,minute);
                                dateMonitor.setText(calendar.getTime().toString());
                            }
                        }, hour, min, true);
                timePickerDialog.show();
            }
        });
    }
}