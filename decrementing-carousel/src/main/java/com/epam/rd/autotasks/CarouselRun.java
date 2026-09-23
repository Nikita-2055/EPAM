package com.epam.rd.autotasks;

import java.util.List;

public class CarouselRun {

    private final List<Integer> elements;
    private int currentIndex;
    private int remainingCount;

    CarouselRun(List<Integer> elements) {
        this.elements = elements;
        this.currentIndex = 0;
        this.remainingCount = elements.size();
    }

    public int next() {
        if (remainingCount == 0) {
            return -1;
        }

        int size = elements.size();
        int idx = currentIndex;
        while (elements.get(idx) == 0) {
            idx = (idx + 1) % size;
        }

        int value = elements.get(idx);
        elements.set(idx, value - 1);

        if (value - 1 == 0) {
            remainingCount--;
        }

        currentIndex = (idx + 1) % size;

        return value;
    }

    public boolean isFinished() {
        return remainingCount == 0;
    }
}