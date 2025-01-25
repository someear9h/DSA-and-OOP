// java program to illustrate concept of abstract class

abstract class Shape {
    String color;

    // abstract methods
    public abstract double area();
    public abstract String toString();

    // abstract class can have the constructor
    Shape(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    // concrete method
    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        // calling constructor of super class
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;

    }
    @Override public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override public String toString() {
        return "Circle color is " + super.getColor()
        + "and area is : " + area();
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(String color, double length, double width) {
        // calling Shape constructor
        super(color);
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }   
    @Override public double area() {
        return length * width;
    }

    @Override public String toString() {
        return "Rectangle Color is " + super.getColor() + " and the area is " + area();
    }
}

// main class
public class Example2 {
    public static void main(String[] args) {
        
        // creating objects
        Shape s1 = new Circle("red", 2.3);
        Shape s2 = new Rectangle("blue", 3.0, 4.0);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}


