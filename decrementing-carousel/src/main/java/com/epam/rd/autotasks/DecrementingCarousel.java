package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;

public class DecrementingCarousel {

    private final int capacity;
    private final List<Integer> elements = new ArrayList<>();
    private boolean started = false;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addElement(int element) {
        if (element <= 0) {
            return false;
        }
        if (started) {
            return false;
        }
        if (elements.size() >= capacity) {
            return false;
        }
        elements.add(element);
        return true;
    }

    public CarouselRun run() {
        if (started) {
            return null;
        }
        started = true;
        return new CarouselRun(elements);
    }
}