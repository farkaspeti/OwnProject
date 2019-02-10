package com.codecool;

import java.io.*;
import java.util.ArrayList;


public class Data {

    public void writeObjectToFile(String pathName,Vehicles vehicles) {
       /* try {
            FileWriter fw = new FileWriter(pathName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(vehicles);
        }catch(Exception e){

        }
    }*/
            try {

                FileOutputStream fileOut = new FileOutputStream(pathName);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(vehicles);
                objectOut.close();
                System.out.println("The Object  was succesfully written to a file");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
