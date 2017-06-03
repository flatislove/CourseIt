package com.itra.database.daoImplements;

import com.itra.database.dao.UserRepository;
import com.itra.database.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDaoImplementation{

    @Autowired
    private UserRepository userDao;



    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        return userDao.findAll();
    }

//    @Override
//    public ArrayList<User> findAll() {
//        return null;
//    }
}
