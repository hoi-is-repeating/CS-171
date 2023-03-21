package A1;

public class Sphere extends Circle {

    private double z;

    public Sphere() {
        x = y = z = 0.0;
        radius = 1;
    }

    public Sphere(double x, double y, double z, double radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    @Override
    public double[] getCenter() {
        double[] c = { this.x, this.y, this.z };
        return c;
    }

    public void setCenter(double x, double y, double z) {
        super.setCenter(x, y);
        this.z = z;
    }

    public double getArea() {
        return super.getArea() * 4;
    }

    public double getVolume() {
        return radius * (4.0 / 3.0) * super.getArea();
    }

}
