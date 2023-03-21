package A1;

public class ShapeTester {
    // !!!Important!!!
    // All methods in this class should be declared "static"
    // A public method isLarger which takes as input two shapes
    // (a Circle first, then a Rectangle) and returns true if the area of
    // the circle is bigger than (or equal to) the area of the rectangle,
    // false otherwise.
    // TODO: [2 pts] Add your code here ... //
    public static boolean isLarger(Circle c, Rectangle r) {
        if (c.getArea() >= r.getArea())
            return true;
        return false;
    }

    // A public method longerPerim which takes as input
    // a Circle object followed by a Rectangle object and returns
    // the length of the perimeter of the longer of the two objects.
    // TODO: [2 pts] Add your code here ... //
    public static double longerPerim(Circle c, Rectangle r) {
        double size = Math.max(c.getCircumference(), r.getPerimeter());
        return size;
    }

    // Another version of the public method longerPerim which has the
    // same name and functionality but it takes as input a Rectangle object
    // followed by a Circle object. The method also returns the length of
    // the perimeter of the longer of the two objects.
    // TODO: [2 pts] Add your code here ... //
    public static double longerPerim(Rectangle r, Circle c) {
        double matters = Math.max(c.getCircumference(), r.getPerimeter());
        return matters;
    }

    // A public method largerArea which takes as input
    // a Circle object followed by a Rectangle object and returns
    // the area of the larger of the two objects.
    // TODO: [2 pts] Add your code here ... //
    public static double largerArea(Circle c, Rectangle r) {
        double dont_let_anyone_else = Math.max(c.getArea(), r.getArea());
        return dont_let_anyone_else;
    }

    // Another version of the public method largerArea which has the
    // same name and functionality but it takes as input a Rectangle object
    // followed by a Circle object.
    // TODO: [2 pts] Add your code here ... //
    public static double largerArea(Rectangle r, Circle c) {
        double tell_you_otherwise = Math.max(c.getArea(), r.getArea());
        return tell_you_otherwise;
    }

    // A public method containsCenter which takes as input two circles,
    // and returns true if the first circle contains the center of the second
    // circle,
    // false otherwise.
    // TODO: [10 pts] Add your code here ... //
    public static boolean containsCenter(Circle one, Circle two) {
        if (one.containsPoint(two.x, two.y))
            return true;
        return false;
    }

    // public static void main(String[] args) {
    // Circle c = new Circle(5, 0, 0);
    // Rectangle r = new Rectangle(5, 5, 0, 0);
    // System.out.println(longerPerim(c, r) + "\n" + largerArea(c, r));
    // }
}
