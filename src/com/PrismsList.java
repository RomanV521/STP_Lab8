package com;

import java.util.ArrayList;
import java.util.List;

public class PrismsList {
    private final List<RightPrism> prisms;

    public PrismsList(){
        prisms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Prisms "+ prisms;
    }

    public boolean addPrisms(RightPrism prism){
        return prisms.add(prism);
    }

    public void remove(int num){
        prisms.remove(num);
    }

    public void remove(RightPrism prism){
        prisms.remove(prism);
    }

    public double maxDiagonal(){
        double max = 0;
        for (RightPrism prism : prisms){
            if (max < prism.GetDiagonalPrism()) {
                max = prism.GetDiagonalPrism();
            }
        }
        return max;
    }
}
