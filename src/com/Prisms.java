package com;

import java.util.Arrays;

public class Prisms {
    private RightPrism[] prisms;
    public RightPrism[] getPrisms(){
        return prisms;
    }

    public Prisms() {
        prisms = new RightPrism[0];
    }
    public Prisms(int length) {
        this.prisms = new RightPrism[length];
    }

    public void setPrismAt(int index, RightPrism prism) {
        prisms[index] = prism;
    }

    public int maxDiagonal(){
        int maxIndex = 0;
        for (int i = 0; i< prisms.length; i++){
            if (prisms[maxIndex].GetSquare()< prisms[i].GetSquare()) {
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    @Override
    public String toString() {
        return "Prisms{" +
                "Prisms=" + Arrays.toString(prisms) +
                '}';
    }
}
