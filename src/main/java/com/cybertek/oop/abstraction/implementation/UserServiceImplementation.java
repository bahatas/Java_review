package com.cybertek.oop.abstraction.implementation;

import com.cybertek.oop.encapculation.User;

public interface UserServiceImplementation {

    public static final String  name = "name";

    abstract String userByRoleId(int id);
    User usrByFirstname(String firstName);

}
