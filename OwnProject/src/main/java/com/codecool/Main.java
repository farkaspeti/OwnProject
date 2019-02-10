package com.codecool;

// import java.util.Scanner;
// import java.util.Date;

import com.codecool.dao.TruckDataBase;

public class Main{
    public static void main(String[] args){
        Menu menu = new Menu();
        TruckDataBase truckDataBase = TruckDataBase.getDataBase();
        menu.start();
    }
}
        
