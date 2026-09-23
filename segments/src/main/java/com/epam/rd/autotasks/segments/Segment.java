package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        if(start.getX() == end.getX() && start.getY() == end.getY()){
            throw new IllegalArgumentException("Segment is degernerate");
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    Point middle() {
        double mx = (start.getX() + end.getX()) / 2.0;
        double my = (start.getY() + end.getY()) / 2.0;
        return new Point(mx,my);
    }

    Point intersection(Segment another) {
        double x1 = this.start.getX(), y1 = this.start.getY();
        double x2 = this.end.getX(), y2 = this.end.getY();
        double x3 = another.start.getX(), y3 = another.start.getY();
        double x4 = another.end.getX(), y4 = another.end.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if(denominator == 0){
            return null;
        }
        double tNumerator = (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4);
        double uNumerator = (x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2);

        double t = tNumerator / denominator;
        double u = uNumerator / denominator;

        if(t < 0 || t > 1 || u < 0 || u > 1){
            return null;
        }
        double ix = x1 + t * (x2 - x1);
        double iy = y1 + t * (y2 - y1);
        return new Point(ix,iy);
    }

}
