package com.example.agileapes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

// Use of a DAO interface to provide access to the database
@Dao
public interface QandaDao {

    @Query("SELECT * FROM qanda")
    List<Qanda> getAll();

    @Query("SELECT question FROM qanda WHERE id = :qandaId")
    String findQuestionById(int qandaId);

    @Query("SELECT answer FROM qanda WHERE id = :qandaId")
    String findAnswerById(int qandaId);

    @Query("SELECT COUNT(*) FROM qanda")
    int countQandas();

    @Insert
    void insertAll(Qanda... qandas);

    @Delete
    void delete(Qanda qanda);

    @Query("DELETE FROM qanda")
    public void nukeTable();


}
