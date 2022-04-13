package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {
    private final int[] container;
    private int i = 0, j = 0;
    private int sum = 0;
    private final int flag;
    private int decrement = 1;
    private int actionLimit;

    public CarouselRun (int[] container) {
        this.container = Arrays.copyOf(container, container.length);
        flag = 0;
        for (int elem : container ) {
            sum += elem;
        }
    }

    public CarouselRun (int[] container, int flag) {
        this.container = Arrays.copyOf(container, container.length);
        this.flag = flag;
        for (int elem : container ) {
            sum += elem;
        }
    }

    public CarouselRun (int[] container, int flag, int actionLimit) {
        this.container = Arrays.copyOf(container, container.length);
        this.flag = flag;
        this.actionLimit = actionLimit;
        for (int elem : container ) {
            sum += elem;
        }
    }

    public int next() {
        //throw new UnsupportedOperationException();
        int tempElem;
        if (isFinished()) {     //container is empty
            return -1;
        }
        if (i == container.length) {
            i = 0;
            decrement++;
        }
        while (container[i] <= 0) {
            i++;
            if (i == container.length) {
                i = 0;
                decrement++;
            }
        }
        if (flag == 0) {
            sum--;
            return container[i++]--;
        } else if (flag == 1) {
            tempElem = container[i];
            container[i] /= 2;
            sum = sum - container[i] - tempElem % 2;
            i++;
            return tempElem;
        } else if (flag == 2) {
            tempElem = container[i];
            container[i] -= decrement;
            //System.out.println("decrement = " + decrement + " temp container = " + tempElem + " container = " + container[i]);
            i++;
            return tempElem;
        } else {
            sum--;
            j++;
            return container[i++]--;
        }
    }


    public boolean isFinished() {
        //throw new UnsupportedOperationException();
        if (flag == 2) {
            for (int elem : container) {
                if (elem > 0) {
                    return false;
                }
            }
            return true;
        } else if (flag == 3 && j == actionLimit) {
            return true;
        } else {
            return sum == 0;
        }
    }
}

