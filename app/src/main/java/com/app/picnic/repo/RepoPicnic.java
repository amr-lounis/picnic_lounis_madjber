package com.app.picnic.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.app.picnic.models.model_picnic;
import com.app.picnic.room.PicnicDatabase;
import com.app.picnic.room.PicnicDoo;

import java.util.List;

public class RepoPicnic {

    LiveData<List<model_picnic>> ld_picnics;
    PicnicDoo picnicDoo;

    public RepoPicnic(Application application){
        PicnicDatabase picnicDatabase = PicnicDatabase.getInstance(application);
        picnicDoo = picnicDatabase.picnicDoo();
        ld_picnics = picnicDoo.getPicnicAll();
    }
    public void insertAsync(model_picnic m){
        new insert(picnicDoo).execute(m);
    }


    public LiveData<List<model_picnic>>  get(){
        return  ld_picnics;
    }

    public void delete(int id){
        picnicDoo.deleteById(id);
    }

    public class insert extends AsyncTask<model_picnic ,Void,Void>{
        PicnicDoo  picnicdao;
        public insert(PicnicDoo p_dao){
            picnicdao = p_dao;
        }

        @Override
        protected Void doInBackground(model_picnic... picnics) {
            picnicdao.insertPicnic(picnics[0]);
            return null;
        }
    }
}

