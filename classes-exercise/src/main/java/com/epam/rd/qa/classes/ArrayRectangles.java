package com.epam.rd.qa.classes;

public class ArrayRectangles {

    private Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        rectangleArray = new Rectangle[size];
    }

    public ArrayRectangles(Rectangle... rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        rectangleArray = new Rectangle[rectangles.length];
        System.arraycopy(rectangles, 0, rectangleArray, 0, rectangles.length);
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] == null) {
                rectangleArray[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (Rectangle r : rectangleArray) {
            if (r != null) count++;
        }
        return count;
    }

    public int indexMaxArea() {
        if (size() == 0) return -1;

        int index = -1;
        double maxArea = -1;

        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] != null) {
                double area = rectangleArray[i].area();
                if (area > maxArea) {
                    maxArea = area;
                    index = i;
                }
            }
        }
        return index;
    }

    public int indexMinPerimeter() {
        if (size() == 0) return -1;

        int index = -1;
        double minPerimeter = Double.MAX_VALUE;

        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] != null) {
                double p = rectangleArray[i].perimeter();
                if (p < minPerimeter) {
                    minPerimeter = p;
                    index = i;
                }
            }
        }
        return index;
    }

    public int numberSquares() {
        int count = 0;
        for (Rectangle r : rectangleArray) {
            if (r != null && r.isSquare()) {
                count++;
            }
        }
        return count;
    }
}