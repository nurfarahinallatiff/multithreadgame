package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
	    Scanner user_input = new Scanner(System.in);
	    int n;
        System.out.print("Enter the amount of points wanted: ");
        n =user_input.nextInt();

        int t;
        System.out.print("Enter the amount of threads wanted: ");
        t =user_input.nextInt();

        int m;
        System.out.print("Enter the time limit for programme: ");
        m =user_input.nextInt();

        System.out.println("Value n:"+n);
        System.out.println("Value t:"+t);
        System.out.println("Value m1:"+m);

    }
}
