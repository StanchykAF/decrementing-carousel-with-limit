package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private final int[] container;
    private byte flagRun = 0;
    private int i = 0;
    private final int capacity;

    public DecrementingCarousel(int capacity) {
        if (capacity <= 0 ) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        container = new int[capacity];

    }

    public byte getFlagRun() {
        return flagRun;
    }

    public void setFlagRun(byte flagRun) {
        this.flagRun = flagRun;
    }

    public int[] getContainer() {
        return container;
    }

    public boolean addElement(int element){
        //throw new UnsupportedOperationException();
        if (flagRun == 1) {         //DecrementingCarousel is in running state
            return false;
        }
        if (element <= 0) {         //Illegal argument
            return false;
        }
        if (i >= capacity) {        //Container is full
            return false;
        }
        container[i] = element;     //Adding of element to container
        i++;
        return true;
    }

    public CarouselRun run(){
        //throw new UnsupportedOperationException();
        if (flagRun == 1) {
            return null;
        }
        flagRun = 1;
        return new CarouselRun(container);
    }
}
