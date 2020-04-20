package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        //Calendar cal = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        System.out.println(anio);
    }
}
