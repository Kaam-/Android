package com.Goals.Test.StaticClasses;

import android.util.Log;

public class Combinations
{
    private int bigBlocks, mediumBlocks, smallBlocks;
    private float average, size, weight;

    public Combinations()
    {
        bigBlocks = 0;
        mediumBlocks = 0;
        smallBlocks = 0;
        average = (float)0.00;
        size = (float)0.00;
        weight = (float)0.00;
    }

    public float getAverage() {
        average = (float)(bigBlocks + mediumBlocks + smallBlocks) / (float)3;
        return average;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setBigBlocks(int bigBlocks) {
        this.bigBlocks = bigBlocks;
    }

    public void setMediumBlocks(int mediumBlocks) {
        this.mediumBlocks = mediumBlocks;
    }

    public void setSmallBlocks(int smallBlocks) {
        this.smallBlocks = smallBlocks;
    }

    public int getBigBlocks() {
        return bigBlocks;
    }

    public int getMediumBlocks() {
        return mediumBlocks;
    }

    public int getSmallBlocks() {
        return smallBlocks;
    }

    public float getWeight() {
        weight = getPositiveDifference((float)bigBlocks, getAverage()) + getPositiveDifference((float)mediumBlocks, getAverage()) + getPositiveDifference((float)smallBlocks, getAverage());
        return weight;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getSize() {
        size = (((float)bigBlocks * ((float)1/2)) + ((float)mediumBlocks * ((float)1/4)) + ((float)smallBlocks * ((float)1/6)));
        return size;
    }

    private float getPositiveDifference(float x, float average)
    {
        if(x < average)
        {
            return average-x;
        }
        else
        {
            return x-average;
        }
    }
}