package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    private final int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run(){
        //throw new UnsupportedOperationException();
        if (getFlagRun() == 1) {
            return null;
        }
        setFlagRun((byte) 1);
        return new CarouselRun(getContainer(), 3, actionLimit);
    }
}
