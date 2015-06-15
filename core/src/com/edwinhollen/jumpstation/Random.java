package com.edwinhollen.jumpstation;

import java.time.Instant;

/**
 * Created by Edwin on 6/14/2015.
 */
public class Random extends java.util.Random {
    public Random(long seed){
        this.setSeed(seed);
    }
    public Random(){
        super(Instant.now().getEpochSecond());
    }
    public int nextInt(int min, int max){
        return this.nextInt(max - min) + min;
    }
}
