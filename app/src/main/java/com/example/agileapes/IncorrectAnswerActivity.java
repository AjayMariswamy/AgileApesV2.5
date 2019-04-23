package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IncorrectAnswerActivity extends AppCompatActivity {

    TextView tvIncorrectAnswerUserAnswer;
    TextView tvIncorrectAnswerCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect_answer);

        tvIncorrectAnswerUserAnswer = findViewById(R.id.tvIncorrectAnswerUserAnswer);
        tvIncorrectAnswerUserAnswer.setText(Global.userAnswer);

        tvIncorrectAnswerCorrectAnswer = findViewById(R.id.tvIncorrectAnswerCorrectAnswer);
        tvIncorrectAnswerCorrectAnswer.setText(Global.correctAnswer);
    }

    public void goToQuiz(View v) {
        Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(myIntent);
    }
}
