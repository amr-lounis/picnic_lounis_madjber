package com.app.picnic.repo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.app.picnic.models.model_picnic;
import com.app.picnic.room.database.PicnicDatabase;
import com.app.picnic.room.dao.PicnicDoo;

import java.util.List;

public class RepoPicnic {


    LiveData<List<model_picnic>> ld_picnics;
    PicnicDoo picnicDoo;
    Context application;

    public RepoPicnic(Context application){
        PicnicDatabase picnicDatabase = PicnicDatabase.getInstance(application);
        picnicDoo = picnicDatabase.picnicDoo();
        ld_picnics = picnicDoo.getPicnicAll();
        this.application = application;
    }
    public LiveData<List<model_picnic>>  get(){
        return  ld_picnics;
    }

    public void insertAsync(model_picnic m){
        new class_insert(picnicDoo).execute(m);
    }

    public void delete(int id){
        new class_delete(picnicDoo).execute(id);
    }

    public class class_insert extends AsyncTask<model_picnic ,Void,Void>{
        PicnicDoo  picnicdao;
        public class_insert(PicnicDoo p_dao){
            picnicdao = p_dao;
        }
        @Override
        protected Void doInBackground(model_picnic... picnics) {
            try {picnicdao.insertPicnic(picnics[0]);}catch (Exception e){}
            return null;
        }
    }

    public class class_delete extends AsyncTask<Integer ,Void,Void>{
        PicnicDoo  picnicdao;
        public class_delete(PicnicDoo p_dao){
            picnicdao = p_dao;
        }
        @Override
        protected Void doInBackground(Integer... picnics) {
            int id= picnics[0];
            try {picnicdao.deleteById(id);}catch (Exception e){}
            return null;
        }
    }
}

