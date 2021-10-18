package com.cybertek.oop.inheritance;


import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class BaseEntity {
    private long id;
    private LocalDateTime insertDateTime;
    private long insertUserId;
    private LocalDateTime lastUpdateDateTime;
    private long lastUpdateUserId;


    public void baseEntityMethod(){
        System.out.println("Base Entity Method is called");
    }

}
