package com.example.Howler1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.CompoundButton;

public class Settings extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    Switch switchKilometers;
    Switch switchMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView10);
        switchKilometers = findViewById(R.id.switch1);
        switchMiles = findViewById(R.id.switch2);

        // Set Kilometers switch to be on by default
        switchKilometers.setChecked(true);

        // Add an OnCheckedChangeListener to Kilometers switch
        switchKilometers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Kilometers switch is turned on
                    switchMiles.setChecked(false); // Turn off Miles switch
                } else {
                    // Kilometers switch is turned off
                    switchMiles.setChecked(true); // Turn on Miles switch
                }
            }
        });

        // Add an OnCheckedChangeListener to Miles switch
        switchMiles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Miles switch is turned on
                    switchKilometers.setChecked(false); // Turn off Kilometers switch
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setVisibility(View.VISIBLE);
                textView.setText(progress + "/30");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
