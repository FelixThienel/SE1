package org.hbrs.se1.ws24.exercises.uebung10;

public class MyPrettyRectangle {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public boolean contains(MyPrettyRectangle r) {
        return this.x1 <= r.x1 && this.y1 <= r.y1 && this.x2 >= r.x2 && this.y2 >= r.y2;
    }

    public MyPoint getCenter() {
        return new MyPoint((this.x1 + this.x2) / 2, (this.y1 + this.y2) / 2);
    }

    public double getArea() {
        return (this.x2 - this.x1) * (this.y2 - this.y1);
    }

    public double getPerimeter() {
        return 2 * (this.x2 - this.x1 + this.y2 - this.y1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MyPrettyRectangle other = (MyPrettyRectangle) obj;
        if (Double.doubleToLongBits(x1) != Double.doubleToLongBits(other.x1)) {
            return false;
        }
        if (Double.doubleToLongBits(x2) != Double.doubleToLongBits(other.x2)) {
            return false;
        }
        if (Double.doubleToLongBits(y1) != Double.doubleToLongBits(other.y1)) {
            return false;
        }
        if (Double.doubleToLongBits(y2) != Double.doubleToLongBits(other.y2)) {
            return false;
        }
        return true;
    }
}