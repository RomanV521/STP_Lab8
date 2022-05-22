package com;

public class RightPrism extends Square {
    private double height;

    public RightPrism() {

    }

    public RightPrism(double side, double height) {
        super(side);
        this.setHeight(height);
    }

    public static double CheckCorrectHeight(String value) {
        double height = -1;
        try {
            if (Double.parseDouble(value) > 0) {
                height = Double.parseDouble(value);
            } else {
                height = -1;
            }

        } catch (Exception e) {

        }
        return height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double GetVolume() { //объем
        return super.GetSquare() * height;
    }

    public double GetDiagonalPrism() {
        return getSide() * Math.sqrt(3);
    }

    @Override
    public double GetSquare() {
        return 2 * super.GetSquare() + 4 * getSide() * height;
    }

    @Override
    public String toString() {
        return "\n" +
                "\tSide = " + Formatter.toDouble(getSide()) +
                "\tHeight = " + Formatter.toDouble(height) +
                "\tVolume = " + Formatter.toDouble(GetVolume()) +
                "\tSquare Prism = " + Formatter.toDouble(GetSquare()) +
                "\tDiagonal Prism = " + Formatter.toDouble(GetDiagonalPrism());
    }
}
