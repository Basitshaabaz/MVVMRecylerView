package com.example.mvvmrecylerview.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmrecylerview.models.User;
import com.example.mvvmrecylerview.repositories.UserRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<User>> mList;
    private UserRepository mUser;
    private MutableLiveData<Boolean> mIsUpdating=new MutableLiveData<>();

    //************************************************************
    public void init()
    //************************************************************
    {
        if (mList!=null)
        {
            return;
        }
        mUser=UserRepository.getInstance();
        mList=mUser.getUser();


    }
    public void addNewValue(final User user)
    {
        mIsUpdating.setValue(true);
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                List<User> currentPlaces = mList.getValue();
                currentPlaces.add(user);
                mList.postValue(currentPlaces);
                mIsUpdating.postValue(false); }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute();
    }

    //************************************************************
    public LiveData<List<User>> getList()
    //************************************************************
    { return mList; }

    //************************************************************
    public LiveData<Boolean> getIsUpdating()
    //************************************************************
    { return mIsUpdating;}
}
