package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BackupFile {
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
    private String time = "cdds.txt";//format.format(calendar.getTime())+".txt"
    private String date = dateFormat.format(calendar.getTime())+"text.txt";

    public void save (Database db) throws IOException {
        db.save(date);
        System.out.println(time);
    }

    public void load (Database db) throws IOException{
        db.load(date);
    }
}
