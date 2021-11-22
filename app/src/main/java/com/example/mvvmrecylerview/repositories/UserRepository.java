package com.example.mvvmrecylerview.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmrecylerview.constants.Constants;
import com.example.mvvmrecylerview.models.User;

import java.util.ArrayList;
import java.util.List;

/**
* Singleton pattern
 * @see User
 * */


public class UserRepository {
    private static UserRepository instance;
    private ArrayList<User> user=new ArrayList<User>();


    //************************************************************
    public static UserRepository getInstance()
    //************************************************************
    {
        if(instance== null)
        {
            instance=new UserRepository();
        }
        return instance;
    }

    //Pretend to get data from a webservice or online source
    //************************************************************
    public MutableLiveData<List<User>> getUser()
    //************************************************************
    {   setUser();
        MutableLiveData<List<User>> data=new MutableLiveData<>();
        data.setValue(user);
        return data;
    }


    //************************************************************
    private void setUser()
    //************************************************************
    {
     int index=0;
     while(index<Constants.IMG_URL.size()) {
         user.add(new User(
                 Constants.USER_NAME.get(index),
                 Constants.IMG_URL.get(index)
         ));
            ++index;
     }
    }
}
