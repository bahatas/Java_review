package com.cybertek.leetcode.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

class ShelfTest {
    @Test
    void testPut() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by put(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new Shelf()).put("Item");
    }

    @Test
    void testPut2() {
        // TODO: This test is incomplete.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Shelf.items

        (new Shelf()).put(null);
    }

    @Test
    void testPut3() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by put(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new Shelf()).put("");
    }
    @Test
    public void shelfCanNotAcceptNull(){

        Shelf shelf = new Shelf();

        shelf.put(null);
        Assert.assertFalse(shelf.take(null));


    }
    private static List<String> getFieldNames(List<Field> fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
    @Test
    public void eachItemCanOnlyBeTakenFromShelfOnce() {
        Shelf shelf = new Shelf();
        shelf.put("Orange");
        shelf.take("Orange");
        Assert.assertFalse(shelf.take("Orange"));

    }

    @Test
    public void dublicateItemsCanExist() {
        Shelf shelf = new Shelf();
        shelf.put("Orange");
        shelf.put("Orange");
        shelf.take("Orange");
        Assert.assertTrue(shelf.take("Orange"));

    }



}

