package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CorrectAnswerActivity extends AppCompatActivity {

    TextView tvCorrectAnswerUserAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);

        tvCorrectAnswerUserAnswer = findViewById(R.id.tvCorrectAnswerUserAnswer);
        tvCorrectAnswerUserAnswer.setText(Global.userAnswer);

    }

    public void goToQuiz(View v) {
        Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(myIntent);
    }
}
