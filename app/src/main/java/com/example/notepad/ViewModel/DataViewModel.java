package com.example.notepad.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notepad.Database.DBManager;
import com.example.notepad.Database.DatabaseHandler;
import com.example.notepad.Model.Note;

import java.util.ArrayList;

public class DataViewModel extends ViewModel {

    private  MutableLiveData<ArrayList<Note>> listMutableLiveData = new MutableLiveData<>();
    DBManager databaseHandler ;

    public DataViewModel(DBManager databaseHandler ) {
        this.databaseHandler = databaseHandler;
    }

    public void getData()
    {
        listMutableLiveData.setValue(databaseHandler.getAllNotes());
    }

    public MutableLiveData<ArrayList<Note>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void setListMutableLiveData(ArrayList<Note> listMutableLiveData) {
        this.listMutableLiveData.setValue(listMutableLiveData);
    }
}
