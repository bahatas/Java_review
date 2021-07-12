package com.cybertek.oop.inheritance;

class Person extends Human implements A1,A2 {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public void call() {

    }

    @Override
    public void messaqge() {

    }
}


