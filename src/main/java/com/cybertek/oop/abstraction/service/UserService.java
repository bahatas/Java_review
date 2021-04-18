package com.cybertek.oop.abstraction.service;

import com.cybertek.enums.Gender;
import com.cybertek.oop.abstraction.implementation.UserServiceImplementation;
import com.cybertek.oop.encapculation.Role;
import com.cybertek.oop.encapculation.User;

public class UserService implements UserServiceImplementation {

    @Override
    public String userByRoleId(int id) {

        User user = new User("Mike","Smith",new Role(1,"Admin"), Gender.MALE);
        return user.getFirstName()+" "+user.getLastName();
    }

    @Override
    public User usrByFirstname(String firstName) {
        User user = new User(firstName,"Ally",new Role(5,"Employee"),Gender.MALE);
        return user;
    }
}
