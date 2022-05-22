package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public ArrayList<Square> squares;

    public Database(){
        squares = new ArrayList<>();
    }

    /**
     * Добавление объекта
     *
     * @param side
     */
    public void add(double side){
        this.squares.add(new Square(side));
    }

    /**
     * Получение объекта
     *
     * @param index
     * @return
     */
    public Square get(int index){
        return this.squares.get(index);
    }

    /**
     * Удаление объекта
     *
     * @param index
     * @return
     */
    public Square remove(int index){
        return this.squares.remove(index);
    }

    @Override
    public String toString() {
        return "Database{"+ squares + '}';
    }

    /**
     * Сохранение файла с объектами
     *
     * @param filename
     * @throws IOException
     */
    public void save(String filename) throws IOException{
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Square square : squares){
            try {
                bw.write(String.valueOf(square.getSide()));
                bw.write(System.lineSeparator());
//                bw.write(String.valueOf(square.GetPerimeter()));
//                bw.write(System.lineSeparator());
//                bw.write(String.valueOf(square.GetDiagonal()));
//                bw.write(System.lineSeparator());
//                bw.write(String.valueOf(square.GetSquare()));
//                bw.write(System.lineSeparator());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        bw.close();
        outStream.close();
    }

    /**
     * Загрузка файла с объектами
     *
     * @param filename
     * @throws IOException
     */
    public void load(String filename) throws IOException{
        this.clear();
        Scanner scanner = new Scanner(new FileReader(filename));

        double side = -1;
//        double GetPerimeter = -1;
//        double GetDiagonal = -1;
//        double GetSquare = -1;
        while (scanner.hasNextLine()){
            side = Double.parseDouble(scanner.nextLine());
//            GetPerimeter = Integer.valueOf(scanner.nextLine());
//            GetDiagonal = Integer.valueOf(scanner.nextLine());
//            GetSquare = Integer.valueOf(scanner.nextLine());
            this.squares.add(new Square(side));
        }
        scanner.close();
    }

    public void serialize(String filename){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.squares);
            out.close();
            fileOut.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void deserialize(String filename){
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.squares = (ArrayList<Square>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException c){
            System.out.println("Square class not found");
            c.printStackTrace();
        }

    }

    /**
     * Очистка БД
     */
    public void clear(){
        this.squares.clear();
    }
}
