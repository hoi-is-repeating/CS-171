package A1;

// This class represents a circle shape
public class Circle extends Object {
    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center
    // The default constructor with no argument

    public Circle() {
        // Initializing the values of the instance variables
        radius = 1.0;
        x = 0.0;
        y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double r) {
        radius = r;
        x = 0.0;
        y = 0.0;
    }

    // Overloaded constructor
    // Parameter r should be the radius length
    // Parameter ex should be the x coordinate
    // Parameter why should be the y coordinate
    public Circle(double r, double ex, double why) {
        // TODO [2 pts] Complete this overloaded constructor ... //
        radius = r;
        x = ex;
        y = why;
    }

    // A public getter method for retrieving the radius
    public double getRadius() {
        return radius;
    }

    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
        double[] c = { this.x, this.y };
        return c;
    }

    // A public getter method for computing and returning
    // the area of the circle
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // A public method you need to write to
    // compute and return the circumference of the circle
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // A public method that compares the sizes of two circles: the circle
    // represented by the current object, and the circle passed as a parameter.
    // Example: circleA.isBiggerThan(circleB) should return true if circleA
    // has a larger area than circleB, false otherwise.
    // NOTE: You may need to modify the parameter list!
    public boolean isBiggerThan(Circle c) {
        if (this.radius > c.radius)
            return true;
        return false;
    }

    // A public method that takes as input an x coordinate (as a double)
    // and a y coordinate (a double), and returns true if the (x, y) coordinate
    // is inside the current circle, false otherwise.
    // NOTE: You may need to modify the parameter list!
    public boolean containsPoint(double x, double y) {
        if (this.x + radius > x && this.x - radius < x) {
            if (this.y + radius > y && this.y - radius < y) {
                return true;
            }
        }
        return false;
    }

    // A public method named setRadius that sets this object's radius
    // based on the passed parameter (of type double).
    // The method should not return anything.
    // TODO: [2 pts] Add your method setRadius here here ... //
    public void setRadius(double r) {
        radius = r;
    }

    // A public method named setCenter that sets this object's center.
    // The method takes two doubles as parameters: ex and why.
    // It should set the x coordinate of the circle to ex,
    // and the y coordinate of the circle to why.
    // The method should not return anything.
    // TODO: [2 pts] Add your method here ... //
    public void setCenter(double ex, double why) {
        x = ex;
        y = why;
    }

    // Overriden method toString which should
    // return the string representation of this Circle object, as follows:
    // "This circle is centered at point <display_coordinate_of_center_here>
    // with radius <display_radius>"
    @Override
    public String toString() {
        // TODO: [1 pt]
        return "This circle is centered at point x: " + x + ", y: " + y + " with radius r: " + radius;
    }

    // Override the method equals which is inherited from class Object
    // (similar to what we did in class Employee), and make it return true if the
    // two circles have equal areas, false otherwise
    // Important: Use the @Override annotation
    // TODO: [2 pts] Add your code here ... //
    @Override
    public boolean equals(Object o) {
        if (this.getArea() == ((Circle) o).getArea())
            return true;
        return false;
    }
}