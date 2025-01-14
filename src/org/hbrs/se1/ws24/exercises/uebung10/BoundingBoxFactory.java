package org.hbrs.se1.ws24.exercises.uebung10;

public class BoundingBoxFactory {
    public static MyPrettyRectangle getBoundingBox(MyPrettyRectangle[] rect) {
        if(rect == null)
            return null;
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        if(rect.length > 0) {
            x1 = rect[0].getX1();
            y1 = rect[0].getY1();
            x2 = rect[0].getX2();
            y2 = rect[0].getY2();
        }
        for(MyPrettyRectangle r : rect) {
            if(r.getX1() < x1)
                x1 = r.getX1();
            if(r.getY1() < y1)
                y1 = r.getY1();
            if(r.getX2() > x2)
                x2 = r.getX2();
            if(r.getY2() > y2)
                y2 = r.getY2();
        }
        return new MyPrettyRectangle(x1, y1, x2, y2);
    }
}