package com.example.agileapes;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static Qanda addQanda(final AppDatabase db, Qanda qanda) {
        db.qandaDao().insertAll(qanda);
        return qanda;
    }

    private static Qanda deleteQanda(final AppDatabase db, Qanda qanda) {
        db.qandaDao().nukeTable();
        return qanda;
    }

    private static void populateWithTestData(AppDatabase db) {
        Qanda qanda1 = new Qanda();
        qanda1.setId(1);
        qanda1.setQuestion("____________ are common solutions to common problems where the solution is ineffective and may result in undesired consequences");
        qanda1.setAnswer("antipatterns");

        Qanda qanda2 = new Qanda();
        qanda2.setId(2);
        qanda2.setQuestion("An ____ is a large user story");
        qanda2.setAnswer("epic");

        Qanda qanda3 = new Qanda();
        qanda3.setId(3);
        qanda3.setQuestion("In software development, an ________ is the evaluation of the effort necessary to carry out a given development task; this is most often expressed in terms of duration");
        qanda3.setAnswer("estimate");

        Qanda qanda4 = new Qanda();
        qanda4.setId(4);
        qanda4.setQuestion("A ___________ is a person who chooses or is given the explicit role of conducting a meeting");
        qanda4.setAnswer("facilitator");

        Qanda qanda5 = new Qanda();
        qanda5.setId(5);
        qanda5.setQuestion("___________ refers to any efforts still required for a project team to deliver a product suitable for release as a functional whole");
        qanda5.setAnswer("integration");

        Qanda qanda6 = new Qanda();
        qanda6.setId(6);
        qanda6.setQuestion("The acronym ______ stands for a set of criteria used to assess the quality of a user story. If the story fails to meet one of these criteria, the team may want to reword it");
        qanda6.setAnswer("invest");

        Qanda qanda7 = new Qanda();
        qanda7.setId(7);
        qanda7.setQuestion("An _________ is a timebox during which development takes place. The  duration may vary from project to project and is usually fixed");
        qanda7.setAnswer("iteration");

        Qanda qanda8 = new Qanda();
        qanda8.setId(8);
        qanda8.setQuestion("The ______ Method is a means to design, manage and improve flow for knowledge work and allows teams to start where they are to drive evolutionary change");
        qanda8.setAnswer("kanban");

        Qanda qanda9 = new Qanda();
        qanda9.setId(9);
        qanda9.setQuestion("________ are synthetic biographies of fictitious users of the future product");
        qanda9.setAnswer("personas");

        Qanda qanda10 = new Qanda();
        qanda10.setId(10);
        qanda10.setQuestion("Agile teams generally prefer to express estimates in units other than the time-honored man-hours. Possibly the most widespread unit is story ______");
        qanda10.setAnswer("points");

        Qanda qanda11 = new Qanda();
        qanda11.setId(11);
        qanda11.setQuestion("___________ consists of improving the internal structure of an existing program's source code, while preserving its external behavior");
        qanda11.setAnswer("refactoring");

        Qanda qanda12 = new Qanda();
        qanda12.setId(12);
        qanda12.setQuestion("_____ is a process framework used to manage product development and other knowledge work");
        qanda12.setAnswer("scrum");

        Qanda qanda13 = new Qanda();
        qanda13.setId(13);
        qanda13.setQuestion("A ____ in the Agile sense is a small group of people, assigned to the same project or effort, nearly all of them on a full-time basis");
        qanda13.setAnswer("team");

        Qanda qanda14 = new Qanda();
        qanda14.setId(14);
        qanda14.setQuestion("A _______ is a previously agreed period of time during which a person or a team works steadily towards completion of some goal");
        qanda14.setAnswer("timebox");

        Qanda qanda15 = new Qanda();
        qanda15.setId(15);
        qanda15.setQuestion("At the end of each iteration, the team adds up effort estimates associated with user stories that were completed during that iteration. This total is called ________");
        qanda15.setAnswer("velocity");

        deleteQanda(db, qanda1);
        deleteQanda(db, qanda2);
        deleteQanda(db, qanda3);
        deleteQanda(db, qanda4);
        deleteQanda(db, qanda5);
        deleteQanda(db, qanda6);
        deleteQanda(db, qanda7);
        deleteQanda(db, qanda8);
        deleteQanda(db, qanda9);
        deleteQanda(db, qanda10);
        deleteQanda(db, qanda11);
        deleteQanda(db, qanda12);
        deleteQanda(db, qanda13);
        deleteQanda(db, qanda14);
        deleteQanda(db, qanda15);

        addQanda(db, qanda1);
        addQanda(db, qanda2);
        addQanda(db, qanda3);
        addQanda(db, qanda4);
        addQanda(db, qanda5);
        addQanda(db, qanda6);
        addQanda(db, qanda7);
        addQanda(db, qanda8);
        addQanda(db, qanda9);
        addQanda(db, qanda10);
        addQanda(db, qanda11);
        addQanda(db, qanda12);
        addQanda(db, qanda13);
        addQanda(db, qanda14);
        addQanda(db, qanda15);

        List<Qanda> userList = db.qandaDao().getAll();
        Global.size = userList.size();

        String info = "";

        for(Qanda qnda : userList) {
            int id = qnda.getId();
            String question = qnda.getQuestion();
            String answer = qnda.getAnswer();
            info = info+"\n\n"+"Id :"+id+"\nQuestion :"+question+"\n"+"Answer :"+answer;

        }

        Log.d(DatabaseInitializer.TAG, "Info; " + info);

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
