package com.cybertek.oop.encapculation;

import com.cybertek.enums.Gender;
import com.cybertek.oop.inheritance.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    //String firstName;
    //String lastName;
    //Role role;

    private String firstName;
    private String lastName;
    private Role role;
    private Gender gender;
    public User(long id, LocalDateTime insertDateTime, long insertUserId, LocalDateTime lastUpdateDateTime, long lastUpdateUserId, String firstName, String lastName, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.gender = gender;
    }

    public User(String firstName, String lastName, Role role, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.gender = gender;
    }








}


/*
 *
---> we are creataing instead of whole code just adding
 annotations

public User() {
}

public User(String firstName, String lastName, Role role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
}

public String getFirstName() {
    return firstName;
}

public String getLastName() {
    return lastName;
}

public Role getRole() {
    return role;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public void setRole(Role role) {
    this.role = role;
}
 */
