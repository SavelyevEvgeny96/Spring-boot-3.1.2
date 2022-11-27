package com.example.pp_2_3_1boot.service;

import com.example.pp_2_3_1boot.dao.UserDao;
import com.example.pp_2_3_1boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }


    @Override
    @Transactional
    public void updateUser(User updatedUser) {
     User user = getUserById(updatedUser.getId());
     user.setName(updatedUser.getName());
     user.setSurname(updatedUser.getSurname());
     user.setEmail(updatedUser.getEmail());
     dao.updateUser(user);
    }



    @Override
    @Transactional
    public void deleteUser(long id) { dao.deleteUser(id); }


}