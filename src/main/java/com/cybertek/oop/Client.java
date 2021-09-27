package com.cybertek.oop;

import java.util.Objects;

public class Client {


    public static void main(String[] args) {
        Client client1 = new Client(25);
       Client client2 = new Client(25);
        Client client3 = client1;
        Client client = new Client(5);
        client2 = null;

        System.out.println(client1.equals(null));
//        System.out.println(client2.equals(null));

        System.out.println("System.identityHashCode(client1) = " + System.identityHashCode(client1));
        System.out.println("System.identityHashCode(client2) = " + System.identityHashCode(client2));
        System.out.println("System.identityHashCode(client3) = " + System.identityHashCode(client3));
    }

    private int id;

    public Client(int id) {
        this.id = id;
    }



//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

//    @Override
//    public boolean equals(Object    obj)    {
//        Client    other    =    (Client)    obj;
//        if (id !=    other.id)
//            return false;
//        return true;
//    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Client)) return false;
//        Client client = (Client) o;
//        return id == client.id;
//    }
    @Override
    public boolean equals(Object    obj)    {
        if (this ==    obj)
            return true;
        if (obj    ==    null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client)    obj;
        if (id !=    other.id)
            return false;
        return true;
    }
}
//== comparison operator checks if the object references are pointing to the same object. It does NOT look at the content of the object.
//        Client client1 = new Client(25);
//        Client client2 = new Client(25);
//        Client client3 = client1;
////client1 and client2 are pointing to different client objects.
//        System.out.println(client1 == client2);//false
////client3 and    client1    refer    to    the    same    client    objects.
//        System.out.println(client1    ==    client3);//true
//}
