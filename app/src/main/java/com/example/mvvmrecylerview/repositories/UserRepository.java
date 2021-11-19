package com.example.mvvmrecylerview.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmrecylerview.constants.Constants;
import com.example.mvvmrecylerview.models.User;

import java.util.ArrayList;
import java.util.List;

/*
* Singleton pattern
 */

public class UserRepository {
    private static UserRepository instance;
    private ArrayList<User> user=new ArrayList<User>();

    public static UserRepository getInstance(){
        if(instance== null)
        {
            instance=new UserRepository();
        }
        return instance;
    }

    //Pretend to get data from a webservice or online source
    public MutableLiveData<List<User>> getUser()
    {   setUser();
        MutableLiveData<List<User>> data=new MutableLiveData<>();
        data.setValue(user);
        return data;

    }

    private void setUser()

    {
        user.add(new User(
                Constants.USER_NAME.get(0),
                Constants.IMG_URL.get(0)
        ));


        user.add(new User(
                Constants.USER_NAME.get(1),
                Constants.IMG_URL.get(1)
        ));


        user.add(new User(
                Constants.USER_NAME.get(2),
                Constants.IMG_URL.get(2)
        ));


        user.add(new User(
                Constants.USER_NAME.get(3),
                Constants.IMG_URL.get(3)
        ));


        user.add(new User(
                Constants.USER_NAME.get(4),
                Constants.IMG_URL.get(4)
        ));


        user.add(new User(
                Constants.USER_NAME.get(5),
                Constants.IMG_URL.get(5)
        ));


        user.add(new User(
                Constants.USER_NAME.get(6),
                Constants.IMG_URL.get(6)
        ));


        user.add(new User(
                Constants.USER_NAME.get(7),
                Constants.IMG_URL.get(7)
        ));



    }
}
