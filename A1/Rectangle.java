package A1;

import java.beans.ExceptionListener;

import org.w3c.dom.css.Rect;

// This class represents a rectangle shape
public class Rectangle {
    private double L; // the length of the rectangle
    private double H; // the height of the rectangle
    private double x; // the x coordinate of the bottom left corner of the rectangle
    private double y; // the y coordinate of the bottom left corner of the rectangle

    // A basic constructor that creates a rectangle with
    // side lengths 1 whose bottom left corner is at (0.0,0.0)
    // TODO: [3 pts] Add your code here ... //
    public Rectangle() {
        L = H = 1.0;
        x = y = 0.0;
    }

    // A constructor that takes all four inputs,
    // named Ell, Eich, Ex, and Why for L, H, x, and y, respectively.
    // TODO: [3 pts] Add your code here ... //
    public Rectangle(double Ell, double Eich, double Ex, double Why) {
        L = Ell;
        H = Eich;
        x = Ex;
        y = Why;
    }

    // A public method called getLength which returns the length.
    // TODO: [2 pts] Add your code here ... //
    public double getLength() {
        return L;
    }

    // A public method called getHeight which returns the height.
    // TODO: [2 pts] Add your code here ... //
    public double getHeight() {
        return H;
    }

    // A public method called setLength which takes as input a double
    // called Ell and uses it to set the length of the rectangle.
    // TODO: [2 pts] Add your code here ... //
    public void setLength(double Ell) {
        L = Ell;
    }

    // A public method called setHeight which takes as input a double
    // called Eich and uses it to set the height of the rectangle.
    // TODO: [2 pts] Add your code here ... //
    public void setHeight(double Eich) {
        H = Eich;
    }

    // A public method called getPerimeter which computes and returns
    // the perimeter of the rectangle.
    // TODO: [2 pts] Add your code here ... //
    public double getPerimeter() {
        return 2 * (L + H);
    }

    // A public method called getArea which computes and returns the
    // area of the rectangle.
    // TODO: [2 pts] Add your code here ... //
    public double getArea() {
        return L * H;
    }

    // Override the method equals which is inherited from class Object
    // (similar to what we did in class Employee), and make it return true if the
    // two rectangles have equal areas, false otherwise
    // Important: Use the @Override annotation
    // TODO: [2 pts] Add your code here ... //
    @Override
    public boolean equals(Object o) {
        if (this.getArea() == ((Rectangle) o).getArea())
            return true;
        return false;
    }
}
