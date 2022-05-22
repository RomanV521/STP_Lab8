package com;

import java.util.Arrays;

public class Squares {
    private Square[] squares;

    public Squares() {
        squares = new Square[0];
    }

    public Squares(int length) {
        this.squares = new Square[length];
    }

    public Square[] getSquares() {
        return squares;
    }

    public void setSquareAt(int index, Square square) {
        if (index < squares.length)
            squares[index] = square;
    }

    public int maxSquare() {
        int maxIndex = 0;
        for (int i = 1; i < squares.length; i++) {
            if (squares[maxIndex].GetSquare() < squares[i].GetSquare()) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    @Override
    public String toString() {
        return "Squares{" +
                "squares=" + Arrays.toString(squares) +
                '}';
    }
}
