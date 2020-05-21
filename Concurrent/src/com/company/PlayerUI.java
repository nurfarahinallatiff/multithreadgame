package com.company;

import java.util.Scanner;


public class PlayerUI {

    int n; //Amount of points to be generated concurrently.
    int t; //Amount of threads to run the game.
    int m; //Duration of game in second unit time.
    String initialize; //Yes or No input.
    Scanner playerInput = new Scanner(System.in); //Prompt user input.

    public int getPoint(){
        return n;
    }

    public int getThread(){
        return t;
    }

    public int getTime(){
        return m;
    }

    public void promptUI(){

        //Prompt n value.
        System.out.print("Enter the amount of points wanted: ");
        n = playerInput.nextInt();

        //Prompt t value.
        System.out.print("Enter the amount of threads wanted: ");
        t = playerInput.nextInt();

        //Prompt m value.
        System.out.print("Enter the time limit for programme: ");
        m = playerInput.nextInt();

        //Display all input value.
        System.out.println("\nPoints to generate: " + n);
        System.out.println("Threads to run: " + t);
        System.out.println("Time limit (s): " + m +"\n");
    }

    public void confirmStart(){
        //Confirm game initialization.
        while(true){            
            System.out.println("\nStart the game? Y/N");
            initialize = playerInput.next();

            switch(initialize){
                case ("Y"):
                    System.out.println("\nInitializing game...");
                    break;
                case ("y"):
                    System.out.println("\nInitializing game...");
                    break;
                case "N":
                    System.out.println("\nExit game...");
                    break;
                case "n":
                    System.out.println("\nExit game...");
                    break;
                default:
                    System.out.println("\nInput unrecognizable");
                    break;
            }
            if(initialize.equalsIgnoreCase("y")||initialize.equalsIgnoreCase("n"))
                break;
        }
    }
}