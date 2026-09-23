package com.epam.rd.autotasks.triangle;

class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;
    public Triangle(Point a, Point b, Point c) {
        double doubleArea = a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY());
        if(doubleArea == 0){
            throw  new IllegalArgumentException("Triangle is degenerate");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double doubleArea = a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY());
        return Math.abs(doubleArea) / 2.0;
    }

    public Point centroid(){
        double cx = (a.getX() + b.getX() + c.getX()) / 3.0;
        double cy = (a.getY() + b.getY() + c.getY()) / 3.0;
        return  new Point(cx,cy);
    }

}
