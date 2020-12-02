package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2{
    public static void main(String[] args)
    {
        System.out.println(ueberpruefen("/Users/mariemueller/IdeaProjects/AdventofCode/passwords"));
    }
    public static int ueberpruefen(String datName)
    {
        File file = new File(datName);
        Scanner scan = null;
        int begrenzer1;
        int begrenzer2;
        char x;
        String passwort;
        String zeile;
        int ret = 0;
        int zaehler;
        try{
            scan = new Scanner(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        while(scan.hasNext()){
            zeile = scan.nextLine();
            if(zeile.charAt(1) == '-')
            {
                begrenzer1 = zeile.charAt(0);
                if(zeile.charAt(3) == ' ')
                {
                    begrenzer2 = zeile.charAt(2);
                    x = zeile.charAt(4);
                    passwort = zeile.substring(7);
                }else{
                    begrenzer2 = Integer.parseInt(zeile.substring(2,3));
                    x = zeile.charAt(5);
                    passwort = zeile.substring(8);
                }
            }else{
                begrenzer1 = Integer.parseInt(zeile.substring(0,1));
                begrenzer2 = Integer.parseInt(zeile.substring(3,4));
                x = zeile.charAt(6);
                passwort = zeile.substring(9);
            }
            zaehler = 0;
            for(int i= 0; i<passwort.length(); i++)
            {
                if(passwort.charAt(i) == x)
                {
                    zaehler++;
                }
            }
            if(zaehler >= begrenzer1 && zaehler <= begrenzer2)
            {
                ret++;
            }
        }
        return ret;
    }
}