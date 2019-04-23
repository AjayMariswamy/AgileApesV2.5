package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LearningActivity extends AppCompatActivity {

    TextView tvLearningBananaNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        tvLearningBananaNumber = findViewById(R.id.tvLearningBananaNumber);
        tvLearningBananaNumber.setText("" + Global.bananas);

        /*
        Implement a RecyclerView to display an ArrayList of data
        From lines 31-38 & 56, the code snippet was extracted from the following video:
        https://www.youtube.com/watch?v=uTVu3HsRIEE
         */

        RecyclerView recyclerView = findViewById(R.id.rvLearning);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    TextAdapter textAdapter = new TextAdapter();
        recyclerView.setAdapter(textAdapter);

        List<String> learningContent =  new ArrayList<>();
        learningContent.add("Antipatterns are common solutions to common problems where the solution is ineffective and may result in undesired consequences");
        learningContent.add("An epic is a large user story");
        learningContent.add("In software development, an estimate is the evaluation of the effort necessary to carry out a given development task this is most often expressed in terms of duration");
        learningContent.add("A facilitator is a person who chooses or is given the explicit role of conducting a meeting");
        learningContent.add("Integration refers to any efforts still required for a project team to deliver a product suitable for release as a functional whole");
        learningContent.add("The acronym invest stands for a set of criteria used to assess the quality of a user story. If the story fails to meet one of these criteria, the team may want to reword it");
        learningContent.add("An iteration is a timebox during which development takes place. The  duration may vary from project to project and is usually fixed");
        learningContent.add("The kanban method is a means to design, manage and improve flow for knowledge work and allows teams to start where they are to drive evolutionary change");
        learningContent.add("Personas are synthetic biographies of fictitious users of the future product");
        learningContent.add("Agile teams generally prefer to express estimates in units other than the time-honored man-hours. Possibly the most widespread unit is story points");
        learningContent.add("Refactoring consists of improving the internal structure of an existing program's source code, while preserving its external behavior");
        learningContent.add("Scrum is a process framework used to manage product development and other knowledge work");
        learningContent.add("A team in the Agile sense is a small group of people, assigned to the same project or effort, nearly all of them on a full-time basis");
        learningContent.add("A timebox is a previously agreed period of time during which a person or a team works steadily towards completion of some goal");
        learningContent.add("At the end of each iteration, the team adds up effort estimates associated with user stories that were completed during that iteration. This total is called velocity");


        textAdapter.setItems(learningContent);

    }

    public void launchHomeScreen(View view) {
        Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent);
        }
    }

