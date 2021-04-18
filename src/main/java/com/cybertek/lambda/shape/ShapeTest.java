package com.cybertek.lambda.shape;

public class ShapeTest {
    public static void main(String[] args) {

        //perfect
        Drawable drawable = () -> {
            System.out.println("Drawing a circle");
            System.out.println("Method implementation is completed");

        };
        drawable.draw();

        Drawable2 drawable2 = shape -> System.out.println("Drawing a "+shape);
        drawable2.draw("Triangle");

        Drawable3 drawable3 = (shape, name) -> System.out.println(name+"Drawing a"+shape);
        drawable3.draw("Circle","Mike");

        Drawable3 drawable31 = (shape, name) -> {

            System.out.println("What kind of shape is this? : " + shape);
            System.out.println("Who is drawing this shape? : " + name);
        };


        drawable31.draw("Triangle","Mike");

    }
}
