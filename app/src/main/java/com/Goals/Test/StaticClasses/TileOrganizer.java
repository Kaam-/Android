package com.Goals.Test.StaticClasses;

import com.Goals.Test.DataClasses.Goal;

import java.util.List;

/**
 * Created by Drew on 1/15/14.
 */
public class TileOrganizer {

    private Combinations[] sizeCombos;

    public TileOrganizer(List<Goal> goals)
    {
        sizeCombos = new Combinations[goals.size()*2];
        for(int i = 0; i < goals.size()*2; i++)
            sizeCombos[i] = new Combinations();
    }

    private void setCombination(int position, int big, int medium, int small)
    {
        sizeCombos[position].setBigBlocks(big);
        sizeCombos[position].setMediumBlocks(medium);
        sizeCombos[position].setSmallBlocks(small);
    }

    public Combinations createCombinations()
    {
        int pointer = 0;
        int a, b, c = 0;
        int maxLength = sizeCombos.length/2;

        for(a = 0; a < maxLength; a++)
        {
            for(b = 0; b < maxLength; b = b + 2)
            {
                for(c = 0; c < maxLength; c = c + 3)
                {
                    int total = a + b + c;
                    if(total == maxLength && a != 0)
                    {
                        setCombination(pointer, a, b, c);
                        pointer++;
                    }
                }
                int total = a + b + c;
                if(total == maxLength && a != 0)
                {
                    setCombination(pointer, a, b, c);
                    pointer++;
                }
            }
            int total = a + b + c;
            if(total == maxLength && a != 0)
            {
                setCombination(pointer, a, b, c);
                pointer++;
            }
        }

        return getLowestDRandTotal(sizeCombos, maxLength);
    }

    private Combinations getLowestDRandTotal(Combinations[] sizeCombos, int maxLength)
    {
        float lowestTotal = (float)10.00;
        float lowestDR = (float)10.00;
        int position = 0;

        for(int i = 0; i < maxLength; i++)
        {
            if(sizeCombos[i].getWeight() < lowestDR && sizeCombos[i].getWeight() > 0.00)
            {
                lowestDR = sizeCombos[i].getWeight();
                lowestTotal = sizeCombos[i].getSize();
                position = i;
            }
            else if(sizeCombos[i].getWeight() == lowestDR && sizeCombos[i].getSize() < lowestTotal && sizeCombos[i].getWeight() > 0.00 && sizeCombos[i].getSize() > 0.00)
            {
                lowestDR = sizeCombos[i].getWeight();
                lowestTotal = sizeCombos[i].getSize();
                position = i;
            }
        }

        return sizeCombos[position];
    }

}
