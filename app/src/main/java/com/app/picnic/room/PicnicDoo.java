package com.app.picnic.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.picnic.models.model_picnic;

import java.util.List;

@Dao
public interface PicnicDoo {

@Insert(onConflict = OnConflictStrategy.REPLACE)
void insertPicnic(model_picnic m);

@Query("select * from picnic")
LiveData<List<model_picnic> >getPicnicAll();

@Delete
void delete(model_picnic m);

    @Query("DELETE FROM picnic WHERE id = :id")
    void deleteById(int id);
}
