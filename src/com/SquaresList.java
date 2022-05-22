package com;

import java.util.ArrayList;
import java.util.List;

public class SquaresList {
    private final List<Square> squares;

    public SquaresList(){
        squares = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Squares "+ squares;
    }

    public boolean addSquare(Square square){
        return squares.add(square);
    }

    public void remove(int num){
        squares.remove(num);
    }

    public void remove(Square square){
        squares.remove(square);
    }

    public double maxSquare() {
        double max = 0;
        for (Square square : squares) {
            if (max < square.GetSquare()) {
                max = square.GetSquare();
            }
        }
        return max;
    }
}
