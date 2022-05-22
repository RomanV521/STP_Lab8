package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Vykhodets Roman, #1
 */
public class Main {

    private static void Start() {
        System.out.println("\nCompleted by student AT-212 \nOdessa Polytechnic University \nVykhodets Roman \n\nVariant 1 \n\n");
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Start();

//        System.out.println("Создать класс квадрат, члены класса – длина стороны.\nПредусмотреть в классе методы вычисления и вывода сведений о фигуре – диагональ, периметр, площадь.\nСоздать производный класс – правильная квадратная призма с высотой H,\nдобавить в класс метод определения объема фигуры, перегрузить методы расчета площади и вывода сведений о фигуре.\nНаписать программу, демонстрирующую работу с этими классами:\n\tдано N квадратов и M призм, найти квадрат с максимальной площадью и призму с максимальной диагональю.\n\n");

        Square square = new Square();
        Squares squares;
        SquaresList squaresList = new SquaresList();
        RightPrism prism = new RightPrism();
        Prisms prisms;
        PrismsList prismsList = new PrismsList();

        int numSquares = 0;
        int numPrisms = 0;

        Database db = new Database();
        int variant;
        BackupFile backupFile = new BackupFile();

        do {
            System.out.println("Введите вариант загрузки:");
            System.out.println("\t0 - ввести свои значения");
            System.out.println("\t1 - загрузить последнюю резервную копию");
            System.out.print(":");
            variant = scan.nextInt();
        }while ((variant != 1 ) && (variant != 0));

        if (variant == 0){
            System.out.print("\nВведите количество квадратов:");
            numSquares = scan.nextInt();
            squares = new Squares(numSquares);

            System.out.print("Введите количество призм:");
            numPrisms = scan.nextInt();
            prisms = new Prisms(numPrisms);
        }
        else{
            System.out.println("Загрузка...");
            backupFile.load(db);
        }

//        part1(square, squares, prism, prisms, numSquares, numPrisms);
//        part2(square, squaresList, prism, numSquares, numPrisms, prismsList);
        part3(square, db, prism, numSquares, numPrisms);

//        db.save("db.txt");
//        db.clear();
//        db.load("db.txt");
        db.serialize("DB_Ser.txt");
        db.deserialize("DB_Ser.txt");

        System.out.println("Loaded Database: " + db);

//        backupFile.save(db);
    }

    private static void part1(Square square, Squares squares, RightPrism prism, Prisms prisms, int numSquares, int numPrisms) {
        int side;
//        System.out.println("\n\nКвадраты:");
        for (int i = 0; i < numSquares; i++) {
            side = -1;
            while (square.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0) {//-5...5
//                System.out.println(side);
            }
            square = new Square(side);
            squares.setSquareAt(i, square);
//            System.out.println(square + "\n");
        }

        int height;
//        System.out.println("\n\nПризмы:");
        for (int i = 0; i < numPrisms; i++) {
            side = -1;
            height = -1;
            while (prism.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0 || prism.CheckCorrectHeight("" + (height = (int) (Math.random() * 11 + 5))) < 0) {
//                System.out.println("\n"+side +"\n"+ height+"\n");
            }
            prism = new RightPrism(side, height);
            prisms.setPrismAt(i, prism);
//            System.out.println(prism + "\n");
        }

        System.out.println(squares +"\n\n"+ prisms);
        System.out.println("\n Квадрат с максимальной площадью: " + squares.getSquares()[squares.maxSquare()]);
        System.out.println("\n Призма с максимальной диагональю: " + prisms.getPrisms()[prisms.maxDiagonal()]);
    }

    private static void part2(Square square, SquaresList squaresList, RightPrism prism, int numSquares, int numPrisms, PrismsList prismsList) {
        int side;
//        System.out.println("\n\nКвадраты:");
        for (int i = 0; i < numSquares; i++) {
            side = -1;
            while (square.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0) {//-5...5
            }
            square = new Square(side);
            squaresList.addSquare(square);
        }

        int height;
//        System.out.println("\n\nПризмы:");
        for (int i = 0; i < numPrisms; i++) {
            side = -1;
            height = -1;
            while (prism.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0 || prism.CheckCorrectHeight("" + (height = (int) (Math.random() * 11 + 5))) < 0) {
            }
            prism = new RightPrism(side, height);
            prismsList.addPrisms(prism);
        }

        System.out.println(squaresList +"\n\n"+ prismsList);
        System.out.println("\n Квадрат с максимальной площадью: " + squaresList.maxSquare());
        System.out.println("\n Призма с максимальной диагональю: " + Formatter.toDouble(prismsList.maxDiagonal()));
    }

    /**
     * Реализовать сериализацию/десериализацию данных в файл/из файла на диске для Задания №6 в виде отдельного класса с методами Save и Load (2 балла).
     * Использовать независимых 2 способа: нативную Java-сериализацию и любую внешнюю библиотеку (2 балла).
     * Предусмотреть автоматическое создание новой резервной копии файла данных при завершении работы программы, имя файла - метка времени (1 балл)
     * Реализовать восстановление данных из последней созданной копии при запуске (1 балл).
     */
    private static void part3(Square square, Database db, RightPrism prism, int numSquares, int numPrisms){
        double side;
//        System.out.println("\n\nКвадраты:");
        for (int i = 0; i < numSquares; i++) {
            side = -1;
            while (square.CheckCorrectSide("" + (side = (int) (Math.random() * 11 - 5))) < 0) {//-5...5
            }
            db.add(side);
        }
    }
}

