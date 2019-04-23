package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    TextView tvQuizQuestion;
    Button btQuizSubmit;
    EditText etQuizAnswer;
    TextView tvQuizScore;

    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuizQuestion = findViewById(R.id.tvQuizQuestion);
        btQuizSubmit = findViewById(R.id.btQuizSubmit);
        etQuizAnswer = findViewById(R.id.etQuizAnswer);
        tvQuizScore = findViewById(R.id.tvQuizScore);

        etQuizAnswer.requestFocus();

        setTvQuizScore();

        setTvQuizQuestion();

        btQuizSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Global.userAnswer = etQuizAnswer.getText().toString();

                checkAnswer();

            }
        });

        Log.d("onCreate", "onCreate");

    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void goBackToHomeScreen(View v) {

        Intent myIntent1 = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent1);

    }

    // Get score from Global class and display in in the tvQuizScore TextView
    public void setTvQuizScore() {
        tvQuizScore.setText("" + Global.bananas);
    }

    // Obtain a random question from database using its id and set it to a TextView
    public void setTvQuizQuestion() {

        int dataCount = 15;

        Random rand = new Random();
        int randomElement = rand.nextInt(dataCount) + 1;

        currentPosition = randomElement;

        String question = AppDatabase.getAppDatabase(this).qandaDao().findQuestionById(currentPosition);

        tvQuizQuestion.setText(question);

    }

    /*
    Crosscheck user input with answer stored in database and launch either
    CorrectAnswerActivity or IncorrectAnswerActivity.
    The code for the checkAnswer method was obtained and adapted from the following video:
    https://www.youtube.com/watch?v=o-XkZGNjP-Y
     */
    public void checkAnswer() {
        String userAnswer = etQuizAnswer.getText().toString().trim().toLowerCase();

        String answer = AppDatabase.getAppDatabase(this).qandaDao().findAnswerById(currentPosition);

        if (userAnswer.equals(answer)) {
            Intent myIntent = new Intent(getBaseContext(), CorrectAnswerActivity.class);
            startActivity(myIntent);

            Global.bananas++;

        } else {
            Global.correctAnswer = answer;

            Intent myIntent = new Intent(getBaseContext(), IncorrectAnswerActivity.class);
            startActivity(myIntent);

        }
    }
}