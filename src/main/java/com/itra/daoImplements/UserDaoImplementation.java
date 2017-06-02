package com.itra.daoImplements;

import com.itra.dao.UserDao;
import com.itra.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDaoImplementation{

    @Autowired
    private UserDao userDao;



    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        return userDao.findAll();
    }

//    @Override
//    public ArrayList<User> findAll() {
//        return null;
//    }
}
