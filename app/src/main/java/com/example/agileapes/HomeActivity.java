package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(getBaseContext()));

        TextView tvHomeBananaNumber = findViewById(R.id.tvHomeBananaNumber);
        tvHomeBananaNumber.setText("" + Global.bananas);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void launchSettingsScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), SettingsActivity.class);
        startActivity(myIntent);
    }

    public void launchMapScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), MapActivity.class);
        startActivity(myIntent);
    }

    public void launchQuizScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(myIntent);
    }

    public void launchLearningScreen(View view) {
        Intent myIntent = new Intent(getBaseContext(), LearningActivity.class);
        startActivity(myIntent);
    }

    public void launchMainScreen(View view) {
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
    }
}
