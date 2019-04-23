package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    TextView tvSettingsBananaNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        tvSettingsBananaNumber = findViewById(R.id.tvSettingsBananaNumber);
        tvSettingsBananaNumber.setText("" + Global.bananas);

    }

    public void launchHomeScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent);
    }

    // Resets score (bananas) when 'Reset' button is tapped by the user
    public void resetGame(View view)
    {
        Global.bananas = 0;
        tvSettingsBananaNumber = findViewById(R.id.tvSettingsBananaNumber);
        tvSettingsBananaNumber.setText("" + Global.bananas);
        Toast.makeText(getApplicationContext(),"Game reset", Toast.LENGTH_SHORT).show();

    }
}
