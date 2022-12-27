package com.app.picnic.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.picnic.models.model_picnic;
//,exportSchema = false
@Database(entities = {model_picnic.class},version = 1,exportSchema = false)
public abstract class PicnicDatabase extends RoomDatabase {
    public abstract PicnicDoo picnicDoo();

    private static PicnicDatabase instance;


    public static synchronized PicnicDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),PicnicDatabase.class,"picnic_db")
                            .fallbackToDestructiveMigration()
                                    .build();
        }
        return instance;
    }
}
